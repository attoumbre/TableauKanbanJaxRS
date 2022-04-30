package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

public class Tableau implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private List<Sections> sections  = new ArrayList<Sections> ();
	private Users userT;
	
//	public Tableau(String nom) {
//		this.nom = nom;
//	}
//	public Tableau() {
//		// TODO Auto-generated constructor stub
//	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy = "tableau", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@JsonManagedReference(value = "tableau")
	public List<Sections> getSection() {
		return sections;
	}
	public void setSection(List<Sections> sections) {
		this.sections = sections;
	}
	
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonBackReference (value = "userT")
	public Users getUserT() {
		return userT;
	}
	
	public void setUserT(Users user) {
		this.userT = user;
	}
	
}
