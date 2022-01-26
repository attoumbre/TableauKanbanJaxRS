package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.Tableau;

public class TableauDao extends AbstractJpaDao<Long, Tableau>{
	
	public TableauDao() {
		super(Tableau.class);
	}

}
