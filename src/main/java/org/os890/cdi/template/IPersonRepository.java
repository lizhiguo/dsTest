package org.os890.cdi.template;

import java.util.List;

import org.apache.deltaspike.data.api.EntityRepository;

public interface IPersonRepository extends EntityRepository<Person, Long>{

	List<Person> searchAll(String v);

}
