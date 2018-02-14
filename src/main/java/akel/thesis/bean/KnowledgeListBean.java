package akel.thesis.bean;

import akel.thesis.service.KnowledgeService;
import akel.thesis.model.KnowledgeEntity;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class KnowledgeListBean implements Serializable{
    @EJB
    KnowledgeService knowledgeService;

    private List<KnowledgeEntity> knowledgeList;


    public List<KnowledgeEntity> getKnowledgeList(){
        return knowledgeList;
    }

    public void setKnowledgeList(List<KnowledgeEntity> knowledgeList){
        this.knowledgeList = knowledgeList;
    }

    public void init(){
        knowledgeList = knowledgeService.findAll();
    }
}
