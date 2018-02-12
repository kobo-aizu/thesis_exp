package akel.thesis.service;

import akel.thesis.model.EventEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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

    //whoのそれまでのイベントを取得
    public List<EventEntity> findByIdAndWho(int id, String who){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<EventEntity> cq = cb.createQuery(EventEntity.class);
        Root<EventEntity> model = cq.from(EventEntity.class);
        cq.where(cb.equal(model.get("who"),who),cb.lessThan(model.get("id"),id)).orderBy(cb.desc(model.get("when")));
        return getEntityManager().createQuery(cq).getResultList();

    }
}
