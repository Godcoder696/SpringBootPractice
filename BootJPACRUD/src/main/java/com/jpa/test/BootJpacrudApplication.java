package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootJpacrudApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(BootJpacrudApplication.class, args);
		
		UserRepository userRepository= context.getBean(UserRepository.class);
		
//		1. Create
//		User user= new User();
//		user.setName("Lakshay yadav");
//		user.setCity("Delhi");
//		user.setStatus("completed");
//
//		User user1= new User();
//		user1.setName("Ritesh Dhiman");
//		user1.setCity("Gurgaon");
//		user1.setStatus("inprogress");
//
//		User user2= new User();
//		user2.setName("Ananya V A");
//		user2.setCity("Dwarka");
//		user2.setStatus("done");
//		
//		List<User> createUsers= List.of(user,user1,user2);
//		Iterable<User> save= userRepository.saveAll(createUsers);
//		System.out.println(save);
		
//		2. Update
//		Optional<User> foundUserObj=userRepository.findById(1);
//		User foundUsr= foundUserObj.get();
//		foundUsr.setName("Lakshay Yadav");
//		User save= userRepository.save(foundUsr);
//		System.out.println(save);
		
//		3. Get all data
//		Iterable<User> itr= userRepository.findAll();
//		itr.forEach(user->System.out.println(user));
		
//		4. Delete
//		userRepository.deleteById(1);
//		Iterable<User> itr= userRepository.findAll();
//		itr.forEach(user->System.out.println(user));
//		userRepository.deleteAll(itr);
		
//		5. Custom Finders
//		Link: https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#reference
		List<User> foundUsr= userRepository.findByName("Lakshay yadav");
		foundUsr.forEach(usr->{
			System.out.println(usr);
		});
	}

}
