package com.blog_cjw.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.blog_cjw.dao.ShowDAO;
import com.blog_cjw.domain.BoardVO;

@Service
public class ShowServiceImpl implements ShowService{

	@Inject
	private ShowDAO dao;
	
	//카테고리별 글 목록
	@Override
	public List<BoardVO> list(String bPart) throws Exception {
		return dao.list(bPart);
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

}
