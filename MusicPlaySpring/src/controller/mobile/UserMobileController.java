package controller.mobile;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Music;
import domain.Musics;
import domain.User;
import service.MusicService;
import service.UserMusicService;
import service.UserService;

@Controller
public class UserMobileController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private MusicService mService;
	
	@Autowired
	private UserMusicService umService;
	
	@RequestMapping(value="/mobilelogin")
	public @ResponseBody String mobileLogin(String loginId, String password){
		User user = new User();
		user.setLoginId(loginId);
		user.setPassword(password);
		user = service.login(user);
		if(user != null)
			return "true";
		else
			return "false";
	}
	
	@RequestMapping(value="/mobilelist", produces="application/xml")
	public @ResponseBody Musics mobileList(){
		List<Music> list = mService.findAll();
		
		Musics musics = new Musics();
		musics.setList(list);
		
		return musics;
	}
	
	@RequestMapping(value="/mobilefavorite", produces="application/xml")
	public @ResponseBody Musics mobileList(String userId){
		List<Music> list = umService.findMusicsByUser(userId);
		
		Musics musics = new Musics();
		musics.setList(list);
		
		return musics;
	}
	
	@RequestMapping(value="/mobileDetail", produces="application/xml")
	public @ResponseBody Musics mobileDetail(String musicId){
		Music music = mService.find(Integer.parseInt(musicId));
		
		Musics musics = new Musics();
		List<Music> list = new ArrayList<>();
		list.add(music);
		musics.setList(list);
		return musics;
	}
}
