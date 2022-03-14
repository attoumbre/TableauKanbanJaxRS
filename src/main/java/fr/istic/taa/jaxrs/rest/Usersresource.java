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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import fr.istic.taa.jaxrs.dao.generic.UsersDao;
import fr.istic.taa.jaxrs.domain.Users;
import fr.istic.taa.jaxrs.dto.UserDto;



@Path("/user")
//@CrossOriginResourceSharing(alloworigins = "*")
@Produces({"application/json", "application/xml"})
public class Usersresource {
	
	private UsersDao usersDao = new UsersDao();
	
	
	
	@GET
	@Path("/{user}")
	public Users getUserById(@PathParam("user") Long id) {
//		UsersDao usersDao = new UsersDao();
		if(id == null) {
			throw new IllegalArgumentException("l'id de l'utilisateur ne peut pas etre null");
		}
		return this.usersDao.findOne(id);
	}
	
	
	
	@DELETE
	@Path("/{user}")
	public void deleteUser(@PathParam("user") Long id) {
		this.usersDao.deleteById(id);
	}
	@GET
	@Path("/all")
	public List<Users> getAllUsers() {
//		UsersDao usersDao = new UsersDao();
		
		//List<Users> allUsers= usersDao.getAllUsers();
		return this.usersDao.findAll();
	}

	@POST
	@Consumes("application/json")
	public void AddUser(Users user) {
		
		if(user == null) {
			throw new IllegalArgumentException("l'utilisateur est null");
		}
		this.usersDao.save(user);
	}
	
	
	 @PUT
	  @Consumes("application/json")
	  public Response UpdateUser ( Users u) {
		 if(u == null) {
			 throw new IllegalArgumentException("l'utilisateur est null");
		 }
		  this.usersDao.update(u);
	    
	    return Response.ok().entity("SUCCESS").build();
	  }
	  
	 @CrossOriginResourceSharing(
				allowAllOrigins = true
		        )
	@POST
	//@Path("/signin/{mail}/{nom}")
	@Path("/signin")
	@Consumes(MediaType.APPLICATION_JSON)
	//public UserDto login(@PathParam("nom") String nom,@PathParam("mail") String mail ) {
	public UserDto signin(UserDto us) {
		Users user = this.usersDao.login(us.getNom(), us.getMail());
		UserDto userDto = new UserDto();
		if(user != null) {
			userDto.setNom(user.getNom());
			userDto.setMail(user.getMail());
			return userDto;
		}				
		
		throw new NullPointerException(); 
	}
	
}
