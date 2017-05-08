package cl.mineduc.worker_encasillamiento.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import cl.mineduc.worker_encasillamiento.modelo.InicioProce;
import cl.mineduc.worker_encasillamiento.repo.ProcesoRepo;

@Service
public class DefaultService {
	private static Logger logger = LogManager.getLogger(DefaultService.class);
	
	@Autowired 
	private Environment env;
	
	@Autowired
	private ProcesoRepo repoProceso;
	@Autowired
	private OrdenListasService servicioOrdenarListas;
	@Autowired
	private NotificacionService servicioNotificacion;
	
	

	/**
	 * Metodo principal que se ejecuta y se lanzan las dos metodos a ejecutar de ordenamiento y notificacion
	 */
	//@Scheduled(cron="0/5 * * * * ? ")
	@Scheduled(cron="15 * * * * ?")
	public void ejecutarTareaOrdenamientoYnotificacion(){
		InicioProce inipro = repoProceso.getObtenerEstadoProcesoWorker();
		if(inipro.getIniProEstado() == 1){
			logger.debug("INICIA EL PROCESO ORDENANDO LAS LISTAS");
			servicioOrdenarListas.ordenarSeleccion();
			
			logger.debug("INICIA LA NOTIFICACION DE LOS SELECCIONADOS.");
			

		}else{
			logger.debug("EL PROCESO ESTA APAGADO");
		}
	}
}