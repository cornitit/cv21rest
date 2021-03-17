package fr.univrouen.cv21rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class CVController {
	@GetMapping("/resume")
	public String getListCVinXML() {
		return"Envoi de la liste des CV";
	}
	@GetMapping("/id")
	public String getCVinXML() {
		return"Détail du CV demandé";
	}
	/*@GetMapping("/id")
	public String getCVinXML(
		@RequestParam(value = "name") String texte) {
		return ("Détail du CV demandé : " + texte);
	}*/
}
