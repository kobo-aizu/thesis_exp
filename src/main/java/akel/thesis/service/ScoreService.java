package akel.thesis.service;

import akel.thesis.model.ScoreEntity;
import akel.thesis.model.TeamEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class ScoreService extends AbstractThesisService<ScoreEntity>{
    public ScoreService(){
        super(ScoreEntity.class);
    }

    public int countByTeamId(String name){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<ScoreEntity> cq = cb.createQuery(ScoreEntity.class);
        Root<ScoreEntity> model = cq.from(ScoreEntity.class);
        cq.where(cb.equal(model.get("teamname"),name));
        return getEntityManager().createQuery(cq).getResultList().size();
    }
}
