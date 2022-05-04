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

import fr.istic.taa.jaxrs.dao.generic.FichesDao;
import fr.istic.taa.jaxrs.dao.generic.SectionsDao;
import fr.istic.taa.jaxrs.domain.Fiches;
import fr.istic.taa.jaxrs.domain.Sections;



@Path("/fiches")
@Produces({"application/json", "application/xml"})
public class FicheResource {
			private final FichesDao dao= new FichesDao();
			private final SectionsDao secDao = new SectionsDao();
			/*public FicheResource(FichesDao _dao, SectionsDao _secDao) {
				this.dao = _dao;
				this.secDao = _secDao;
			}
			*/
			
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
			  public Fiches UpdateUser (Fiches f) {
				if(f == null) {
					throw new IllegalArgumentException("la fiche est nulle.");
				}
				 Fiches fiches = this.dao.findOne(f.getId());
				 if(fiches != null) {
					 fiches.setDate(f.getDate());
					 fiches.setDescription(f.getDescription());
					 fiches.setTemps(f.getTemps());
					 
					 Sections s = secDao.findOne(f.getSection().getId());
					 fiches.moveToSection(s);
					 this.secDao.update(s);
				 }
				 return this.dao.update(fiches);

			  }
			
			@PUT
			@Path("/update")
			@Consumes("application/json")
			public Fiches modif(Fiches f) {
				if (f == null) {
					throw new IllegalArgumentException("la fiche est nulle.");
				}
				
				Fiches fiches = this.dao.findOne(f.getId());
				if (fiches != null ) {
					fiches.setDate(f.getDate());
					fiches.setDescription(f.getDescription());
					fiches.setTemps(f.getTemps());
					
				}
				return this.dao.update(fiches);
			}
			
}
