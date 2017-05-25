package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Music;
import store.UserMusicStore;
import store.mapper.UserMusicStoreMapper;

@Repository
public class UserMusicStoreLogic implements UserMusicStore{
	private SqlSessionFactory factory;
	
	public UserMusicStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public boolean create(String userId, int musicId) {
		SqlSession session = factory.openSession();
		boolean insert = false;
		try{
			UserMusicStoreMapper mapper = session.getMapper(UserMusicStoreMapper.class);
			insert = mapper.create(userId, musicId);
			session.commit();
		} finally {
			session.close();
		}
		return insert;
	}

	@Override
	public boolean delete(String userId, int musicId) {
		SqlSession session = factory.openSession();
		boolean isDel = false;
		
		try{
			UserMusicStoreMapper mapper = session.getMapper(UserMusicStoreMapper.class);
			isDel = mapper.delete(userId, musicId);
			session.commit();
		} finally {
			session.close();
		}
		return isDel;
	}
	

	@Override
	public boolean existUserMusic(String userId, int musicId) {
		SqlSession session = factory.openSession();
		String user = null;
		boolean isReg = false;
		try{
			UserMusicStoreMapper mapper = session.getMapper(UserMusicStoreMapper.class);
			user = mapper.existUserMusic(userId, musicId);
			if(user != null)
				isReg = true;
			
		} finally {
			session.close();
		}
		return isReg;
	}

	@Override
	public List<Music> readMusicsByUser(String userId) {
		SqlSession session = factory.openSession();
		List<Music> list = null;
		try{
			UserMusicStoreMapper mapper = session.getMapper(UserMusicStoreMapper.class);
			list = mapper.readMusicsByUser(userId);
		} finally {
			session.close();
		}
		return list;
	}
}
