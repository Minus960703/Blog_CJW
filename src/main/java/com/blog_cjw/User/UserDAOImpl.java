package com.blog_cjw.User;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Inject
    SqlSession sql;

    public static String namespace = "com.blog_cjw.mappers.userMapper";

    //회원 가입
    @Override
    public void join(UserVO vo) throws Exception {
        sql.insert(namespace + ".join", vo);
    }

    //회원 조회
    @Override
    public List<UserVO> list() throws Exception {
        return sql.selectList(namespace + ".list");
    }

    //회원 로그인
    @Override
    public UserVO login(UserVO vo) throws Exception {
        return sql.selectOne(namespace + ".login", vo);
    }
}
