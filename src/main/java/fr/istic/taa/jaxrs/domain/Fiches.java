package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Fiches implements Serializable{
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date date;
	private String url;
	private int temps;
	private List<Tags> tags  = new ArrayList<Tags> ();
	private String lieu;
	private String description;
	private Users user;
	private Sections section;
	
//	public Fiches() {
//		
//	}
//	
	/*public Fiches(String lib, int temps, String lieu, String url, String description, Sections section) {
		this.lib = lib;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		this.temps = temps;
		this.lieu = lieu;
		this.url = url;
		this.description = description;
		this.section = section;
	}
	*/
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	@OneToMany(mappedBy = "fiche" , fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	 @JsonManagedReference(value = "fiche")
	public List<Tags> getTags() {
		return tags;
	}
	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}
	
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonBackReference (value = "user")
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	@ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonBackReference(value = "section")
	public Sections getSection() {
		return section;
	}
	public void setSection(Sections section) {
		this.section = section;
	}
	
	public void moveToSection(Sections section) {
		this.setSection(section);
		section.getFiches().add(this);
	}
	
	
	
}
