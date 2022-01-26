package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Fiches;

public class FichesDao extends AbstractJpaDao<Long, Fiches>{
	
	public FichesDao() {
		super(Fiches.class);
	}

}
