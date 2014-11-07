package org.os890.cdi.template;

import java.util.List;

public interface IPersonRepository extends IBaseRepository<Person, String>{

	List<Person> searchAll(String v);

}
