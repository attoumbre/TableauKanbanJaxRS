package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Sections implements Serializable{

	private Long id;
	private Tableau tableau;
	private String lib;
	private List<Fiches> fiches;
	
//	public Sections() {
//		
//	}
//	
//	public Sections(String lib, Tableau tableau) {
//		this.lib = lib;
//		this.tableau = tableau;
//	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne
	public Tableau getTableau() {
		return tableau;
	}
	public void setTableau(Tableau tableau) {
		this.tableau = tableau;
	}
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	
	@OneToMany(mappedBy = "section")
	public List<Fiches> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiches> fiches) {
		this.fiches = fiches;
	}
	
}
