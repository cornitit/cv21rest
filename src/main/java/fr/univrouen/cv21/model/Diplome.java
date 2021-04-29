package fr.univrouen.cv21.model;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Diplome {


	private String date ;
	private String titre ;
	private String etab ;
	
	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Diplome(String date, String titre, String etab) {
		super();
		this.date = date;
		this.titre = titre;
		this.etab = etab;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getEtab() {
		return etab;
	}
	public void setEtab(String etab) {
		this.etab = etab;
	}
	
	
}
