package fr.istic.taa.jaxrs.domain;




import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tableau implements Serializable{

	private Long id;
	private String nom;
	private List<Sections> sections;
	private Users user;
	
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
	@OneToMany(mappedBy = "tableau")
	public List<Sections> getSections() {
		return sections;
	}
	public void setSections(List<Sections> sections) {
		this.sections = sections;
	}
	@ManyToOne
	public Users getUser() {
		return user;
	}
	public void setUser(Users userid) {
		this.user = userid;
	}
	
	
	
}
