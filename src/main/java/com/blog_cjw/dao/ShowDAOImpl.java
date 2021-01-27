package com.blog_cjw.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.blog_cjw.domain.BoardVO;

@Repository
public class ShowDAOImpl implements ShowDAO{

	@Inject
	SqlSession sql;
	
	//매퍼
	private static String namespace = "com.blog_cjw.mappers.showMapper";
	
	//카테고리별 글 목록
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return sql.selectList(namespace + ".list", bPart);
	}

	//전체 글 목록( portfolio 제외 )
	@Override
	public List<BoardVO> listall() throws Exception { 
		return sql.selectList(namespace + ".listall");
	}

	//글 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		return sql.selectOne(namespace + ".view", bno);
	}

}
