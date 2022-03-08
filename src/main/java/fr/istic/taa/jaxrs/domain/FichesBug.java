package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;

@Entity
public class FichesBug extends Fiches{
	
	/*public FichesBug(String lib, int temps, String lieu, String url, String description, Sections section) {
		super(lib, temps, lieu, url, description, section);
		// TODO Auto-generated constructor stub
	}*/
	
	private String nomService;
	
	
	public String getNomService() {
		return nomService;
	}
	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	

}
