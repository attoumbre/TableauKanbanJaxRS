package fr.istic.taa.jaxrs.dao.generic;

import fr.istic.taa.jaxrs.domain.FichesBug;

public class FichesBugDao extends AbstractJpaDao<Long, FichesBug>{
	
	public FichesBugDao() {
		super(FichesBug.class);
	}

}
