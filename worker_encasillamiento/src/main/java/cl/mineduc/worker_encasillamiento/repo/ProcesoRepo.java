package cl.mineduc.worker_encasillamiento.repo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import cl.mineduc.framework2.exceptions.MineducException;
import cl.mineduc.worker_encasillamiento.mappers.ProcesoMapper;
import cl.mineduc.worker_encasillamiento.modelo.EstadosRanking;
import cl.mineduc.worker_encasillamiento.modelo.InicioGrado;
import cl.mineduc.worker_encasillamiento.modelo.InicioProce;
import cl.mineduc.worker_encasillamiento.modelo.Ranking;

@Repository("procesoRepo")
public class ProcesoRepo {
	private static Logger log = LogManager.getLogger(ProcesoRepo.class);

		@Autowired
		private ProcesoMapper procesoMapper;
		
		/**
		 * Metodo que trae de la base de datos el permiso para ejecutar el worker
		 * @return
		 */
		public InicioProce getObtenerEstadoProcesoWorker(){
			try {
				return (InicioProce) procesoMapper.getObtenerEstadoProcesoWorker();
			} catch (DataAccessException e) {
				log.error("Error de base de datos al ingrear una entidad", e);
				throw new MineducException("Error de base de datos al ingrear una entidad", e);
			}
		}
		
		
		/**
		 * Metodo que obtiene de la base de datos los grados seleccionados para ser ordenados y notificados
		 * @return
		 */
		public List<InicioGrado> getObtenerGradosParaProcesarWorker(){
			try{
				return (List<InicioGrado>) procesoMapper.getObtenerGradosParaProcesarWorker();
			}catch(DataAccessException ex){
				log.error("ERROR AL OBTENER LOS GRADOS A PROCESAR, "+ex);
				throw new MineducException("ERROR AL OBTENER LOS GRADOS PARA PROCESAR SELECCION Y NOTIFICACION, ", ex);
			}
		}
		
		
		
		/**
		 * Metodo que obtiene los ranking por grado para su seleccion.
		 * @param list
		 * @return
		 */
		public List<EstadosRanking> getObtenerRankingDeGradosSeleccionados(List<InicioGrado> list){
			try{
				return (List<EstadosRanking>) procesoMapper.getObtenerRankingDeGradosSeleccionados(list);
			}catch(DataAccessException ex){
				throw new MineducException("ERROR AL OBTENER LOS DATOS DE RANKING PARA LA SELECCION, " + ex);
			}
		}
		
		
		/**
		 * Obtengo el ranking por limit solo los cupos 
		 * @param er
		 * @return
		 */
		public List<Ranking> getObtenerRankingParaProcesoDeSeleccion(EstadosRanking er){
			try{
				return (List<Ranking>)procesoMapper.getObtenerRankingParaProcesoDeSeleccion(er);
			}catch(DataAccessException ex){
				throw new MineducException("ERROR AL OBTENER EL RANKING PARA EMPEZAR A PROCESAR A LOS SELECCINADOS, " + ex);
			}
		}
		
		
		/**
		 * MEtodo que actualiza un seleccionado de un ranking (sus estados)
		 * @param r
		 */
		public void getActualizarRankingEnProcesoDeSeleccion(Ranking r){
			try{
				procesoMapper.getActualizarRankingEnProcesoDeSeleccion(r);
			}catch(DataAccessException ex){
				throw new MineducException("ERROR AL ACTUALIZAR EL ESTADO DEL SELECCIONADO DE UN RANKING, " + ex);
			}
		}
}