package com.blog_cjw.Board.Portfolio;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.blog_cjw.Board.BoardVO;

@Repository
public class PortfolioDAOImpl implements PortfolioDAO{

	@Inject
	SqlSession sql;
	
	//글 목록 
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return sql.selectList("com.blog_cjw.mappers.personalMapper" + ".list", bPart);
	}

	//글 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		return sql.selectOne("com.blog_cjw.mappers.personalMapper" + ".view", bno);
	}

	
}
