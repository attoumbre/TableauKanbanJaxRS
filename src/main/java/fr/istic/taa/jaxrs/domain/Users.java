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
public class Users implements Serializable {
	
	private Long id ;
	private String nom;
	private String prenom;
	private String mail;
	private List<Fiches> fiches  = new ArrayList<Fiches> ();
	
//	public Users() {
//		
//	}
//	
//	public Users(String nom, String prenom, String mail) {
//		this.nom = nom;
//		this.prenom = prenom;
//		this.mail = mail;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonManagedReference
	public List<Fiches> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiches> fiches) {
		this.fiches = fiches;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", nom=" + nom + ", Prenom=" + prenom + ", mail=" + mail + ", fiches=" + fiches
				+ "]";
	}
	
	
	

}
