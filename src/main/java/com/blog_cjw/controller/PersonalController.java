package com.blog_cjw.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.blog_cjw.Board.Page;
import com.blog_cjw.Comment.CommentListVO;
import com.blog_cjw.Comment.CommentVO;
import com.blog_cjw.User.UserVO;
import com.sun.xml.internal.rngom.ast.builder.CommentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.blog_cjw.Board.BoardVO;
import com.blog_cjw.Board.Personal.PersonalService;

@Controller
@RequestMapping("/personal/*")
public class PersonalController {

    @Inject
    PersonalService service;

    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);

    //카테고리별 글 목록
    @GetMapping("/list")
    public void getList(@RequestParam(value = "c", defaultValue = "all") String bPart, Model model) throws Exception {
        System.out.println("get list");

        List<BoardVO> list = service.list(bPart);
        if (bPart.equals("all")) {
            list = service.listall();
        }

        model.addAttribute("list", list);
    }

    //카테고리별 글 목록
    @GetMapping("/listpage")
    public void getListpage(@RequestParam(value = "c", defaultValue = "all") String bPart, Model model,
                            @RequestParam("num") int num, Locale locale) throws Exception {

        Page page = new Page();

        page.setNum(num);
        page.setbPart(bPart);
        page.setCount(service.count(page.getbPart()));

        List<BoardVO> list = service.listpage(page.getbPart(), page.getDisplayPost(), page.getPostNum());

        if (bPart.equals("all")) {
            page.setCount(service.countall());
            list = service.listpageall(page.getDisplayPost(), page.getPostNum());
        }
        model.addAttribute("list", list);

        model.addAttribute("page", page);

        model.addAttribute("select", num);

    }


    //글 조회
    @GetMapping("/view")
    public void getView(@RequestParam("n") int bno, Model model) throws Exception {
        System.out.println("get view");

        BoardVO list = service.view(bno);
        model.addAttribute("list", list);

        /*
        List<CommentListVO> commentlist = service.commentlist(bno);
        model.addAttribute("commentlist", commentlist);
         */
    }

    /* 댓글작성
    @PostMapping("/view")
    public String commentregist(CommentVO commentVO, HttpSession session) throws Exception{
        UserVO user = (UserVO)session.getAttribute("user");
        commentVO.setUserId(user.getUserId());

        service.commentregist(commentVO);

        return "redirect:/personal/view?n=" + commentVO.getBno();
    }
     */

    @ResponseBody
    @GetMapping("/view/commentList")
    public List<CommentListVO> getcommentlist(@RequestParam("n") int bno) throws Exception {
        List<CommentListVO> commentlist = service.commentlist(bno);

        return commentlist;
    }

    @ResponseBody
    @PostMapping("/view/commentregist")
    public void commentregist(CommentVO commentVO, HttpSession session) throws Exception{
        UserVO user = (UserVO)session.getAttribute("user");
        commentVO.setUserId(user.getUserId());

        service.commentregist(commentVO);
    }

}
