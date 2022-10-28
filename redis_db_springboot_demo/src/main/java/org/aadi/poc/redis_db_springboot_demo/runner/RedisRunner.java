package org.aadi.poc.redis_db_springboot_demo.runner;

import org.aadi.poc.redis_db_springboot_demo.entity.Person;
import org.aadi.poc.redis_db_springboot_demo.repository.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RedisRunner implements CommandLineRunner{
	
	@Autowired
	private IPersonDao personDao;

	@Override
	public void run(String... args) throws Exception {
		personDao.addPerson(new Person(1,"Aadi",30));
		personDao.addPerson(new Person(2,"Santosh",28));
		personDao.modifyPerson(new Person(3,"Abhinav",31));

		personDao.removePerson(2);
		personDao.getAllPersons().forEach((k,v)->System.out.println(k+" : "+v));
		System.out.println(personDao.getPerson(1));
	}
}