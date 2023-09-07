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

    @DeleteMapping("/delete/{id}")
    public @ResponseBody int deleteBoard(@PathVariable int id) throws Exception{
        return boardArticleService.deleteBoard(id);
    }

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
