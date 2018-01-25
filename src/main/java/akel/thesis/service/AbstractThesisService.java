package akel.thesis.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractThesisService<T> extends AbstractService {
    @PersistenceContext(unitName = "thesis-persistence-unit")
    private EntityManager entityManager;

    public AbstractThesisService(Class<T> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }
}