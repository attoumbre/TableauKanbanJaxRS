package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Users;
import fr.istic.taa.jaxrs.dto.UserDto;

public class UsersDao extends AbstractJpaDao<Long, Users>{
	
	public UsersDao() {
		super(Users.class);
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

	public Users login(String nom, String mail) {
		String query = "select u from Users as u " + 
				"where u.nom = :nom and u.email = :mail";
		return  EntityManagerHelper.getEntityManager().createQuery(query, Users.class)
			.setParameter("nom", nom).setParameter("mail", mail).getResultList().get(0);
		
	//		String query = "select t from Magazine as t " + 
	//				"where t.titre = :titre and t.prix = :prix";
	//					return EntityManagerHelper.getEntityManager().createQuery(query, Magazine.class)
	//							.setParameter("prix", prix).setParameter("titre",titre)
	//							.getResultList();
	//			
		}
	
}
