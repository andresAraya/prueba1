package cl.mineduc.worker_encasillamiento.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

	@RequestMapping(value = "index", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index(@RequestParam(required = false) Integer error){
		ModelAndView mv = new ModelAndView();

		return mv;
	}
}
