package akel.thesis.service;

import akel.thesis.model.KnowledgeEntity;
import akel.thesis.model.TeamEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class TeamService extends AbstractThesisService<TeamEntity>{
    public TeamService(){
        super(TeamEntity.class);
    }

    public TeamEntity findByName(String who){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<TeamEntity> cq = cb.createQuery(TeamEntity.class);
        Root<TeamEntity> model = cq.from(TeamEntity.class);
        cq.where(cb.equal(model.get("name"),who));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
