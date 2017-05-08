package cl.mineduc.worker_encasillamiento.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mineduc.worker_encasillamiento.modelo.EstadosRanking;
import cl.mineduc.worker_encasillamiento.modelo.InicioGrado;
import cl.mineduc.worker_encasillamiento.modelo.Ranking;
import cl.mineduc.worker_encasillamiento.repo.ProcesoRepo;

@Service
public class OrdenListasService {

	private Logger log = Logger.getLogger(getClass());
	@Autowired
	private ProcesoRepo repoProceso;
	
	
	public void ordenarSeleccion(){
		/*OBTENGO DATOS Y PREGUNTO SI LA LISTA CONTIENE DATOS A SER PROCESADOS PARA SELECCION Y NOTIFICACION*/
		List<InicioGrado> inicioGrado = repoProceso.getObtenerGradosParaProcesarWorker();
		if(inicioGrado.size() > 0){
			List<EstadosRanking> estadosRanking = repoProceso.getObtenerRankingDeGradosSeleccionados(inicioGrado);
			if(estadosRanking.size() > 0){
				/*RECORRO LA LISTA PARA VER SI ESTA COMPLETA O EFECTUAR EL PROCESO DE SELECCION*/
				for(EstadosRanking er : estadosRanking){
					/*PREGUNTO SI ESTA FINALIZADA CON LOS CARGOS LISTOS*/
					if(er.getAceptadosEstadoRanking() != er.getEstadoRestantes()){
						/*OBTENGO LOS RESULTADOS DEL RANKING EN EJECUCION PARA EL PROCESO DE SELECCION*/
						List<Ranking> actual = this.getObtenerRankingParaProcesoDeSeleccion(er);
						if(actual.size() > 0){
							for(Ranking ra : actual){
								if(ra.getEstado() == 0){
									/*CAMBIO EL ESTADO EN EL OBJETO PARA GUARDARLO */
									ra.setEstado(1);
									/*GUARDO EL ESTADO QUE SE ENCUENTRA SELECCIONADO DEL POSTULANTE*/
									repoProceso.getActualizarRankingEnProcesoDeSeleccion(ra);									
									/*GUADO EN LA TABLA TEMPORAL PARA LA NOTIFICACION DE ESTE*/
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * Metodo para obtener los ranking que se entan procesando su seleccion
	 * @param er
	 * @return
	 */
	public List<Ranking> getObtenerRankingParaProcesoDeSeleccion(EstadosRanking er){
		List<Ranking> rankingActual = repoProceso.getObtenerRankingParaProcesoDeSeleccion(er);
		return rankingActual;
	}	
}
