package akel.thesis.bean;

import akel.thesis.model.EventEntity;
import akel.thesis.service.EventService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class EventListBean implements Serializable{
    @EJB
    EventService eventService;

    private List<EventEntity> eventList;


    public List<EventEntity> getEventList(){
        return eventList;
    }

    public void setCommentaryList(List<EventEntity> commentaryList){
        this.eventList = commentaryList;
    }

    public void init(){
        eventList = eventService.findAll();
    }
}
