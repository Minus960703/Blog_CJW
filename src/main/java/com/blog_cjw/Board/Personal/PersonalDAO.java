package com.blog_cjw.Board.Personal;

import java.util.List;

import com.blog_cjw.Board.BoardVO;

public interface PersonalDAO {

	//카테고리 별 글 목록
	public List<BoardVO> list(String bPart) throws Exception;

	//카테고리별 글 목록페이지
	public List<BoardVO> listpage(int displayPost, int postNum, String bPart) throws Exception;

	//전체 글목록
	public List<BoardVO> listall() throws Exception;
	
	//게시물 조회
	public BoardVO view(int bno) throws Exception;

	//게시물 총 갯수
	public int count(String bPart) throws Exception;

	//포트폴리오 제외 게시물 갯수
	public int countall() throws Exception;
}
