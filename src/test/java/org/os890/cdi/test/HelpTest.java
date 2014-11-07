package org.os890.cdi.test;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.os890.cdi.template.Help;
import org.os890.cdi.template.HelpService;

@RunWith(CdiTestRunner.class)
public class HelpTest {
	@Inject
    private HelpService helpService;
	@Test
    public void injectionTest(){
		Help h = helpService.getHelp(1L);
		System.out.println("-------"+h.getName());
	}
}
