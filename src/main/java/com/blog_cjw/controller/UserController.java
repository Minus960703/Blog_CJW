package com.blog_cjw.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.blog_cjw.User.UserService;
import com.blog_cjw.User.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Inject
	UserService service;
	
	//회원가입
	@GetMapping("/join")
	public void getJoin() throws Exception{
		System.out.println("회원가입");
	}
	
	//회원가입 보내기
	@PostMapping("/join")
	public String postJoin(UserVO vo) throws Exception{
		System.out.println("회원가입 등록");
		
		service.join(vo);
		
		return "redirect:/";
	}
	
	//로그인
	@GetMapping("/login")
	public void getLogin() throws Exception{
		System.out.println("로그인");
	}
	
	//로그인 보내기
	@PostMapping("/login")
	public String postLogin(UserVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		System.out.println("로그인 시도");
		
		UserVO login = service.login(vo);
		HttpSession session = req.getSession();
		
		if(login != null) {
			session.setAttribute("user", login);
		}
		else {
			session.setAttribute("user", null);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/user/login";
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception{
		System.out.println("로그아웃");
		service.logout(session);
		
		return "redirect:/";
	}
	
	
	
}
