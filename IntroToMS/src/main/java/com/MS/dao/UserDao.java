package com.MS.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.MS.entities.User;
@Component
public class UserDao {

	public static List<User>users = new ArrayList();
	public static int userCount=0;
	
	static {
		users.add(new User(++userCount,"Akash",LocalDate.now().minusYears(24)));
		users.add(new User(++userCount,"Sahil",LocalDate.now().minusYears(20)));
		users.add(new User(++userCount,"Simmi",LocalDate.now().minusYears(18)));
	}
	
	
	public List<User>getUsers(){
		return this.users;
	}
	
	public User getUser(int id) {
		return users.stream().filter((user)->user.getId()==id).findFirst().orElse(null);
	}
	
	public User createUser(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

	public void deleteUser(int id) {
		
		users.removeIf((user)->user.getId()==id);
		// TODO Auto-generated method stub
		
	}
}
