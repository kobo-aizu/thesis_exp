package akel.akpcc.service;

import akel.akpcc.model.CommentaryEntity;

import javax.ejb.Stateless;

@Stateless
public class CommentaryService extends AbstractThesisService<CommentaryEntity>{
    public CommentaryService(){
        super(CommentaryEntity.class);
    }
}
