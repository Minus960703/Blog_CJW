package com.blog_cjw.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog_cjw.domain.BoardVO;
import com.blog_cjw.service.PortfolioService;

@Controller
@RequestMapping("/portfolio/*")
public class PortFolioController {
	
	@Inject
	PortfolioService service;
	
	//포트폴리오 글 목록
	@RequestMapping("/list")
	public void getList(@RequestParam("c") String bPart, Model model) throws Exception{
		System.out.println("portfolio");
		
		List<BoardVO> list = service.list(bPart);
		
		model.addAttribute("list", list);
	}

	//글 조회
	@RequestMapping("/view")
	public void getView(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("get view");
		
		BoardVO board = service.view(bno);
		
		model.addAttribute("board", board);
	}
}
