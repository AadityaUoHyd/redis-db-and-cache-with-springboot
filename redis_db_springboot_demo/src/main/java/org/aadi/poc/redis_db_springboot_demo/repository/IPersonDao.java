package org.aadi.poc.redis_db_springboot_demo.repository;

import java.util.Map;

import org.aadi.poc.redis_db_springboot_demo.entity.Person;

public interface IPersonDao {
	
	public void addPerson(Person p);
	public void modifyPerson(Person p);
	public Person getPerson(Integer id);
	public Map<Integer,Person> getAllPersons();
	public void removePerson(Integer id);

}