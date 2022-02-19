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
			@Consumes("application/json")
			public void AddFiche(Fiches f) {
				
				if(f == null) {
					throw new IllegalArgumentException("la fiche est nulle");
				}
				this.dao.save(f);
			}
			
			@PUT
			  @Consumes("application/json")
			  public Response UpdateUser ( Fiches f) {
				  
				  this.dao.update(f);
			    
			    return Response.ok().entity("SUCCESS").build();
			  }
}
