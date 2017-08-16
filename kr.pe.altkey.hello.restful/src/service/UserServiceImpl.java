package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDaoImpl) {
		this.userDao = userDaoImpl;
	}

	@Override
	public void create(User user) {
		//
		userDao.create(user);
	}

	@Override
	public List<User> readAll() {
		//
		List<User> userLists = userDao.retrieveAll();
		return userLists;
	}
	
	@Override
	public User read(int id) {
		//
		User returnUser = new User();
		List<User> userLists = userDao.retrieveAll();
		for(User oUser : userLists) {
			if(id == oUser.getId()) {
				returnUser = oUser;
				break;
			} else {
				continue;
			}
		}
		
		return returnUser;
	}
	
	@Override
	public void modify(User user) {
		//
		userDao.update(user);

	}

	@Override
	public void delete(int id) {
		//
		userDao.delete(id);
	}

}
