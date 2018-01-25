package akel.thesis.service;

import akel.thesis.model.FactEntity;

import javax.ejb.Stateless;

@Stateless
public class FactService extends AbstractThesisService<FactEntity>{
    public FactService(){
        super(FactEntity.class);
    }
}
