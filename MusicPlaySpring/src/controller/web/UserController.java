package controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import domain.User;
import service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/join")
	public String showJoinForm(){
		return "join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(User user){
		boolean registered = service.register(user);
		if(!registered){
			return "redirect:join";
		} 
		return "redirect:list";
	}
	
	@RequestMapping("/login")
	public String showLoginForm(){
		return "login.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, HttpServletRequest req){
		User loginedUser = service.login(user);
		if(loginedUser != null){
			HttpSession session = req.getSession();
			session.setAttribute("loginedUser", loginedUser);
		} else {
			HttpSession session = req.getSession(false);
			session.invalidate();
		} return "redirect:list";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req){
		HttpSession session = req.getSession();
		session.invalidate();
		return "redirect:list";
	}
}
