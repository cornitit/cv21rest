package fr.univrouen.cv21rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CVController {
	@GetMapping("/resume")
	public String getListCVinXML() {
		return"Envoi de la liste des CV";
	}
	
	@GetMapping("/id")
	public String getCVinXML(
		@RequestParam(value = "name") String texte) {
		return ("Détail du CV demandé : " + texte);
	}
	@GetMapping("/test")
	public String gettestXML(
		@RequestParam(value = "nb") String texte, @RequestParam(value = "texte") String texte2) {
		return ("Test : </br> id = " + texte+"</br> titre = " + texte2);
	}
	
	
}
