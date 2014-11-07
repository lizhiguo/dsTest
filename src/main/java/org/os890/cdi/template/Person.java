package org.os890.cdi.template;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer age;

	private String name;

	public Person() {
	}


	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
