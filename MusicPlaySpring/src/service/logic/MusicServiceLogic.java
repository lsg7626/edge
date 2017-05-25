package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Music;
import service.MusicService;
import store.MusicStore;
import store.logic.MusicStoreLogic;

@Service
public class MusicServiceLogic implements MusicService{
	@Autowired
	private MusicStore store;
	
	@Override
	public Music find(int id) {
		return store.read(id);
	}

	@Override
	public List<Music> findByName(String name) {
		return store.readByName(name);
	}

	@Override
	public List<Music> findAll() {
		return store.readAll();
	}

}
