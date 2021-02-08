package com.blog_cjw.Board.Portfolio;

import java.util.List;

import com.blog_cjw.Board.BoardVO;

public interface PortfolioDAO {
	
	//글 목록
	public List<BoardVO> list(String bPart) throws Exception;

	//게시물 조회
	public BoardVO view(int bno) throws Exception;	
}
