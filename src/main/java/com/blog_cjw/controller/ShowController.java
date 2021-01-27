package com.blog_cjw.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog_cjw.domain.BoardVO;
import com.blog_cjw.service.ShowService;

@Controller
@RequestMapping("/show/*")
public class ShowController {
	
	@Inject
	ShowService service;
	
	//카테고리별 글 목록
	@RequestMapping("/list")
	public void getList(@RequestParam(value = "c", defaultValue="all") String bPart, Model model) throws Exception{
		System.out.println("get list");
		
		List<BoardVO> list = service.list(bPart);
		if(bPart.equals("all")) {
			list = service.listall();
		}
		
		model.addAttribute("list", list);
	}
	
	//글 조회
	@RequestMapping("/view")
	public void getView(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("get view");
		
		BoardVO list = service.view(bno);
		
		model.addAttribute("list", list);
	}	
	
}
