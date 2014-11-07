package org.os890.cdi.template;

import javax.persistence.EntityManager;

public interface MyEntityRepository<E> {

	EntityManager entityManager();

	E saveAndFlushAndRefresh(E entity);

}
