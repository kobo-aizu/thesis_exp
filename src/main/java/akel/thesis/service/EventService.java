package akel.thesis.service;

import akel.thesis.model.EventEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class EventService extends AbstractThesisService<EventEntity>{
    public EventService(){
        super(EventEntity.class);
    }

    public EventEntity find(int id){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EventEntity> cq = cb.createQuery(EventEntity.class);
        Root<EventEntity> model = cq.from(EventEntity.class);
        cq.where(cb.equal(model.get("id"),id));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
