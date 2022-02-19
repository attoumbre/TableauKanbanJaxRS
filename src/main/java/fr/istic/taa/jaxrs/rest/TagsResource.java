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

import fr.istic.taa.jaxrs.dao.generic.TagsDao;
import fr.istic.taa.jaxrs.domain.Tags;
import fr.istic.taa.jaxrs.domain.Users;



@Path("/tags")
@Produces({"application/json", "application/xml"})
public class TagsResource {

				private TagsDao dao = new TagsDao();
				
				@GET
				@Path("/{f}")
				public Tags getTagsById(@PathParam("f") Long f) {
					if(f == null) {
						throw new IllegalArgumentException("l'id du tag ne peut pas etre null");
					}
					return this.dao.findOne(f);
				}
				
				@DELETE
				@Path("/{f}")
				public void deleteTag(@PathParam("f") Long f) {
					this.dao.deleteById(f);
				}
				
				@GET
				@Path("/all")
				public List<Tags> getAllTags() {

					return this.dao.findAll();
				}

				@POST
				@Consumes("application/json")
				public void AddTag(Tags t) {
					
					if(t == null) {
						throw new IllegalArgumentException(" Aucun tableau a ajoute");
					}
					this.dao.save(t);
				}
				
				
				 @PUT
				  @Consumes("application/json")
				  public Response UpdateUser ( Tags t) {
					  
					  this.dao.update(t);
				    
				    return Response.ok().entity("SUCCESS").build();
				  }


}
