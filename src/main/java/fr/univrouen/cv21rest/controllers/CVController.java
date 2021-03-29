package fr.univrouen.cv21rest.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CVController {
	@GetMapping("/help")
	public String helpXML() {
		return"explique comment que ça marche";
	}
	@GetMapping("/resume")
	public String resumeXML() {
		return"coucou resume";
	}
	
//	@GetMapping("/id")
//	public String getCVinXML(
//		@RequestParam(value = "name") String texte) {
//		return ("Détail du CV demandé : " + texte);
//	}
//	@GetMapping("/test")
//	public String gettestXML(
//		@RequestParam(value = "nb") String texte, @RequestParam(value = "texte") String texte2) {
//		return ("Test : </br> id = " + texte+"</br> titre = " + texte2);
//	}
	

	@GetMapping("/")
	public String accueilXML() {
		String page = "";
		
		page += "<!DOCTYPE html>";
		page += "<html>";
		page += "<head>";
		page += "<title>Projet web XML</title>";
		page += "</head>";
		page += "<body>";
		page += "<h1>Projet Web XML</h1>";
		page += "<p>v0.1</br>Lassire Eden & Cornilleau Titouan</p>";
		//page += "<img src=\"/images/Universite_de_Rouen.jpg\"></img>";
		page += "</body>";
		page += "</html>";
		
		return page ;
	}
		
		
	
	
}
