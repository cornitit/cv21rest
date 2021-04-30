package fr.univrouen.cv21.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mongodb.DBObject;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Prof {

	private Expe expe;

	
	public Prof() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Prof(Expe expe) {
		super();
		this.expe = expe;
	}


	public Expe getExpe() {
		return expe;
	}


	public void setExpe(Expe expe) {
		this.expe = expe;
	}
	
	
	
}
