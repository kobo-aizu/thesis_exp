package akel.thesis.service;

import akel.thesis.model.ScoreEntity;

import javax.ejb.Stateless;

@Stateless
public class ScoreService extends AbstractThesisService<ScoreEntity>{
    public ScoreService(){
        super(ScoreEntity.class);
    }
}
