package akel.thesis.bean;

import akel.thesis.logic.Rule;
import akel.thesis.model.EventEntity;
import akel.thesis.service.EventService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EventShowBean implements Serializable{
    private int id;
    private String who;
    private EventEntity event;
    private List<EventEntity> eventList;
    private String commentary;
    private Rule rule = new Rule();
    @EJB
    private EventService eventService;

    public void show(){
        event=eventService.find(id);
        eventList=eventService.findByIdAndWho(id,who);
        commentary=rule.genelateCommentary(event,eventList);
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

    public EventEntity getEvent(){
        return event;
    }

    public void setEvent(EventEntity event){
        this.event = event;
    }

    public List<EventEntity> getEventList(){
        return eventList;
    }

    public void setEventList(List<EventEntity> eventList){
        this.eventList = eventList;
    }

    public String getCommentary(){
        return commentary;
    }

    public void setCommentary(String commentary){
        this.commentary = commentary;
    }
}
