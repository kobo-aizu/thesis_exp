package akel.thesis.bean;

import akel.thesis.model.CommentaryEntity;
import akel.thesis.service.CommentaryService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class CommentaryShowBean implements Serializable{
    private int id;
    private String who;
    private int effort_total;
    private CommentaryEntity commentary;
    private List<CommentaryEntity> commentaryList;

    @EJB
    CommentaryService commentaryService;

    public void show(){
        commentary=commentaryService.find(id);
        effort_total=commentaryService.SumEffortPoint(id,who);
        commentaryList=commentaryService.findByIdAndWho(id,who);
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getWho(){
        return who;
    }

    public void setWho(String who){
        this.who = who;
    }

    public int getEffort_total(){
        return effort_total;
    }

    public void setEffort_total(int effort_total){
        this.effort_total = effort_total;
    }

    public CommentaryEntity getCommentary(){
        return commentary;
    }

    public void setCommentary(CommentaryEntity commentary){
        this.commentary = commentary;
    }

    public List<CommentaryEntity> getCommentaryList(){
        return commentaryList;
    }

    public void setCommentaryList(List<CommentaryEntity> commentaryList){
        this.commentaryList = commentaryList;
    }

    public String makeCommentary(int effort_total){
        if(effort_total<7) return "It is still to come.";
        else if(effort_total<=15) return "It can work harder!";
        else if(effort_total<=28) return "It has a lot of challenges";
        else return "It's doing the best!";
    }

}
