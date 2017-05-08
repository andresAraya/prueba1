package cl.mineduc.worker_encasillamiento.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.mineduc.worker_encasillamiento.modelo.InicioGrado;
import cl.mineduc.worker_encasillamiento.repo.ProcesoRepo;

@Service
public class NotificacionService {

	private Logger log = Logger.getLogger(getClass());
	
	@Autowired
	private ProcesoRepo repoProceso;
	
	
	public void iniciarNotificacion(){
		List<InicioGrado> inicioGrado = repoProceso.getObtenerGradosParaProcesarWorker();
		if(inicioGrado.size() > 0){
			
		}
	}

	
	
}
