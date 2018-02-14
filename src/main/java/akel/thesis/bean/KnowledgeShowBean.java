package akel.thesis.bean;

import akel.thesis.logic.Rule;
import akel.thesis.model.KnowledgeEntity;
import akel.thesis.model.TeamEntity;
import akel.thesis.service.KnowledgeService;
import akel.thesis.service.ProblemService;
import akel.thesis.service.ScoreService;
import akel.thesis.service.TeamService;

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
    @EJB
    private TeamService teamService;


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


    /**public String generateCommentary(KnowledgeEntity knowledge){
        String commentary = "";
        if(knowledge.getWhat().equals("reject")) return "This submit is rejected...";
        else{
            commentary += "Accept this problem. \n";
            commentary += isFirstAccept(knowledge);

        }
        return commentary;
    }

    public String isFirstAccept(KnowledgeEntity knowledge){
        String commentary ="";
        TeamEntity team = teamService.findByName(knowledge.getWho());
        int totalAccept=knowledgeService.countByIdandWho(knowledge.getId(),knowledge.getWho());
        if(totalAccept==1){
            commentary+="The first accept for WHO.\n" + team.getDescription() +"\n";
        }
        return commentary;
    }**/

    public List<KnowledgeEntity> getKnowledgeList(){
        return knowledgeList;
    }

    public void setKnowledgeList(List<KnowledgeEntity> knowledgeList){
        this.knowledgeList = knowledgeList;
    }
}
