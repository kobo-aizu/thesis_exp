package akel.thesis.bean;

import akel.thesis.model.KnowledgeEntity;
import akel.thesis.service.KnowledgeService;
import akel.thesis.service.ProblemService;
import akel.thesis.service.ScoreService;
import akel.thesis.service.TeamService;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class KnowledgeShowBean implements Serializable{
    private KnowledgeEntity knowledge;

    @EJB
    private KnowledgeService knowledgeService;
    @EJB
    private TeamService teamService;
    @EJB
    private ProblemService problemService;
    @EJB
    private ScoreService scoreService;

}
