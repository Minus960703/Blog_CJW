package com.blog_cjw.service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.blog_cjw.dao.UserDAO;
import com.blog_cjw.domain.UserVO;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	UserDAO dao;
	
	//회원가입
	@Override
	public void join(UserVO vo) throws Exception {
		dao.join(vo);
	}
	
	//로그인
	@Override
	public UserVO login(UserVO vo) throws Exception {
		return dao.login(vo);
	}

	//로그아웃
	@Override
	public void logout(HttpSession session) throws Exception {
		session.invalidate();//세션 종료
	}
	
	

}
