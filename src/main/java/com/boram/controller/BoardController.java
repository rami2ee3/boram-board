package com.boram.controller;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardArticleService boardArticleService;

    // 게시판 리스트 페이지 view
    @GetMapping("/")
    public String main(Model model) throws Exception {
        List<BoardArticleVO> boardArticleVOList = boardArticleService.selectBoardArticleList();
        model.addAttribute("boardList", boardArticleVOList);
        return "main";
    }

//    // 게시판 상세 페이지 view ( RequestParam "baId" 생략 가능 )
//    @GetMapping("/detail")
//    public String detail(@RequestParam("baId") int baId, Model model) throws Exception {
//        BoardArticleVO detail = boardArticleService.selectOneBoard(baId);
//        model.addAttribute("detail", detail);
//        return "detail";
//    }

    // 게시판 상세 페이지 view ( PathVariable "baId" 생략 가능)
    @GetMapping("/detail/{baId}")
    public String detail(@PathVariable("baId") int baId, Model model) throws Exception {
        BoardArticleVO detail = boardArticleService.selectOneBoard(baId);
        model.addAttribute("detail", detail);
        return "detail";
    }

    // 게시판 글쓰기 페이지 view
    @GetMapping("/write")
    public String write() {
        return "write";
    }

    // 게시판 글쓰기 process
    @PostMapping("/write_proc")
    public String writeProc(BoardArticleVO boardArticleVO) throws Exception {
        System.out.println(boardArticleVO.toString());
        boardArticleService.insertBoardArticle(boardArticleVO);
        return "redirect:/";
    }

    // 글 삭제
    // POST로 글 번호, 비밀번호 같이 받아서 입력값 검증해서 삭제 시켜줘야함

    // 글 수정
    @GetMapping("modify/{id}")
    public String updateBoard(@PathVariable int id, Model model) throws Exception{
        BoardArticleVO detail = boardArticleService.selectOneBoard(id);
        model.addAttribute("detail", detail);
        return "modify";
    }

    @PostMapping("modify")
    public @ResponseBody int updateAction(BoardArticleVO vo) throws Exception{
        return boardArticleService.updateBoard(vo);
    }

    @PostMapping("/comments")
    public @ResponseBody BoardCommentsVO insertComments(BoardCommentsVO vo) throws Exception{
        BoardCommentsVO comments = null;
        try {
            int bcId = boardArticleService.insertComments(vo);
            comments = boardArticleService.selectComments(bcId);
            return comments;
        } catch (Exception e){
            e.printStackTrace();
        }
        return  comments;
    }

}
