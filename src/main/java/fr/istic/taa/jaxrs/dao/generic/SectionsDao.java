package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Sections;

public class SectionsDao extends AbstractJpaDao<Long, Sections>{
	
	public SectionsDao() {
		super(Sections.class);
	}
	
	public List<Sections> getSectionBoard(long id) {
		
		String query = "select s from Sections as s inner join Tableau as t on s.tableau.id = t.id where t.id =:tableau ";
		return (List<Sections>)  EntityManagerHelper.getEntityManager().createQuery(query, Sections.class)
				.setParameter("tableau", id).getResultList();
	}
}
