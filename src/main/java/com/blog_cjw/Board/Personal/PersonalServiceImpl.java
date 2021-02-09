package com.blog_cjw.Board.Personal;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blog_cjw.Board.BoardVO;

@Service
public class PersonalServiceImpl implements PersonalService {

	@Inject
	private PersonalDAO dao;

	//카테고리별 글 목록
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return dao.list(bPart);
	}

	@Override
	public List<BoardVO> listpage(String bPart, int displayPost, int postNum) throws Exception {
		return dao.listpage(bPart, displayPost, postNum);
	}

	@Override
	public List<BoardVO> listpageall(int displayPost, int postNum) throws Exception {
		return dao.listpageall(displayPost, postNum);
	}

	//전체 글 목록 ( portfolio 제외 )
	@Override
	public List<BoardVO> listall() throws Exception {
		return dao.listall();
	}

	@Override
	public BoardVO view(int bno) throws Exception {
		return dao.view(bno);
	}

	@Override
	public int count(String bPart) throws Exception {
		return dao.count(bPart);
	}

	@Override
	public int countall() throws Exception {
		return dao.countall();
	}

}
