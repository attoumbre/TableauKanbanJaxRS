package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.istic.taa.jaxrs.dao.generic.UsersDao;
import fr.istic.taa.jaxrs.domain.Users;
import fr.istic.taa.jaxrs.dto.UserDto;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class Usersresource {
	
	private UsersDao usersDao = new UsersDao();
	@GET
	@Path("/{user}")
	public Users getUserById(@PathParam("userId") Long userId) {
//		UsersDao usersDao = new UsersDao();
		if(userId == null) {
			throw new IllegalArgumentException("l'id de l'utilisateur ne peut pas etre null");
		}
		return usersDao.findOne(userId);
	}
	
	@GET
	@Path("/all")
	public List<Users> getAllUsers() {
//		UsersDao usersDao = new UsersDao();
		
		//List<Users> allUsers= usersDao.getAllUsers();
		return usersDao.getAllUsers();
	}

	@POST
	@Consumes("application/json")
	public void AddUser(Users user) {
		
		if(user == null) {
			throw new IllegalArgumentException("l'utilisateur est null");
		}
		usersDao.save(user);
	}
	
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserDto login(String nom, String prenom) {
		Users u = usersDao.login(nom, prenom);
		UserDto userDto = new UserDto();
		userDto.setNom(u.getNom());
		userDto.setPrenom(u.getPrenom());
		return userDto;
	}
	
}
