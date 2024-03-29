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
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Users implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id ;
	private String nom;
	private String prenom;
	private String email;
	private List<Fiches> fiches  = new ArrayList<Fiches> ();
	private List<Tableau> tableau  = new ArrayList<Tableau> ();
	
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "user")
	@JsonManagedReference(value = "user")
	public List<Fiches> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiches> fiches) {
		this.fiches = fiches;
	}
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "userT")
	@JsonManagedReference(value = "userT")
	public List<Tableau> getTableau() {
		return tableau;
	}
	public void setTableau(List<Tableau> tableau) {
		this.tableau = tableau;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", nom=" + nom + ", Prenom=" + prenom + ", mail=" + email + ", fiches=" + fiches
				+ "]";
	}
	
	
	

}
