package fr.istic.taa.jaxrs.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Fiches implements Serializable{

	private Long id;
	private String lib;
	private Date date;
	private int temps;
	private List<Tags> tags;
	private String lieu;
	private String url;
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
	public String getLib() {
		return lib;
	}
	public void setLib(String lib) {
		this.lib = lib;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTemps() {
		return temps;
	}
	public void setTemps(int temps) {
		this.temps = temps;
	}
	
	@OneToMany(mappedBy = "fiche")
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne
	public Users getUser() {
		return user;
	}
	
	public void setUser(Users user) {
		this.user = user;
	}
	@ManyToOne
	public Sections getSection() {
		return section;
	}
	public void setSection(Sections section) {
		this.section = section;
	}
	
	
	
}
