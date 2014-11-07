package org.os890.cdi.template;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.data.spi.DelegateQueryHandler;
import org.apache.deltaspike.data.spi.QueryInvocationContext;

public class MyEntityRepositoryDelegate<E> implements DelegateQueryHandler, MyEntityRepository<E>{

    @Inject
    private QueryInvocationContext context;

    @Override
    public E saveAndFlushAndRefresh(E entity)
    {
        entityManager().persist(entity);
        entityManager().flush();
        entityManager().refresh(entity);
        return entity;
    }
    
    @Override
    public EntityManager entityManager(){
        return context.getEntityManager();
    }

}
