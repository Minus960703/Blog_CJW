package com.blog_cjw.User;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Inject
    UserDAO dao;

    @Override
    public void join(UserVO vo) throws Exception {
        dao.join(vo);
    }

    @Override
    public UserVO login(UserVO vo) throws Exception {
        return dao.login(vo);
    }

    @Override
    public void logout(HttpSession session) throws Exception {
        session.invalidate(); //세션 종료
    }

    @Override
    public List<UserVO> list() throws Exception {
        return null;
    }
}
