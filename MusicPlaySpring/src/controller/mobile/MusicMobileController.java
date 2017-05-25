package controller.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.Musics;
import service.MusicService;
import service.UserMusicService;

@Controller
public class MusicMobileController {

	@Autowired
	private MusicService musicService;
	
	@Autowired
	private UserMusicService userService;
	
	@RequestMapping(value="/mobilelist.do", produces="application/xml")
	public @ResponseBody Musics findAllMusics(){			
		Musics list = new Musics();
		list.setList(musicService.findAll());
		list.getList().get(10).setAgent("없는회사");
		return list;
	}
	
	@RequestMapping(value="/mobileuserlist.do", produces="application/xml")
	public @ResponseBody Musics findMusicByUser(String userId){
		Musics list = new Musics();
		list.setList(userService.findMusicsByUser(userId));
		return list;
	}
}
