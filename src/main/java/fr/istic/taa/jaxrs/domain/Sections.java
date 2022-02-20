package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Sections implements Serializable{

	private Long id;
	private Tableau tableau;
	private String lib;
	private List<Fiches> fiches  = new ArrayList<Fiches> ();
	
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
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonBackReference
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
	
	@OneToMany(mappedBy = "section", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	 @JsonManagedReference
	public List<Fiches> getFiches() {
		return fiches;
	}
	public void setFiches(List<Fiches> fiches) {
		this.fiches = fiches;
	}
	
}
