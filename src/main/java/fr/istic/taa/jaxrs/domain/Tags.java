package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

public class Tags implements Serializable{
	
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nomTags;
	private Date date;
	private Fiches fiche;
	
//	public Tags() {
//		super();
//	}
//	
//	public Tags(String nomTags, Date date,Fiches fiche) {
//		this.nomTags = nomTags;
//		this.date = date;
//		this.fiche = fiche;
//	}
//	
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomTags() {
		return nomTags;
	}
	public void setNomTags(String nomTags) {
		this.nomTags = nomTags;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JsonBackReference(value = "fiche")
	public Fiches getFiche() {
		return fiche;
	}
	public void setFiche(Fiches fiche) {
		this.fiche = fiche;
	}

}
