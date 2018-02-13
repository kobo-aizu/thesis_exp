package akel.thesis.service;

import akel.thesis.model.TeamEntity;

import javax.ejb.Stateless;

@Stateless
public class TeamService extends AbstractThesisService<TeamEntity>{
    public TeamService(){
        super(TeamEntity.class);
    }
}
