package com.blog_cjw.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.blog_cjw.domain.BoardVO;
import com.blog_cjw.domain.UserVO;
import com.blog_cjw.service.BoardService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/admin/*")
public class AdminController {

	@Inject 
	private BoardService service;
	
	//게시물 목록
	@RequestMapping("/board/list")
	public void getList(Model model) throws Exception{
		List<BoardVO> list = null;
		list = service.list();
		
		model.addAttribute("list", list);
		
		
		//UserVO user = (UserVO)session.getAttribute("user");
	}
	
	//게시물 작성
	@RequestMapping("/board/write")
	public void getWrite() throws Exception{
		
	}
	
	//게시물 작성 보내기
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo, HttpSession session, @RequestParam("bThumbnail") String bThumbnail, @RequestParam("bPart") String bPart) throws Exception{
		System.out.println("글쓰기");
		
		if(bThumbnail.equals("null")){
			vo.setbThumbnail("/resources/img/default.png");
		}
		
		UserVO user = (UserVO)session.getAttribute("user");
		vo.setUserId(user.getUserId());
		
		service.write(vo);
		
		if(bPart.equals("portfolio")) {
			return "redirect:/portfolio/list?c=portfolio";
		}
		
		return "redirect:/show/list";
	}
	
	//글 조회
	@RequestMapping("/board/view")
	public void getView(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("get view");
		
		BoardVO board = service.view(bno);
		
		model.addAttribute("board", board);
	}
	
	//글 수정
	@RequestMapping("/board/modify")
	public void getModify(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("글 수정");
		
		BoardVO board = service.view(bno);
		model.addAttribute("board", board);
	}
	
	//글 수정
	@RequestMapping(value = "/board/modify", method = RequestMethod.POST)
	public String postModify(BoardVO vo, MultipartFile file, HttpServletRequest req, @RequestParam("bThumbnail") String bThumbnail, @RequestParam("bPart") String bPart) throws Exception{
		System.out.println("글 수정 시도");
		
		if(bThumbnail.equals("null")){
			vo.setbThumbnail("/resources/img/default.png");
		}
		
		service.modify(vo);
		
		if(bPart.equals("portfolio")) {
			return "redirect:/portfolio/list?c=portfolio";
		}
		return "redirect:/show/list";
	}
	
	//글 삭제
	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String postDelete(@RequestParam("n") int bno, Model model) throws Exception{
		System.out.println("글 삭제");
		
		service.delete(bno);
		
		return "redirect:/show/list";
	}
	
	//썸머노트
	@RequestMapping(value="/board/img", produces = "application/json; charset=utf8")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request )  {
		JsonObject jsonObject = new JsonObject();
		
		// 외부경로로 저장을 희망할때.
		//String fileRoot = "C:\\Users\\you\\Desktop\\My_Space\\GitHub\\practice_spring\\practice_spring\\src\\main\\webapp\\resources\\image\\";
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/img/";
		
		String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartFile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/resources/img/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			//jsonObject.addProperty("url", fileRoot+savedFileName); 
			System.out.println(fileRoot+savedFileName);//경로 및 파일명 출력
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
	
}
