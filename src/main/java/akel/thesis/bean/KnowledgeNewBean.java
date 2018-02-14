package akel.thesis.bean;

import akel.thesis.model.KnowledgeEntity;
import akel.thesis.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.Timestamp;

@Named
@ViewScoped
public class KnowledgeNewBean implements Serializable{
    private KnowledgeEntity knowledge = new KnowledgeEntity();
    @EJB
    private KnowledgeService knowledgeService;

    public void init(){
        knowledge.setWho("");
        knowledge.setWhy("");
        knowledge.setHow("");
        knowledge.setWhat("");
    }

    public String registerKnowledge(){
        knowledgeService.register(knowledge);
        return "/event/list.xhtml";
    }

    public KnowledgeEntity getKnowledge(){
        return this.knowledge;
    }
    public void setKnowledge(KnowledgeEntity knowledge){
        this.knowledge = knowledge;
    }
}
