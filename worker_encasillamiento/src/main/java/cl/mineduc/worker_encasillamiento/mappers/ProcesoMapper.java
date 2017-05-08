package cl.mineduc.worker_encasillamiento.mappers;


import java.util.List;

import cl.mineduc.worker_encasillamiento.modelo.EstadosRanking;
import cl.mineduc.worker_encasillamiento.modelo.InicioGrado;
import cl.mineduc.worker_encasillamiento.modelo.InicioProce;
import cl.mineduc.worker_encasillamiento.modelo.Ranking;

public interface ProcesoMapper {
	
	InicioProce getObtenerEstadoProcesoWorker();
	List<InicioGrado> getObtenerGradosParaProcesarWorker();
	List<EstadosRanking> getObtenerRankingDeGradosSeleccionados(List<InicioGrado> list);
	List<Ranking> getObtenerRankingParaProcesoDeSeleccion(EstadosRanking er);
	void getActualizarRankingEnProcesoDeSeleccion(Ranking r);
}