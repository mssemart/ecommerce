package br.com.emart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	
	@RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
	public String pesquisa() {
		
		return "pesquisa";
	}	
}
