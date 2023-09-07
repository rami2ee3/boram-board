package com.boram.controller;

import com.boram.domain.BoardArticleVO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardArticleService boardArticleService;

    @GetMapping("/")
    public String main(Model model) throws Exception {
        List<BoardArticleVO> boardArticleVOList = boardArticleService.selectBoardArticleList();
        model.addAttribute("boardList", boardArticleVOList);
        return "main";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("baId") int baId, Model model) throws Exception {
        BoardArticleVO detail = boardArticleService.selectOneBoard(baId);
        model.addAttribute("detail", detail);
        return "detail";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @PostMapping("/write_proc")
    public String writeProc(BoardArticleVO boardArticleVO) throws Exception {
        System.out.println(boardArticleVO.toString());

        boardArticleService.insertBoardArticle(boardArticleVO);

        return "redirect:/";
    }

    @GetMapping("/modify")
    public String modify() {
        return "modify";
    }

}
