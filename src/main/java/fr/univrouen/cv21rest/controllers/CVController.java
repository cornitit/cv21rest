package fr.univrouen.cv21rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class CVController {
	@GetMapping("/resume")
	public String getListCVinXML() {
		return"Envoi de la liste des CV";
	}
	@GetMapping("/id")
	public String getCVinXML() {
		return"Détail du CV demandé";
	}
}
