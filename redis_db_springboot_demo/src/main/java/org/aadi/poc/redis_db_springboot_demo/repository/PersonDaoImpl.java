package org.aadi.poc.redis_db_springboot_demo.repository;

import java.util.Map;

import javax.annotation.Resource;

import org.aadi.poc.redis_db_springboot_demo.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements IPersonDao {

	
	@Value("${redis.key}")
	private String KEY;

	@Resource(name = "redisTemplate")
	private HashOperations<String, Integer, Person> hashOperations;

	@Override
	public void addPerson(Person p) {
		hashOperations.putIfAbsent(KEY, p.getId(), p);
	}

	@Override
	public void modifyPerson(Person p) {
		hashOperations.put(KEY, p.getId(), p);
	}

	@Override
	public Person getPerson(Integer id) {
		return hashOperations.get(KEY, id);
	}

	@Override
	public Map<Integer, Person> getAllPersons() {
		return hashOperations.entries(KEY);
	}

	@Override
	public void removePerson(Integer id) {
		hashOperations.delete(KEY, id);
	}

}