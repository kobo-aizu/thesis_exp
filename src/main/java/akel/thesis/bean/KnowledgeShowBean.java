package akel.thesis.bean;

import akel.thesis.logic.Rule;
import akel.thesis.model.KnowledgeEntity;
import akel.thesis.service.KnowledgeService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class KnowledgeShowBean implements Serializable{
    private int id;
    private KnowledgeEntity knowledge;
    private List<KnowledgeEntity> knowledgeList;
    private String commentary = "";
    private Rule rule = new Rule();

    @EJB
    private KnowledgeService knowledgeService;

    public void init(){
        knowledge = knowledgeService.find(id);
        knowledgeList =  knowledgeService.findAll();
        commentary = rule.generateCommentary(knowledge,knowledgeList);
    }

    public KnowledgeEntity getKnowledge(){
        return this.knowledge;
    }
    public void setKnowledge(KnowledgeEntity knowledge){
        this.knowledge = knowledge;
    }
    public String getCommentary(){
        return this.commentary;
    }
    public void setCommentary(String commentary){
        this.commentary = commentary;
    }

    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    public List<KnowledgeEntity> getKnowledgeList(){
        return knowledgeList;
    }
    public void setKnowledgeList(List<KnowledgeEntity> knowledgeList){
        this.knowledgeList = knowledgeList;
    }
}
