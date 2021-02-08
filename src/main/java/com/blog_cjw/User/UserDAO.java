package com.blog_cjw.User;

import java.util.List;

public interface UserDAO {

    //회원 가입
    public void join(UserVO vo) throws Exception;

    //회원 조회
    public List<UserVO> list() throws Exception;

    //회원 로그인
    public UserVO login(UserVO vo) throws  Exception;

}
