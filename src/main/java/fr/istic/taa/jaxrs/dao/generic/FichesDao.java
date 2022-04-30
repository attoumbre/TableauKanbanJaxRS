package fr.istic.taa.jaxrs.dao.generic;

import java.util.List;

import fr.istic.taa.jaxrs.domain.Fiches;

public class FichesDao extends AbstractJpaDao<Long, Fiches>{
	
	public FichesDao() {
		super(Fiches.class);
	}

	public List<Fiches> getFicheSection(long id_s) {
		
		String query = "select f from Fiches as f join Sections as s on f.section.id = s.id  where s.id =: section ";
		return (List<Fiches>)  EntityManagerHelper.getEntityManager().createQuery(query, Fiches.class)
				.setParameter("section", id_s).getResultList();
	}
}
