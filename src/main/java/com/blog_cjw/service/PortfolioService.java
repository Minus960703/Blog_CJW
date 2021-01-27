package com.blog_cjw.service;

import java.util.List;

import com.blog_cjw.domain.BoardVO;

public interface PortfolioService {

	//글 목록
	public List<BoardVO> list(String bPart) throws Exception;
	
	//게시물 조회
	public BoardVO view(int bno) throws Exception;
}
