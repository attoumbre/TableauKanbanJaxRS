package fr.istic.taa.jaxrs.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.TableauDao;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.dto.TableauDto;


@Path("/tableau")
@Produces({"application/json", "application/xml"})
public class TableauResource {
		
				private TableauDao dao = new TableauDao();
				
				@GET
				@Path("/{f}")
				public Tableau getTabById(@PathParam("f") Long f) {
					if(f == null) {
						throw new IllegalArgumentException("l'id du tableau ne peut pas etre null");
					}
					return this.dao.findOne(f);
				}
				
				@DELETE
				@Path("/{f}")
				public void deleteTab(@PathParam("f") Long f) {
					this.dao.deleteById(f);
				}
				
				@GET
				@Path("/all")
				public List<Tableau> getAllTab() {

					return this.dao.findAll();
				}
				
				@Path("/create")
				@POST
				@Consumes(MediaType.APPLICATION_JSON)
				public void AddTab(Tableau t) {
					
					if(t == null) {
						throw new IllegalArgumentException(" Aucun tableau a ajoute");
					}
					this.dao.save(t);
				}

				@PUT
				  @Consumes("application/json")
				  public Response UpdateUser ( Tableau t) {
					if(t == null) {
						throw new IllegalArgumentException(" Aucun tableau a ajoute");
					}
					  this.dao.update(t);
				    
				    return Response.ok().entity("SUCCESS").build();
				  }
				
				@POST
				@Path("/perso")
				@Consumes(MediaType.APPLICATION_JSON)
				public List<TableauDto> getTabByUser (TableauDto tabledto) {
					List<Tableau> tab= this.dao.findTabByUser(tabledto.getIdUser());
					if(tab == null) {
						throw new NullPointerException(" Aucun tableau trouvé");
					}
					
					List<TableauDto> tabDto = new ArrayList<TableauDto>();
					for (Tableau tableau : tab) {
						TableauDto table = new TableauDto();
						table.setId(tableau.getId());
						table.setNom(tableau.getNom());
						table.setIdUser(tabledto.getIdUser());
						tabDto.add(table);
					}
					return tabDto;
				}
				
}
