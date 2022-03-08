package fr.istic.taa.jaxrs.dao.generic;



import java.util.List;

import fr.istic.taa.jaxrs.domain.FicheGit;
import fr.istic.taa.jaxrs.domain.FichesBug;


public class FicheGitDao extends AbstractJpaDao<Long, FicheGit>{

	
	public FicheGitDao() {
		super(FicheGit.class);
	}
	
public List<FicheGit> getAllFicheGit(){
		
		return this.entityManager.createQuery("select f from fiches as f where f.lib is NOT NULL",FicheGit.class).getResultList();
			
		}


}
