package com.blog_cjw.Board.Personal;

import java.util.List;

import com.blog_cjw.Board.BoardVO;
import com.blog_cjw.Comment.CommentListVO;
import com.blog_cjw.Comment.CommentVO;

public interface PersonalService {
	
	//카테고리 별 글 목록
	public List<BoardVO> list(String bPart) throws Exception;

	//카테고리별 글 목록페이지
	public List<BoardVO> listpage(String bPart, int displayPost, int postNum) throws Exception;

	public List<BoardVO> listpageall(int displayPost, int postNum) throws Exception;

	//전체 글 목록 ( portfolio 빼고)
	public List<BoardVO> listall() throws Exception;
	
	//게시물 조회
	public BoardVO view(int bno) throws Exception;

	//게시물 총 갯수
	public int count(String bPart) throws Exception;

	//게시물 총 갯수 ( 포트폴리오 게시물 빼고 )
	public int countall() throws  Exception;

	//댓글 작성
	public void commentregist(CommentVO commentVO) throws Exception;

	//댓글 목록
	public List<CommentListVO> commentlist(int bno) throws Exception;

	//댓글 삭제
	public void commentdelete(CommentVO commentVO) throws Exception;

	//아이디 체크
	public String idCheck(int cno) throws Exception;
}
