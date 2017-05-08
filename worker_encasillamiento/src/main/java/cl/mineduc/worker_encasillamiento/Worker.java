/**
 * 
 */
package cl.mineduc.worker_encasillamiento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;

/**
 * @author Alvaro Tellez
 *
 */
public class Worker {
	private static Logger logger = LogManager.getLogger(Worker.class);
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WorkerConfiguration.class, args);
		System.out.println(Worker.class.getCanonicalName()+ " has debug enabled :"+logger.isDebugEnabled());
	}
}
