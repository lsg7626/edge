package controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import service.UserMusicService;

@Controller
public class UserMusicController {
	
	@Autowired
	private UserMusicService service;

	@RequestMapping("/favoriteList")
	public ModelAndView showFavoriteList(HttpServletRequest req){
		
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("loginedUser") == null){
			ModelAndView modelAndView = new ModelAndView("redirect:login");
		}
		
		User user = (User)session.getAttribute("loginedUser");
		
		ModelAndView modelAndView = new ModelAndView("myList.jsp");
		modelAndView.addObject("list", service.findMusicsByUser(user.getLoginId()));
		
		return modelAndView;
	}
	
	@RequestMapping("/addFavorite")
	public String addFavoriteMusic(@RequestParam("musicId") int musicId, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("loginedUser") == null) {
			return "redirect:login";
		}
		User user = (User) session.getAttribute("loginedUser");
		service.register(user.getLoginId(), musicId);
		
		return "redirect:favoriteList";
	}
	
	@RequestMapping("/deleteFavorite")
	public String removeFavoriteMusic(@RequestParam("musicId") int musicId, HttpServletRequest req){
		HttpSession session = req.getSession(false);
		if(session == null || session.getAttribute("loginedUser") == null) {
			return "redirect:login";
		}
		User user = (User) session.getAttribute("loginedUser");
		service.remove(user.getLoginId(), musicId);
		
		return "redirect:favoriteList";
	}
}
