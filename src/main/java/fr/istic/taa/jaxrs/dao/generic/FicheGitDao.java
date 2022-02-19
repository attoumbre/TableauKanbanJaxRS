package fr.istic.taa.jaxrs.dao.generic;



import fr.istic.taa.jaxrs.domain.FicheGit;


public class FicheGitDao extends AbstractJpaDao<Long, FicheGit>{

	
	public FicheGitDao() {
		super(FicheGit.class);
	}

}
