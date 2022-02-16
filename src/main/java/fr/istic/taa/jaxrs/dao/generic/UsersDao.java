package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Users;
import fr.istic.taa.jaxrs.dto.UserDto;

public class UsersDao extends AbstractJpaDao<Long, Users>{
	
	public UsersDao() {
		super(Users.class);
	}
	
	public List<Users> getAllUsers(){
		String query = "select u from Users as u";
		return EntityManagerHelper.getEntityManager().createQuery(query, Users.class).getResultList();
	}

	//recupperer tout un users avec son tableau de bord
	public List<UserDto> findUserTableauFiche(int userId) {
		
		
//		String query = "select t from Magazine as t " + 
//				"where t.titre = :titre and t.prix = :prix";
//					return EntityManagerHelper.getEntityManager().createQuery(query, Magazine.class)
//							.setParameter("prix", prix).setParameter("titre",titre)
//							.getResultList();
//		
		
		String query = "select uf from Users as u join u.fiches as uf " + 
				"where uf.id = :userid ";
		return  EntityManagerHelper.getEntityManager().createQuery(query, UserDto.class)
			.setParameter("userid", userId).getResultList();
	}

public Users login(String nom, String prenom) {
		
		
//		String query = "select t from Magazine as t " + 
//				"where t.titre = :titre and t.prix = :prix";
//					return EntityManagerHelper.getEntityManager().createQuery(query, Magazine.class)
//							.setParameter("prix", prix).setParameter("titre",titre)
//							.getResultList();
//		
		
		String query = "select u from Users as u " + 
				"where u.nom = :nom and u.prenom = :prenom ";
		return  (Users) EntityManagerHelper.getEntityManager().createQuery(query, UserDto.class)
			.setParameter("nom", nom).setParameter("prenom", prenom).getResultList();
	}
	
}
