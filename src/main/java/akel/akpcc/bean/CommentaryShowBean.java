package akel.akpcc.bean;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CommentaryShowBean implements Serializable{
    private int id;
    private String who;

    public void show(){

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
}
