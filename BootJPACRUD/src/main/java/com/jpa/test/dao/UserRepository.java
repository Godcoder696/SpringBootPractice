package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	public List<User> findByName(String name);
	
	@Query("Select u from User u")
	public List<User> findUsers();
	
	@Query("Select u from User u WHERE u.name =:n and u.city =:c")
	public List<User> getUsersByName(@Param("n") String name, @Param("c") String city);
	
	@Query(value="select * from User",nativeQuery = true)
	public List<User> getUsersByNameNative();
}
