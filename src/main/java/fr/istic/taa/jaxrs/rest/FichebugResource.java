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

import fr.istic.taa.jaxrs.dao.generic.FichesBugDao;
import fr.istic.taa.jaxrs.domain.FichesBug;
import fr.istic.taa.jaxrs.domain.Tags;

@Path("/fichebug")
@Produces({"application/json", "application/xml"})
public class FichebugResource {
		
		private FichesBugDao dao = new FichesBugDao();
		
		@GET
		@Path("/{f}")
		public FichesBug getFicheBugById(@PathParam("f") Long id) {
			if(id == null) {
				throw new IllegalArgumentException("l'id de la fiche ne peut pas etre null");
			}
			return this.dao.findOne(id);
		}
		
		@DELETE
		@Path("/{f}")
		public void deleteFicheBug(@PathParam("f") Long f) {
			this.dao.deleteById(f);
		}
		
		@GET
		@Path("/all")
		public List<FichesBug> getAllFicheBug() {

			return this.dao.findAll();
		}

		@POST
		@Consumes("application/json")
		public void AddFicheBug(FichesBug f) {
			
			if(f == null) {
				throw new IllegalArgumentException("la fiche est nulle");
			}
			this.dao.save(f);
		}
		
		@PUT
		  @Consumes("application/json")
		  public Response UpdateUser ( FichesBug f) {
			  
			  this.dao.update(f);
		    
		    return Response.ok().entity("SUCCESS").build();
		  }

}
