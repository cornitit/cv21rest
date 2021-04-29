package fr.univrouen.cv21.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Expe {

	private String datedeb;
	private String datefin;
	private String titre;
	
	
	public Expe() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Expe(String datedeb, String datefin, String titre) {
		this.datedeb = datedeb;
		this.datefin = datefin;
		this.titre = titre;
	}

	
	public String getDatedeb() {
		return datedeb;
	}
	
	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}
	
	public String getDatefin() {
		return datefin;
	}
	
	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
