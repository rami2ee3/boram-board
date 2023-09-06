package com.boram.controller;

import com.boram.domain.BoardArticleVO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String detail() {
        return "detail";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @GetMapping("/modify")
    public String modify() {
        return "modify";
    }

}
