package dao;

import java.util.List;

import domain.User;

public interface UserDao {
	//
	void create(User user);
	
	List<User> retrieveAll();
	
	void update(User user);
	
	void delete(int id);
}
