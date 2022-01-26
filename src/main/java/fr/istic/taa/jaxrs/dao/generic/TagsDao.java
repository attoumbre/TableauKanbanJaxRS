package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tags;

public class TagsDao extends AbstractJpaDao<Long, Tags>{
	
	public TagsDao() {
		super(Tags.class);
	}

}
