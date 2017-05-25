package store.logic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.User;
import store.UserStore;
import store.mapper.UserStoreMapper;

@Repository
public class UserStoreLogic implements UserStore{
	private SqlSessionFactory factory;
	
	public UserStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public boolean create(User user) {
		SqlSession session = factory.openSession();
		boolean insert = false;
		try {
			UserStoreMapper mapper = session.getMapper(UserStoreMapper.class);
			insert = mapper.create(user);
			session.commit();
		} finally {
			session.close();
		}
		return insert;
	}

	@Override
	public User read(String id) {
		SqlSession session = factory.openSession();
		User user = null;
		try {
			UserStoreMapper mapper = session.getMapper(UserStoreMapper.class);
			user = mapper.read(id);
		} finally {
			session.close();
		}
		return user;
	}

}
