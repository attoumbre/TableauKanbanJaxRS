package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tableau implements Serializable{

	private Long id;
	private String nom;
	private List<Sections> sections  = new ArrayList<Sections> ();
	
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
	
	@OneToMany(mappedBy = "tableau", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonManagedReference
	public List<Sections> getSection() {
		return sections;
	}
	public void setSection(List<Sections> sections) {
		this.sections = sections;
	}
	
}
