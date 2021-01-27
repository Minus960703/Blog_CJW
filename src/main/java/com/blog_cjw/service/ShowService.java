package com.blog_cjw.service;

import java.util.List;

import com.blog_cjw.domain.BoardVO;

public interface ShowService {
	
	//카테고리 별 글 목록
	public List<BoardVO> list(String bPart) throws Exception;
	
	//전체 글 목록 ( portfolio 빼고)
	public List<BoardVO> listall() throws Exception;
	
	//게시물 조회
	public BoardVO view(int bno) throws Exception;
}
