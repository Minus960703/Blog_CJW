package com.blog_cjw.controller;

import java.util.List;

import javax.inject.Inject;

import com.blog_cjw.Board.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog_cjw.Board.BoardVO;
import com.blog_cjw.Board.Personal.PersonalService;

@Controller
@RequestMapping("/personal/*")
public class PersonalController {
	
	@Inject
	PersonalService service;
	
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

	//카테고리별 글 목록
	@RequestMapping("/listpage")
	public void getListpage(@RequestParam(value = "c", defaultValue="all") String bPart, Model model, @RequestParam("num") int num) throws Exception{

		Page page = new Page();

		page.setNum(num);
		page.setCount(service.count(bPart));

		List<BoardVO> list = null;
		list = service.listpage(page.getDisplayPost(), page.getPostNum());

		if(bPart.equals("all")){
			page.setCount(service.countall());
			list = service.listall();
		}
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("select", num);

	}

	
	//글 조회
	@RequestMapping("/view")
	public void getView(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("get view");
		
		BoardVO list = service.view(bno);
		
		model.addAttribute("list", list);
	}	
	
}
