package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Sections;

public class SectionsDao extends AbstractJpaDao<Long, Sections>{
	
	public SectionsDao() {
		super(Sections.class);
	}

}
