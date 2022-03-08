package fr.istic.taa.jaxrs.dao.generic;


import java.util.List;

import fr.istic.taa.jaxrs.domain.FichesBug;

public class FichesBugDao extends AbstractJpaDao<Long, FichesBug>{
	
	public FichesBugDao() {
		super(FichesBug.class);
	}
	
	public List<FichesBug> getAllFichebug(){
		
		return this.entityManager.createQuery("select f from fiches as f where f.url is NOT NULL or f.nomService is NOT NULL",FichesBug.class).getResultList();
			
		}


}
