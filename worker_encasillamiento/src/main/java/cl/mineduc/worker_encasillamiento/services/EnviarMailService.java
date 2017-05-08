package cl.mineduc.worker_encasillamiento.services;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.MimeTypeUtils;

import cl.mineduc.framework2.exceptions.MineducException;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Service
public class EnviarMailService{ 

	private static Logger logger = LogManager.getLogger(EnviarMailService.class);
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Autowired
	Configuration configuration;
	
	@Value("${send.to.email}")
	private String toEmail;
	
	@Value("${send.from.email}")
	private String fromEmail;	
	
	

	public void onMessage() {
		MimeMessage mail = javaMailSender.createMimeMessage();

			try {
				prepareTemplateMail(mail);
				prepareMail(mail);
				
				javaMailSender.send(mail);
				
			} catch (IOException e) {
				logger.error("Error de IO JSON", e);
				throw new MineducException("Error de IO JSON", e);
			} catch (TemplateException e) {
				logger.error("Error de freemarker mail template",e);
				throw new MineducException("Error de freemarker mail template" , e);
			} catch (MessagingException e) {
				logger.error("Error de envío de mail", e);
				throw new MineducException("Error de envío de mail", e);
			}		
		mail = null;
	}

	
	private void prepareMail(MimeMessage mail) throws MessagingException, UnsupportedEncodingException {
		MimeMessageHelper helper = new MimeMessageHelper(mail, "UTF-8");
		helper.setTo(new InternetAddress("arnaldo.araya@mineduc.cl", "Arnaldo araya"));
		helper.setReplyTo(new InternetAddress("araya.arnaldo@gmail.com","Prueba Notificacion Aceptacion"));
		helper.setFrom(new InternetAddress("noreply@mineduc.cl","Prueba Notificacion Aceptacion"));
		helper.setSubject("Notificación de Cargos Seleccionados");
	}
	
	private void prepareTemplateMail(MimeMessage mail) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException, MessagingException{
		Map<String, Object> marcaMap = new HashMap<String,Object>();
		
		Template mailTemplate = configuration.getTemplate("mailNotidicacionResultados.ftl");
		String parsedTemplate = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, marcaMap);
		logger.debug(parsedTemplate);
		mail.setContent(parsedTemplate, MimeTypeUtils.TEXT_HTML_VALUE);
	}

}
