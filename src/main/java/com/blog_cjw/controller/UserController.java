package com.blog_cjw.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.blog_cjw.domain.UserVO;
import com.blog_cjw.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@Inject
	UserService service;
	
	//회원가입
	@RequestMapping("/join")
	public void getJoin() throws Exception{
		System.out.println("회원가입");
	}
	
	//회원가입 보내기
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String postJoin(UserVO vo) throws Exception{
		System.out.println("회원가입 등록");
		
		vo.setUserPass(vo.getUserPass());
		
		service.join(vo);
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping("/login")
	public void getLogin() throws Exception{
		System.out.println("로그인");
	}
	
	//로그인 보내기
	@RequestMapping(value = "/login", method = RequestMethod.POST)
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
