package fr.univrouen.cv21.model;

import java.util.List;

import javax.annotation.Generated;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

@Document(collection = "cv21")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CV21 {

	@Id
	private ObjectId id ;
	
	private Identitie identitie;
	private Objectif objectif;
	private Prof prof;
	private Competences competences;
	private Divers divers;

	public CV21() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CV21(Identitie identitie, Objectif objectif, Prof prof, Competences competences, Divers divers) {
		super();
		this.identitie = identitie;
		this.objectif = objectif;
		this.prof = prof;
		this.competences = competences;
		this.divers = divers;
	}




	public String getId() {
		return id.toString();
	}





	public Identitie getIdentitie() {
		return identitie;
	}




	public void setIdentitie(Identitie identitie) {
		this.identitie = identitie;
	}




	public Objectif getObjectif() {
		return objectif;
	}




	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}




	public Prof getProf() {
		return prof;
	}




	public void setProf(Prof prof) {
		this.prof = prof;
	}




	public Competences getCompetences() {
		return competences;
	}




	public void setCompetences(Competences competences) {
		this.competences = competences;
	}




	public Divers getDivers() {
		return divers;
	}




	public void setDivers(Divers divers) {
		this.divers = divers;
	}



}
