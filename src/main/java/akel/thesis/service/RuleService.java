package akel.thesis.service;

import akel.thesis.model.RuleEntity;

import javax.ejb.Stateless;

@Stateless
public class RuleService extends AbstractThesisService<RuleEntity>{
    public RuleService(){
        super(RuleEntity.class);
    }
}
