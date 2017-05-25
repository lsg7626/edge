package store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import domain.Music;

public interface UserMusicStoreMapper {
	boolean create(@Param("userId") String userId, @Param("musicId") int musicId);
	boolean delete(@Param("userId") String userId, @Param("musicId") int musicId);
	String existUserMusic(@Param("userId") String userId, @Param("musicId") int musicId);
	List<Music> readMusicsByUser(String userId);
}