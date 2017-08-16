package service;

import java.util.List;

import domain.User;

public interface UserService {
	//
	void create(User user);
	
	List<User> readAll();
	
	User read(int id);
	
	void modify(User user);
	
	void delete(int id);
}
