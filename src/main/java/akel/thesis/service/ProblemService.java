package akel.thesis.service;

import akel.thesis.model.ProblemEntity;

import javax.ejb.Stateless;

@Stateless
public class ProblemService extends AbstractThesisService<ProblemEntity>{
    public ProblemService(){
        super(ProblemEntity.class);
    }

}
