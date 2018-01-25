package akel.akpcc.service;

import akel.akpcc.model.EventEntity;

import javax.ejb.Stateless;

@Stateless
public class EventService extends AbstractThesisService<EventEntity>{
    public EventService(){
        super(EventEntity.class);
    }
}
