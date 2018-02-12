package akel.thesis.logic;

import akel.thesis.model.EventEntity;

import java.util.List;

//イベントをルールに適応し、あっていれば解説を出力

public class Rule{
    public String genelateCommentary(EventEntity event, List<EventEntity> eventEntityList){
        String commentary = "";
        commentary+=isContinuousAccept(event,eventEntityList);
        return commentary;
    }
    //連続で不正解を出さずに正解を出していたら出力する。Order
    public String isContinuousAccept(EventEntity event, List<EventEntity> eventEntityList){
        int num = 1;
        //初っ端から正解
        //Order
        if(eventEntityList.isEmpty() && event.getWhat().equals("accept")) return "Correct answer from 1st question! It is a good start!";
        //不正解の場合
        //Order
        else if(!event.getWhat().equals("accept")) return "It was refused. You can do it!";
        //以前に提出している場合
        else return isContinuous(eventEntityList);


    }

    //連続で正解している回数or連続で不正解の回数を数えるて解説として出力(Order)
    public String isContinuous(List<EventEntity> eventEntityList){
        int continueCount=0;
        int flag=0;
        int count=1;
        String commentary="";

            if(eventEntityList.get(1).getWhat().equals("accept")){
                for(EventEntity e : eventEntityList){
                    if(e.getWhat().equals("accept")){
                        count++;
                        if(flag == 0) continueCount++;
                    }else flag = 1;
                }
                //Frequency
                commentary = "This submit accepted!\nThis team correctly answered "+count+" questions in total.\n";
                if(continueCount!=1) commentary+="And it Currently "+continueCount+" consecutive correct answers.";
            }else{
                for(EventEntity e : eventEntityList){
                    if(!e.getWhat().equals("accept")){
                        if(flag == 0) continueCount++;
                    }else {
                        flag = 1;
                        continueCount++;
                    }
                }
                //Order and Frequency
                commentary = "This submit accepted!\nThis team correctly answered "+count+" questions in total.\n";
                if(continueCount!=1) commentary+="Before accept this problem, this team has been rejected "+continueCount+" times. it worked hard and got the accept answer!";

            }
            return commentary;
        }

}
