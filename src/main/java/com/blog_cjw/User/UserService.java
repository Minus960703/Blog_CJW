package com.blog_cjw.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface UserService {

    //회원가입
    public void join(UserVO vo) throws Exception;

    //회원 로그인
    public UserVO login(UserVO vo) throws Exception;

    //회원 로그아웃
    public void logout(HttpSession session) throws Exception;

    //회원 리스트
    public List<UserVO> list() throws Exception;
}
