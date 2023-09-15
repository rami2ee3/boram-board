package com.boram.controller;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
import com.boram.domain.vo.BoardCommentsVO;
import com.boram.service.BoardArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BoardController {

    private static final Logger logger = LogManager.getLogger(BoardController.class);

    @Autowired
    private BoardArticleService boardArticleService;

    // 게시판 리스트 페이지 view
    @GetMapping("/")
    public String list(BoardArticleVo boardArticleVo, Model model) throws Exception {
        List<BoardArticleEntity> boardArticleEntityList = boardArticleService.selectBoardArticleList(boardArticleVo);
        model.addAttribute("boardList", boardArticleEntityList);
        model.addAttribute("boardArticleVo", boardArticleVo);

        logger.info("조회 완료!!!");
        logger.info("boardArticleEntityList" + boardArticleEntityList);
        logger.info("boardArticleVo"+ boardArticleVo);
        return "list";
    }

    // 게시판 상세 페이지 view
    @GetMapping("detail")
    public String detail(BoardArticleVo boardArticleVo, Model model) throws Exception {
        BoardArticleEntity boardArticleEntity = boardArticleService.selectOneBoard(boardArticleVo.getBaId());
        model.addAttribute("boardArticleEntity", boardArticleEntity);

        List<BoardCommentsEntity> commentsList = boardArticleService.selectBoardCommentsList(boardArticleVo.getBaId());
        model.addAttribute("commentsList", commentsList);

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
        logger.info(boardArticleEntity.toString());
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
        logger.info("Modify Result: " + result);
        redirectAttributes.addFlashAttribute("procName", "modifyProc");
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }

    // 글 삭제 process
    @PostMapping("delete_proc")
    public String deleteProc(BoardArticleVo vo, BoardArticleEntity entity, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception{
        request.setAttribute("boardArticleVo", vo);
        int result = boardArticleService.deleteBoard(entity);
        logger.info("Delete Result: " + result);
        redirectAttributes.addFlashAttribute("procName", "deleteProc");
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }

}