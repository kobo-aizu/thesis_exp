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
public class CommentaryListBean implements Serializable{
    @EJB
    CommentaryService commentaryService;

    private List<CommentaryEntity> commentaryList;


    public List<CommentaryEntity> getCommentaryList(){
        return commentaryList;
    }

    public void setCommentaryList(List<CommentaryEntity> commentaryList){
        this.commentaryList = commentaryList;
    }

    public void init(){
        commentaryList = commentaryService.findAll();
    }
}