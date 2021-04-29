package fr.univrouen.cv21.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Certif {

	
	private String datedeb ;
	private String datefin;
	private String titre ;
	public Certif() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Certif(String datedeb, String datefin, String titre) {
		super();
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
