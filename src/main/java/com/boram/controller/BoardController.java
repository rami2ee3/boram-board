package com.boram.controller;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardArticleService boardArticleService;

    // 게시판 리스트 페이지 view
    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) throws Exception {
        List<BoardArticleVO> boardArticleVOList = boardArticleService.selectBoardArticleList();
        model.addAttribute("boardList", boardArticleVOList);
        return "main";
    }

//    // 방법1. 게시판 상세 페이지 view ( RequestParam "baId" 생략 가능 )
//    @GetMapping("/detail")
//    public String detail(@RequestParam("baId") int baId, Model model) throws Exception {
//        BoardArticleVO detail = boardArticleService.selectOneBoard(baId);
//        model.addAttribute("detail", detail);
//        return "detail";
//    }

    // 방법2. 게시판 상세 페이지 view ( PathVariable ("baId") int baId랑 같아서 생략 가능)
    @GetMapping("detail/{baId}")
    public String detail(@PathVariable("baId") int baId, Model model) throws Exception {
        try {
            BoardArticleVO detail = boardArticleService.selectOneBoard(baId);
            model.addAttribute("detail", detail);
            System.out.println("---------------글 상세 조회 시작----------------");
            System.out.println(detail);
            System.out.println("---------------글 상세 조회 종료----------------");

            List<BoardCommentsVO> commentsList = boardArticleService.selectCommentsList(baId);
            System.out.println("---------------댓글 상세 조회 시작----------------");
            System.out.println(commentsList);
            System.out.println("---------------댓글 상세 조회 종료----------------");
            model.addAttribute("commentsList", commentsList);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "detail";
    }

    // 게시판 글쓰기 페이지 view
    @GetMapping("write")
    public String write() {
        return "write";
    }

    // 게시판 글쓰기 process
    @PostMapping("write_proc")
    public String writeProc(BoardArticleVO boardArticleVO) throws Exception {
        System.out.println(boardArticleVO.toString());
        boardArticleService.insertBoardArticle(boardArticleVO);
        return "redirect:/";
    }

    // 글 수정
    @GetMapping("modify/{id}")
    public String modifyBoard(@PathVariable int id, Model model) throws Exception{
        BoardArticleVO detail = boardArticleService.selectOneBoard(id);
        model.addAttribute("detail", detail);
        return "modify";
    }

    @PostMapping("modify")
    public @ResponseBody int modifyAction(BoardArticleVO vo) throws Exception{
        return boardArticleService.modifyBoard(vo);
    }

    // 글 삭제
    @PostMapping("delete/{id}")
    public @ResponseBody int deleteBoard(@PathVariable int id, BoardCommentsVO password) throws Exception {

        return 0;
    }

    // 댓글
    @PostMapping("comments")
    public @ResponseBody BoardCommentsVO insertComments(BoardCommentsVO vo) throws Exception{
        BoardCommentsVO comments = null;
        try {
            boardArticleService.insertComments(vo);
        } catch (Exception e){
            e.printStackTrace();
        }
        return comments;
    }

}