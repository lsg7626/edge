package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Music;
import service.UserMusicService;
import store.UserMusicStore;
import store.logic.UserMusicStoreLogic;

@Service
public class UserMusicServiceLogic implements UserMusicService{
	@Autowired
	private UserMusicStore store;
	
	@Override
	public boolean register(String userId, int musicId) {
		if(store.existUserMusic(userId, musicId)){
			return false;
		}
		return store.create(userId, musicId);
	}

	@Override
	public boolean remove(String userId, int musicId) {
		return store.delete(userId, musicId);
	}

	@Override
	public List<Music> findMusicsByUser(String userId) {
		return store.readMusicsByUser(userId);
	}
	
}
