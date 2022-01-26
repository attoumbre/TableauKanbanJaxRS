package fr.istic.taa.jaxrs.domain;

import javax.persistence.Entity;

@Entity
public class FicheGit extends Fiches{
/*
	public FicheGit(String lib, int temps, String lieu, String url, String description, Sections section) {
		super(lib, temps, lieu, url, description, section);
		// TODO Auto-generated constructor stub
	}*/

	private String lib;

	public String getLib() {
		return lib;
	}

	public void setLib(String lib) {
		this.lib = lib;
	}
	
	
}
