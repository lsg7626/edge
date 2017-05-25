package controller.web;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Music;
import service.MusicService;

@Controller
public class MusicController {
	@Autowired
	private MusicService service;
	
	@RequestMapping("/")
	public String main(){
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public ModelAndView showMusicChart(HttpSession session){
		List<Music> list = service.findAll();
		ModelAndView modelAndView = new ModelAndView("list.jsp");
		String url = this.getClass().getResource("").getPath();
		url = url.substring(1, url.indexOf(".metadata")-1)+session.getServletContext().getContextPath();
		System.out.println(url);
		modelAndView.addObject("musics", list);
		return modelAndView;
	}
	
	@RequestMapping("/searchByName")
	public ModelAndView searchByName(@RequestParam("musicName") String name){
		List<Music> list = service.findByName(name);
		ModelAndView modelAndView = new ModelAndView("list.jsp");
		modelAndView.addObject("musics", list);
		return modelAndView;
	}
	
	@RequestMapping("/detail")
	public ModelAndView showDetail(@RequestParam("id") int id){
		ModelAndView modelAndView = new ModelAndView("detail.jsp");
		modelAndView.addObject("music", service.find(id));
		return modelAndView;
	}
}
