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

import fr.istic.taa.jaxrs.dao.generic.SectionsDao;
import fr.istic.taa.jaxrs.domain.Sections;
import fr.istic.taa.jaxrs.domain.Tags;



@Path("/sections")
@Produces({"application/json", "application/xml"})
public class SectionsResource {


				private SectionsDao dao = new SectionsDao();
				
				@GET
				@Path("/{s}")
				public Sections getFicheById(@PathParam("s") Long s) {
					if(s == null) {
						throw new IllegalArgumentException("l'id de la section ne peut pas etre null");
					}
					return this.dao.findOne(s);
				}
				
				@DELETE
				@Path("/{s}")
				public void deleteSection(@PathParam("s") Long s) {
					this.dao.deleteById(s);
				}
				
				@GET
				@Path("/all")
				public List<Sections> getAllSection() {

					return this.dao.findAll();
				}

				@POST
				@Consumes("application/json")
				public void AddSection(Sections s) {
					
					if(s == null) {
						throw new IllegalArgumentException("la section est nulle");
					}
					this.dao.save(s);
				}
				
				@PUT
				@Consumes("application/json")
				  public Response UpdateUser ( Sections s) {
					  
					  this.dao.update(s);
				    
				    return Response.ok().entity("SUCCESS").build();
				  }
}
