package com.blog_cjw.service;

import javax.servlet.http.HttpSession;

import com.blog_cjw.domain.UserVO;

public interface UserService {
	
	//회원 가입
	public void join(UserVO vo) throws Exception;
	
	//로그인
	public UserVO login(UserVO vo) throws Exception;
	
	//로그아웃
	public void logout(HttpSession session) throws Exception;

}
