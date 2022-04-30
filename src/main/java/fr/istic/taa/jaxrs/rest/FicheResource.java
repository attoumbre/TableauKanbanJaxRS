package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.FichesDao;
import fr.istic.taa.jaxrs.domain.Fiches;
import fr.istic.taa.jaxrs.domain.Tags;



@Path("/fiches")
@Produces({"application/json", "application/xml"})
public class FicheResource {
	
			private FichesDao dao = new FichesDao();
			
			@GET
			@Path("/{f}")
			public Fiches getFicheById(@PathParam("f") Long f) {
				if(f == null) {
					throw new IllegalArgumentException("l'id de la fiche ne peut pas etre null");
				}
				return this.dao.findOne(f);
			}
			
			@GET
			@Path("/recup/{f}")
			public List<Fiches> getFichesSection(@PathParam("f") Long f) {
				if(f == null) {
					throw new IllegalArgumentException("l'id de la fiche ne peut pas etre null");
				}
				return this.dao.getFicheSection(f);
			}
			
			@DELETE
			@Path("/{f}")
			public void deleteFiche(@PathParam("f") Long f) {
				this.dao.deleteById(f);
			}
			
			@GET
			@Path("/all")
			public List<Fiches> getAllFiche() {

				return this.dao.findAll();
			}

			@POST
			@Path("/create")
			@Consumes("application/json")
			public Fiches AddFiche(Fiches f) {
				
				if(f == null) {
					throw new IllegalArgumentException("la fiche est nulle");
				}
				return this.dao.save(f);
			}
			
			@PUT
			  @Consumes("application/json")
			  public Fiches UpdateUser ( Fiches f) {
				if(f == null) {
					throw new IllegalArgumentException("la fiche est nulle");
				}
				 Fiches fiches = new Fiches() ;
				 fiches = this.dao.findOne(f.getId());
				 if(fiches != null) {
					 f.setDate(fiches.getDate());
					 f.setDescription(fiches.getDescription());
					 f.setSection(fiches.getSection());
					 f.setTemps(fiches.getTemps());
					 f.setUser(fiches.getUser());
					 return this.dao.update(f);
				 }
			    return f;

			  }
}
