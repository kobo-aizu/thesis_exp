package akel.thesis.logic;

import akel.thesis.model.KnowledgeEntity;
import akel.thesis.model.TeamEntity;
import akel.thesis.service.KnowledgeService;
import akel.thesis.service.ProblemService;
import akel.thesis.service.ScoreService;
import akel.thesis.service.TeamService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//イベントをルールに適応し、あっていれば解説を出力

public class Rule{
    public String generateCommentary(KnowledgeEntity knowledge,List<KnowledgeEntity> knowledgeList){
        String commentary = "";
        if(knowledge.getWhat().equals("reject")) return "This submit is rejected...";
        else{
            commentary += "Accept this problem. \n";
            commentary += isFirstAccept(knowledge,knowledgeList);
            commentary += isContinuous(knowledge,knowledgeList);

        }
        return commentary;
    }

    public String isFirstAccept(KnowledgeEntity knowledge,List<KnowledgeEntity> knowledgeList){
        String commentary ="";
        String commentarySegment="";
        KnowledgeEntity row;
        int totalAccept=0;
        for(int i = 0;i<knowledge.getId();i++){
            row=knowledgeList.get(i);
            if(row.getWhat().equals("accept")) totalAccept++;
            if(row.knowledgeSource().equals("team") && knowledge.getWho().equals(row.getWho())) commentarySegment+=row.getWhat();
        }

        if(totalAccept==1){
            commentary+="The first accept for "+ knowledge.getWho() +".\n" + commentarySegment +"\n";
        }
        return commentary;
    }


    /**public String genelateCommentary(EventEntity event, List<EventEntity> eventEntityList){
        String commentary = "";
        commentary+=isContinuousAccept(event,eventEntityList);
        return commentary;
    }
    //連続で不正解を出さずに正解を出していたら出力する。Order
     **/

    //連続で正解している回数or連続で不正解の回数を数えるて解説として出力(Order)
    public String isContinuous(KnowledgeEntity knowledge , List<KnowledgeEntity> knowledgeList){
        int continueCount=1;
        int flag=0;
        int count=1;
        List<KnowledgeEntity> knowledgeListbyWho = new ArrayList<KnowledgeEntity>();
        String commentary="";

        //1チームの提出情報のみを集めたリストを作る。
        for(KnowledgeEntity e:knowledgeList){
            if(e.getId()==knowledge.getId()) break;
            if(e.getWho().equals(knowledge.getWho()) && e.knowledgeSource().equals("submit")) knowledgeListbyWho.add(e);
        }

        if(knowledgeListbyWho.isEmpty()) return commentary;
        Collections.reverse(knowledgeListbyWho);
            if(knowledgeListbyWho.get(0).getWhat().equals("accept")){
                for(KnowledgeEntity e : knowledgeListbyWho){
                    if(e.getWhat().equals("accept")){
                        count++;
                        if(flag == 0) continueCount++;
                    }else flag = 1;
                }
                //Frequency
                commentary += "This team correctly answered "+count+" questions in total.\n";
                if(continueCount!=1) commentary+="And it Currently "+continueCount+" consecutive correct answers.";
            }else{
                continueCount=0;
                for(KnowledgeEntity e : knowledgeListbyWho){
                    if(!e.getWhat().equals("accept")){
                        if(flag == 0) continueCount++;
                    }else {
                        flag = 1;
                        count++;
                    }
                }
                //Order and Frequency
                commentary = "This team correctly answered "+count+" questions in total.\n";
                if(continueCount!=0) commentary+="Before accept this problem, this team has been rejected "+continueCount+" times. it worked hard and got the accept answer!";

            }
            return commentary;
        }
}
