package org.os890.cdi.test;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.os890.cdi.template.IPersonRepository;
import org.os890.cdi.template.Person;

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
    	personRepository.searchAll("king");
    }
}
