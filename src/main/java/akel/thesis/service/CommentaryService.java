package akel.thesis.service;

import akel.thesis.model.CommentaryEntity;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class CommentaryService extends AbstractThesisService<CommentaryEntity>{
    public CommentaryService(){
        super(CommentaryEntity.class);
    }

    public int SumEffortPoint(int id,String who){
        int num=0;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CommentaryEntity> cq = cb.createQuery(CommentaryEntity.class);
        Root<CommentaryEntity> model = cq.from(CommentaryEntity.class);
        cq.where(cb.equal(model.get("who"),who),cb.lessThanOrEqualTo(model.get("id"),id));
        List<CommentaryEntity> resultList = getEntityManager().createQuery(cq).getResultList();
        for(CommentaryEntity commentary:resultList){
            num+=commentary.getFactByFactId().getEffortPoint();
        }
        return num;
    }

    public List<CommentaryEntity> findByIdAndWho(int id,String who){
        int num=0;
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CommentaryEntity> cq = cb.createQuery(CommentaryEntity.class);
        Root<CommentaryEntity> model = cq.from(CommentaryEntity.class);
        cq.where(cb.equal(model.get("who"),who),cb.lessThanOrEqualTo(model.get("id"),id));
        return getEntityManager().createQuery(cq).getResultList();

    }

    public CommentaryEntity find(int id){
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<CommentaryEntity> cq = cb.createQuery(CommentaryEntity.class);
        Root<CommentaryEntity> model = cq.from(CommentaryEntity.class);
        cq.where(cb.equal(model.get("id"),id));
        return getEntityManager().createQuery(cq).getSingleResult();
    }
}
