package org.os890.cdi.test;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.os890.cdi.template.IPersonRepository;
import org.os890.cdi.template.Person;
import org.os890.cdi.template.Person_;

@RunWith(CdiTestRunner.class)
public class PersonTest {

	@Inject
    private IPersonRepository personRepository;

    @Test
    public void injectionTest(){
    	Person p = new Person();
    	p.setAge(22);
    	p.setName("king");
    	personRepository.save(p);
    	Person p1 = new Person();
    	p1.setAge(222);
    	p1.setName("king");
    	personRepository.save(p);
    	personRepository.save(p1);
    	
    	personRepository.searchAll("king");
    	personRepository.myCount(p);
    	personRepository.myList(p);
    	 personRepository.getCountRecode();
    	personRepository.get(Person_.age, 22);
    	personRepository.getList(Person_.name, "king");
    	personRepository.getListOrderByAttr(Person_.name, "king", Person_.age, false);
    }
}
