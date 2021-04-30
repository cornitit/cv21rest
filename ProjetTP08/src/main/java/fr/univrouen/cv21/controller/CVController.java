package fr.univrouen.cv21.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import XSLTTransformer.TransformXSLT;
import fr.univrouen.cv21.ProjetTp08Application;
import fr.univrouen.cv21.model.CV21;
import fr.univrouen.cv21.repository.CVRepository;



@RestController
public class CVController {

	@Autowired
	private CVRepository cvRepository;


	@GetMapping(value="/help", produces = MediaType.TEXT_HTML_VALUE)
	public String helpXML() {
		ProjetTp08Application.logger.info("affichage de la page d'aide");
		String page = "";

		page += "<!DOCTYPE html>";
		page += "<html>";
		page += "<head>";
		page += "<title>Projet web XML</title>";
		page += "</head>";
		page += "<body>";
		page += "<h1>Projet Web XML</h1>";
		page += "<p>fonctionnement de l'application </p>";
		page += "<p>Afin de faire fonctionner le projet, vous devez utiliser POSTMAN pour faire vos requetes</p>";
		page += "<h1>exemple de requetes</h1>";
		page += "<p>{{url}} est une variable locale que nous avons définie dans Postman. Elle correspond dans notre cas à : http://localhost:6039\r\n"
				+ "\r\n</br>"
				+ "1 - Récupération de l’ensemble des CV\r\n</br>"
				+ "\r\n</br>"
				+ "commande GET :  {{url}}/resume\r\n</br>"
				+ "\r\n</br>"
				+ "2 - Créer un nouveau CV\r\n</br>"
				+ "\r\n</br>"
				+ "commande POST :  {{url}}/insert\r\n</br>"
				+ "BODY XML  (exemple de body utilisé)\r\n</br>"
				+ "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n</br>"
				+ "<p:cv21 xmlns:p=\"http://univ.fr/cv21\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" >\r\n</br>"
				+ "  <p:identitie>\r\n</br>"
				+ "    <genre>M</genre>\r\n</br>"
				+ "    <nom>cornilleau</nom>\r\n</br>"
				+ "    <prenom>titouan</prenom>\r\n</br>"
				+ "    <tel>0123456789</tel>\r\n</br>"
				+ "    <mel>mail@mail.fr</mel>\r\n</br>"
				+ "  </p:identitie>\r\n</br>"
				+ "  <p:objectif emploi=\"\" stage=\"\"/>\r\n</br>"
				+ "  <p:prof>\r\n</br>"
				+ "    <expe>\r\n</br>"
				+ "      <datedeb>2001-01-01</datedeb>\r\n</br>"
				+ "      <datefin>2001-01-01</datefin>\r\n</br>"
				+ "      <titre>titre3</titre>\r\n</br>"
				+ "    </expe>\r\n</br>"
				+ "  </p:prof>\r\n</br>"
				+ "  <p:competences>\r\n</br>"
				+ "    <diplome niveau=\"\">\r\n</br>"
				+ "      <date>2001-01-01</date>\r\n</br>"
				+ "      <titre>titre</titre>\r\n</br>"
				+ "      <etab>etab</etab>\r\n</br>"
				+ "    </diplome>\r\n</br>"
				+ "    <certif>\r\n</br>"
				+ "      <datedeb>2001-01-01</datedeb>\r\n</br>"
				+ "      <datefin>2001-01-01</datefin>\r\n</br>"
				+ "      <titre>titre</titre>\r\n</br>"
				+ "    </certif>\r\n</br>"
				+ "  </p:competences>\r\n</br>"
				+ "  <p:divers>\r\n</br>"
				+ "    <lv cert=\"\" lang=\"\" nivi=\"0\" nivs=\"\"/>\r\n</br>"
				+ "    <autre comment=\"\" titre=\"\"/>\r\n</br>"
				+ "  </p:divers>\r\n</br>"
				+ "</p:cv21>\r\n</br>"
				+ " \r\n</br>"
				+ "3 - Affichage de la page d’accueil\r\n</br>"
				+ "\r\n</br>"
				+ "commande GET : {{url}}/\r\n</br>"
				+ "\r\n</br>"
				+ "4 - Affichage de la page d’aide \r\n</br>"
				+ "\r\n</br>"
				+ "commande GET : {{url}}/help\r\n</br>"
				+ "\r\n</br>"
				+ "5 - Affichage d’un cv au format html\r\n</br>"
				+ "\r\n</br>"
				+ "commande GET : {{url}}/htmlcv?id=608a9bab39938617a0ab45f7\r\n</br>"
				+ "608a9bab39938617a0ab45f7 est un exemple d’identifiant\r\n</br>"
				+ "\r\n</br>"
				+ "Malheureusement cette fonctionnalité ne fonctionne pas.\r\n</br>"
				+ "\r\n</br>"
				+ "6 - Affichage d’un cv au format xml\r\n</br>"
				+ "\r\n</br>"
				+ "commande GET : {{url}}/cv?id=608a9e1a39938617a0ab45f9\r\n</br>"
				+ "\r\n</br>"
				+ "Affichage du cv ayant pour identifiant : 608a9e1a39938617a0ab45f9\r\n</br>"
				+ "\r\n</br>"
				+ "7 - Suppression d’un cv \r\n</br>"
				+ "\r\n</br>"
				+ "commande DELETE : {{url}}/delete?id=608b07719b7556072319af97\r\n</br>"
				+ "\r\n</br>"
				+ "Dans l’exemple, nous supprimons le cv ayant pour identifiant : 608b07719b7556072319af97\r\n</br>"
				+ "\r\n</br>"
				+ "8 - Mise à jour d’un cv\r\n</br>"
				+ "\r\n</br>"
				+ "commande PUT :{{url}}/update?id=608b0912f4ca002265830841\r\n</br>"
				+ "\r\n</br>"
				+ "Dans l’exemple, nous mettons à jour le cv ayant pour identifiant : 608b0912f4ca002265830841\r\n</br>"
				+ "</p></br>";
		page += "</body>";
		page += "</html>";

		return page ;
	}

	@GetMapping(value="/", produces = MediaType.TEXT_HTML_VALUE)
	public String accueilXML() {
		ProjetTp08Application.logger.info("affichage de la page d'accueil XML");
		String page = "";

		page += "<!DOCTYPE html>";
		page += "<html>";
		page += "<head>";
		page += "<title>Projet web XML</title>";
		page += "</head>";
		page += "<body>";
		page += "<h1>Projet Web XML</h1>";
		page += "<p>v0.1</br>Lassire Eden & Cornilleau Titouan</p>";
		page += "<img src=\"/src/main/resources/fr/univrouen/cv21rest/images/logo.jpg\"></img>";
		page += "</body>";
		page += "</html>";

		return page ;
	}
	@GetMapping(value="/resume", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public List<CV21> getAllCV() {
		ProjetTp08Application.logger.info("récupération de la liste des cv");
		//System.out.println(this.cvRepository.findAll());
		List<CV21> LCV21 = new ArrayList<>();
		LCV21 = this.cvRepository.findAll();
		return LCV21;

	}
	@GetMapping(value="/htmlcv", produces = MediaType.TEXT_HTML_VALUE)
	public String getOneCVHTML(@RequestParam(value = "id") String id) throws JsonProcessingException {

		ProjetTp08Application.logger.info("récupération d'un cv id = "+id);

		List<CV21> LCV21 = new ArrayList<>();
		LCV21 = this.cvRepository.findAll();
		String jsonStringOfCv = null;
		Gson g = new Gson();
		ObjectMapper jsonObjectMapper = new ObjectMapper();


		for(CV21 cv : LCV21) {
			System.out.println(cv.getId() + " = " + id);
			if(cv.getId().equals(id)) {
				jsonStringOfCv = jsonObjectMapper.writeValueAsString(cv) ;
			}
		}
		System.out.println(jsonStringOfCv);
		String xml_data = convert(jsonStringOfCv,"cv21");
		System.out.println(xml_data);


		return TransformXSLT.createHTML(xml_data);
	}
	@GetMapping(value="/cv", produces = MediaType.TEXT_HTML_VALUE)
	public String getOneCV(@RequestParam(value = "id") String id) throws JsonProcessingException {
		
		ProjetTp08Application.logger.info("récupération d'un cv au format html id = "+id);

		List<CV21> LCV21 = new ArrayList<>();
		LCV21 = this.cvRepository.findAll();
		String jsonStringOfCv = null;
		Gson g = new Gson();
		ObjectMapper jsonObjectMapper = new ObjectMapper();


		for(CV21 cv : LCV21) {
			System.out.println(cv.getId() + " = " + id);
			if(cv.getId().equals(id)) {
				jsonStringOfCv = jsonObjectMapper.writeValueAsString(cv) ;
			}
		}
		System.out.println(jsonStringOfCv);
		if (jsonStringOfCv != null) {
			return convert(jsonStringOfCv,"cv21");
		}
		return "<informations><status>ERROR</status><id>"+id+"</id></informations>";
	}

	public static String convert(String json, String root) throws JSONException {
		JSONObject jsonObject = new JSONObject(json);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
		return xml;
	}


	@PostMapping(value="/insert",consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public String createCV(@RequestBody String xml) throws IOException, SAXException {
		ProjetTp08Application.logger.info("ajout d'un nouveau cv à la base");
		
		// vérification du xml 
		//chemin du xsd introuvable
		
//		SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema") ;
//		InputSource sourceentree = new InputSource(new FileInputStream(new File("src/main/java/fr/univrouen/cv21/cv21.tp1.xsd")));
//		SAXSource sourceXSD = new SAXSource(sourceentree);
//		Schema schema = factory.newSchema(sourceXSD);
//		Validator validator = schema.newValidator() ;
//		validator.validate(new StreamSource(new StringReader(xml))) ;
		
		XmlMapper xmlMapper = new XmlMapper();
		Gson g = new Gson();

		JsonNode jsonNode = xmlMapper.readTree(xml.getBytes());
		System.out.println(jsonNode.toString());



		CV21 cv = g.fromJson(jsonNode.toString(),CV21.class);
		System.out.println(cv.toString());

		List<CV21> LCV21 = new ArrayList<>();
		LCV21 = this.cvRepository.findAll();

		for(CV21 cv2 : LCV21) {
			//System.out.println(cv2.getIdentitie()+ " vs "+  cv.getIdentitie());
			if (cv2.getIdentitie().equals(cv.getIdentitie()) 
					&& cv2.getCompetences().equals(cv.getCompetences())
					&& cv2.getDivers().equals(cv.getDivers()) 
					&& cv2.getObjectif().equals(cv.getObjectif())
					&& cv2.getProf().equals(cv.getProf() ))
				return "<status>ERROR</status>";
		}

		CV21 cvInserted = this.cvRepository.insert(cv);

		return "<informations><status>INSERTED</status><id>"+ cvInserted.getId()+"</id></informations>";
	}
		@DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_XML_VALUE)
		public String deleteCV(@RequestParam(value = "id") String id) {
			ProjetTp08Application.logger.info("suppression d'un cv");
			if (findCV(id) != null) {
				this.cvRepository.delete(findCV(id));
				return "<informations><status>DELETED</status><id>"+id+"</id></informations>";
			}
			return "<status>ERROR</status>";

		}
	
		public CV21 findCV(String id ) {
			
			List<CV21> LCV21 = new ArrayList<>();
			LCV21 = this.cvRepository.findAll();
			
			for(CV21 cv : LCV21) {
				System.out.println(cv.getId() + " = " + id);
				if(cv.getId().equals(id)) {
					return cv ;
				}
			}
			
			return null ;
			
		}
		@PutMapping(value = "/update", produces = MediaType.APPLICATION_XML_VALUE)
		public String updateCV(@RequestParam(value = "id") String id, @RequestBody String txt) throws SAXException {
			ProjetTp08Application.logger.info("mise à jour d'un cv");
			if (findCV(id) != null) {
				this.cvRepository.delete(findCV(id));
				try {
					return createCV(txt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return "<status>ERROR</status>";

		}
		
		
}
