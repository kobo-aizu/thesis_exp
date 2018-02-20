package akel.thesis.service;

import akel.thesis.model.KnowledgeEntity;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;

@Stateless
public class KnowledgeService extends AbstractThesisService<KnowledgeEntity>{
    public KnowledgeService(){
        super(KnowledgeEntity.class);
    }

    public KnowledgeEntity find(int id){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<KnowledgeEntity> cq = cb.createQuery(KnowledgeEntity.class);
        Root<KnowledgeEntity> model = cq.from(KnowledgeEntity.class);
        cq.where(cb.equal(model.get("id"),id));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

    @TransactionAttribute(value = TransactionAttributeType.REQUIRED)
    public void register(KnowledgeEntity knowledge){
        knowledge.setWhen_t(new Timestamp(System.currentTimeMillis()));
        this.create(knowledge);
        this.getEntityManager().flush();
        return;
    }


}
