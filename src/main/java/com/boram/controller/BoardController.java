package com.boram.controller;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardArticleService boardArticleService;

    // 게시판 리스트 페이지 view
    @GetMapping("/")
    public String main(HttpServletRequest request, Model model) throws Exception {
        List<BoardArticleEntity> boardArticleEntityList = boardArticleService.selectBoardArticleList();
        model.addAttribute("boardList", boardArticleEntityList);
        return "main";
    }

    // 게시판 상세 페이지 view
    @GetMapping("detail")
    public String detail(BoardArticleVo boardArticleVo, Model model) throws Exception {
        BoardArticleEntity boardArticleEntity = boardArticleService.selectOneBoard(boardArticleVo.getBaId());
        model.addAttribute("boardArticleEntity", boardArticleEntity);
        return "detail";
    }

    // 게시판 글쓰기 페이지 view
    @GetMapping("write")
    public String write() {
        return "write";
    }

    // 게시판 글쓰기 process
    @PostMapping("write_proc")
    public String writeProc(BoardArticleEntity boardArticleEntity) throws Exception {
        System.out.println(boardArticleEntity.toString());
        boardArticleService.insertBoardArticle(boardArticleEntity);
        return "redirect:/";
    }

    // 글 수정 페이지 view
    @PostMapping("modify")
    public String modify(BoardArticleVo boardArticleVo, Model model) throws Exception{
        BoardArticleEntity boardArticleEntity = boardArticleService.selectOneBoard(boardArticleVo.getBaId());
        model.addAttribute("boardArticleEntity", boardArticleEntity);
        model.addAttribute("boardArticleVo", boardArticleVo);
        return "modify";
    }

    // 글 수정 페이지 process
    @PostMapping("modify_proc")
    public String modifyProc(BoardArticleVo vo, BoardArticleEntity entity, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception{
        request.setAttribute("boardArticleVo", vo);
        int result = boardArticleService.updateBoard(entity);
        System.out.println("Modify Result: " + result);
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }

    // 글 삭제


    // 댓글

}