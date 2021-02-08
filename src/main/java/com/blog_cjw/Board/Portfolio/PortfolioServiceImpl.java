package com.blog_cjw.Board.Portfolio;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blog_cjw.Board.BoardVO;

@Service
public class PortfolioServiceImpl implements PortfolioService{

	@Inject
	PortfolioDAO dao;

	//글 목록
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return dao.list(bPart);
	}

	//글 조회
	@Override
	public BoardVO view(int bno) throws Exception {
		return dao.view(bno);
	}
}
