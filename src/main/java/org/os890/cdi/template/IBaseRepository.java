package org.os890.cdi.template;

import java.io.Serializable;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.apache.deltaspike.data.api.EntityRepository;

public interface IBaseRepository<E, PK extends Serializable> extends EntityRepository<E, Serializable>,MyEntityRepository<E>{

	Long getCountRecode();

	<P> E get(SingularAttribute<? super E, P> att, P value);

	<P> List<E> getList(SingularAttribute<? super E, P> att, P value);

	<P,V> List<E> getListOrderByAttr(SingularAttribute<? super E, P> att, P value,
			SingularAttribute<? super E, V> order, boolean flg);

	Long myCount(E search);

	List<E> myList(E search);

}
