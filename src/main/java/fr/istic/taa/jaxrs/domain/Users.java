package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Users implements Serializable {
	
	private Long id ;
	private String nom;
	private String prenom;
	private String mail;
	private List<Tableau> tableau;
	private List<Fiches> fiches;
	
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
	@OneToMany(mappedBy = "user")
	public List<Fiches> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiches> fiches) {
		this.fiches = fiches;
	}
	
	@OneToMany(mappedBy = "user")
	public List<Tableau> gettableau(){
		return tableau;
	}
	
	public void setTableau(List<Tableau> tableau) {
		this.tableau = tableau;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", nom=" + nom + ", Prenom=" + prenom + ", mail=" + mail + ", fiches=" + fiches
				+ "]";
	}
	
	
	

}
