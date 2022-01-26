package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Users;

public class UsersDao extends AbstractJpaDao<Long, Users>{
	
	public UsersDao() {
		super(Users.class);
	}
	
	public List<Users> getAllUsers(){
		String query = "select u from Users as u";
		return EntityManagerHelper.getEntityManager().createQuery(query, Users.class).getResultList();
	}


}
