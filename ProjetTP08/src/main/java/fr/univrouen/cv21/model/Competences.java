package fr.univrouen.cv21.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Competences {
	
	
	private Diplome diplome;
	private Certif certif;
	
	public Competences() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Competences(Diplome diplome, Certif certif) {
		super();
		this.diplome = diplome;
		this.certif = certif;
	}
	public Diplome getDiplome() {
		return diplome;
	}
	public void setDiplome(Diplome diplome) {
		this.diplome = diplome;
	}
	public Certif getCertif() {
		return certif;
	}
	public void setCertif(Certif certif) {
		this.certif = certif;
	}
	
	
	

}
