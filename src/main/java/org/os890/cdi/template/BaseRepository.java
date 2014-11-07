package org.os890.cdi.template;

import java.io.Serializable;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;
import org.apache.deltaspike.data.impl.meta.extractor.TypeMetadataExtractor;
import org.apache.deltaspike.data.impl.util.EntityUtils;

public abstract class BaseRepository<E, PK extends Serializable> implements 
		IBaseRepository<E, PK>, EntityRepository<E, Serializable>,MyEntityRepository<E>,
		CriteriaSupport<E> {
	/**
	 * 通过属性获得对象
	 */
	@Override
	public <P> E get(SingularAttribute<? super E, P> att, P value) {
		return criteria().eq(att, value).getSingleResult();
	}
	/*
	 * 通过属性获得对象集合
	 */
	@Override
	public <P> List<E> getList(SingularAttribute<? super E, P> att, P value) {
		if (value == null) {
			return criteria().isNull(att).getResultList();
		} else {
			return criteria().eq(att, value).getResultList();
		}
	}
	/**
	 * 
	 * <p>
	 * Description:这里写描述<br />
	 * </p>
	 * @author king
	 * @version 0.1 2014年4月28日
	 * @param att
	 * @param value
	 * @param order
	 * @param flg true:asc flase:desc
	 * @return
	 * List<E>
	 */
	@Override
	public <P,V> List<E> getListOrderByAttr(SingularAttribute<? super E, P> att, P value,SingularAttribute<? super E, V> order,boolean flg) {
		if (value == null) {
			if(flg){
				return criteria().isNull(att).orderAsc(order).getResultList();
			}
			return criteria().isNull(att).orderDesc(order).getResultList();
		} else {
			if(flg){
				return criteria().eq(att, value).orderAsc(order).getResultList();
			}
			return criteria().eq(att, value).orderDesc(order).getResultList();
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long getCountRecode() {
		/*EntityType<E> e = entityManager().getMetamodel().entity(
				entityClass(getClass()));*/
//		Criteria<E, E> crit = criteria();
		return criteria().select(Long.class,
//				count((SingularAttribute<E, ?>) e.getSingularAttribute("id")))
				count((SingularAttribute<E, ?>) BaseEntity_.id))
				.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public Long myCount(E search){
		Criteria<E, E> crit = criteria();
		myCriteria(crit,search);
		return crit.select(Long.class,count((SingularAttribute<E, ?>) BaseEntity_.id)).getSingleResult();
	}
	@Override
	public List<E> myList(E search){
		Criteria<E, E> crit = criteria();
		myCriteria(crit,search);
		return crit.getResultList();
	}
		
	protected abstract Criteria<E, E> myCriteria(Criteria<E,E> crit,E search);

	@SuppressWarnings({ "unchecked", "unused" })
	private Class<E> entityClass(Class<?> homeClass) {
		return (Class<E>) new TypeMetadataExtractor().extract(homeClass)
				.getEntityClass();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private PK primaryKeyValue(Object entity) {
		return (PK) EntityUtils.primaryKeyValue(entity);
	}
}
