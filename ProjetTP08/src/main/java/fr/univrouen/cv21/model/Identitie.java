package fr.univrouen.cv21.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Identitie {
	
	private String genre;
	private String nom;
	private String prenom;
	private String tel;
	private String mel;
	
	public Identitie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Identitie(String genre, String nom, String prenom, String tel, String mel) {
		super();
		this.genre = genre;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.mel = mel;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMel() {
		return mel;
	}
	public void setMel(String mel) {
		this.mel = mel;
	}
	
	

}
