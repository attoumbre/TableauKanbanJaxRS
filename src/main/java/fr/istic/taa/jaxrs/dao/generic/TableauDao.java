package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Tableau;

public class TableauDao extends AbstractJpaDao<Long, Tableau>{
	
	public TableauDao() {
		super(Tableau.class);
	}
	
	
    public List<Tableau> findTabByUser(Long id) {
		String query = "select t from Tableau as t join Users as u on t.userT.id = u.id where u.id = :userT ";
		return  (List<Tableau>) EntityManagerHelper.getEntityManager().createQuery(query, Tableau.class)
				.setParameter("userT", id).getResultList();
	}
}