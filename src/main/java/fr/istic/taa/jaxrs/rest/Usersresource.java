package fr.istic.taa.jaxrs.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import fr.istic.taa.jaxrs.dao.generic.UsersDao;
import fr.istic.taa.jaxrs.domain.Users;

@Path("/user")
@Produces({"application/json", "application/xml"})
public class Usersresource {
	
	@GET
	@Path("/{user}")
	public Users getUserById(@PathParam("userId") Long userId) {
		UsersDao usersDao = new UsersDao();
		if(userId == null) {
			throw new IllegalArgumentException("l'id de l'utilisateur ne peut pas etre null");
		}
		return usersDao.findOne(userId);
	}
	
	@GET
	@Path("/all")
	public List<Users> getAllUsers() {
		UsersDao usersDao = new UsersDao();
		
		//List<Users> allUsers= usersDao.getAllUsers();
		return usersDao.getAllUsers();
	}

	@POST
	public void AddUser(Users user) {
		UsersDao usersDao = new UsersDao();
		if(user == null) {
			throw new IllegalArgumentException("l'utilisateur est null");
		}
		usersDao.save(user);
	}
}
