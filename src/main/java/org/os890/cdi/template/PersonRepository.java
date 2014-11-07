package org.os890.cdi.template;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.Criteria;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

@Repository(forEntity = Person.class)
public abstract class PersonRepository extends BaseRepository<Person, String> implements IPersonRepository, CriteriaSupport<Person> {

	@Override
	public List<Person> searchAll(String v) {
        return criteria().eq(Person_.name,"king").getResultList();
    }
	
	/*@SuppressWarnings("unchecked")
	@Override
	public Long getCountRecode() {
		EntityType<E> e = entityManager.getMetamodel().entity(
				entityClass(getClass()));
		Criteria<Person, Person> crit = criteria();
		return crit.select(Long.class,
				count(Person_.name))
				.getSingleResult();
	}*/
	@Override
	protected Criteria<Person,Person> myCriteria(Criteria<Person,Person> crit,Person search){
		if(StringUtils.isNotEmpty(search.getName())){
			crit.eq(Person_.name, search.getName());
		}
		if(search.getAge() != null){
			crit.ltOrEq(Person_.age, search.getAge());
		}
		return crit;
	}
}
