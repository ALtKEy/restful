package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	private List<User> userLists;
	
	public UserDaoImpl() {
		this.userLists = new ArrayList<>();
		User user = new User(1,"홍길동","남");
		User user1 = new User(2,"홍길동1","남");
		User user2 = new User(3,"홍길동2","남");
		User user3 = new User(4,"홍길동3","남");
		User user4 = new User(5,"홍길동4","남");
		User user5 = new User(6,"홍길동5","남");
		User user6 = new User(7,"홍길동6","남");
		User user7 = new User(8,"홍길동7","남");
		User user8 = new User(9,"홍길동8","남");
		User user9 = new User(10,"홍길동9","남");
		userLists.add(user);
		userLists.add(user1);
		userLists.add(user2);
		userLists.add(user3);
		userLists.add(user4);
		userLists.add(user5);
		userLists.add(user6);
		userLists.add(user7);
		userLists.add(user8);
		userLists.add(user9);
	}
	
	@Override
	public void create(User user) {
		//
		userLists.add(user);
	}

	@Override
	public List<User> retrieveAll() {
		//
		return userLists;
	}

	@Override
	public void update(User user) {
		//
		for(User oUser : userLists) {
			if(oUser.getId() == user.getId()) {
				oUser.setName(user.getName());
				oUser.setGender(user.getGender());
			}
		}
	}

	@Override
	public void delete(int id) {
		//
		for(User oUser : userLists) {
			if(oUser.getId() == id) {
				userLists.remove(oUser.getId() - 1);
			}
		}
	}

}
