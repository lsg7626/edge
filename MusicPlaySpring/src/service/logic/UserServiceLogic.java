package service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.User;
import service.UserService;
import store.UserStore;
import store.logic.UserStoreLogic;

@Service
public class UserServiceLogic implements UserService{
	@Autowired
	private UserStore store;
	
	@Override
	public User login(User user) {
		return store.read(user.getLoginId());
	}

	@Override
	public boolean register(User user) {
		return store.create(user);
	}

	@Override
	public User find(String loginId) {
		return store.read(loginId);
	}
}
