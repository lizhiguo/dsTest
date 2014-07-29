package org.os890.cdi.template;

import java.util.List;

import org.apache.deltaspike.data.api.AbstractEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;

@Repository(forEntity = Person.class)
public abstract class PersonRepository extends AbstractEntityRepository<Person, Long> implements IPersonRepository,CriteriaSupport<Person> {
	@Override
	public List<Person> searchAll(String v) {
        return criteria().eq(Person_.name,"king").getResultList();
    }
}
