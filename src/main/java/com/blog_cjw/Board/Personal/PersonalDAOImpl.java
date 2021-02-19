package com.blog_cjw.Board.Personal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import com.blog_cjw.Comment.CommentListVO;
import com.blog_cjw.Comment.CommentVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.blog_cjw.Board.BoardVO;

@Repository
public class PersonalDAOImpl implements PersonalDAO {

	@Inject
	SqlSession sql;

	//매퍼
	private static String namespace = "com.blog_cjw.mappers.personalMapper";

	//카테고리별 글 목록
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return sql.selectList(namespace + ".list", bPart);
	}

	@Override
	public List<BoardVO> listpage(String bPart, int displayPost, int postNum) throws Exception {
		Map<String, Object> data = new HashMap<String, Object>();

		data.put("bPart", bPart);
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);

		return sql.selectList(namespace + ".listpage", data);
	}

	@Override
	public List<BoardVO> listpageall(int displayPost, int postNum) throws Exception {
		Map<String, Integer> data = new HashMap<String, Integer>();

		data.put("displayPost",displayPost);
		data.put("postNum",postNum);

		return sql.selectList(namespace + ".listpageall", data);
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

	@Override
	public int count(String bPart) throws Exception {
		return sql.selectOne(namespace + ".count", bPart);
	}

	@Override
	public int countall() throws Exception {
		return sql.selectOne(namespace + ".countall");
	}

	@Override
	public void commentregist(CommentVO commentVO) throws Exception {
		sql.insert(namespace + ".commentregist", commentVO);
	}

	@Override
	public List<CommentListVO> commentlist(int bno) throws Exception {
		return sql.selectList(namespace + ".commentlist", bno);
	}
}
