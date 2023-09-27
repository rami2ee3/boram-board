package com.boram.controller;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
import com.boram.service.BoardArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        logger.info("boardArticleVo" + boardArticleVo);
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
    public String writeProc(BoardArticleEntity boardArticleEntity, MultipartHttpServletRequest mpRequest) throws Exception {
        logger.info(boardArticleEntity.toString());
        boardArticleService.insertBoardArticle(boardArticleEntity, mpRequest);
        return "redirect:/";
    }

    // 글 수정 페이지 view
    @PostMapping("modify")
    public String modify(BoardArticleVo boardArticleVo, Model model) throws Exception {
        BoardArticleEntity boardArticleEntity = boardArticleService.selectOneBoard(boardArticleVo.getBaId());
        model.addAttribute("boardArticleEntity", boardArticleEntity);
        model.addAttribute("boardArticleVo", boardArticleVo);
        return "modify";
    }

    // 글 수정 페이지 process
    @PostMapping("modify_proc")
    public String modifyProc(BoardArticleVo vo, BoardArticleEntity entity, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        request.setAttribute("boardArticleVo", vo);
        int result = boardArticleService.updateBoard(entity);
        logger.info("Modify Result: " + result);
        redirectAttributes.addFlashAttribute("procName", "modifyProc");
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }

    // 글 삭제 process
    @PostMapping("delete_proc")
    public String deleteProc(BoardArticleVo vo, BoardArticleEntity entity, RedirectAttributes redirectAttributes, HttpServletRequest request) throws Exception {
        request.setAttribute("boardArticleVo", vo);
        int result = boardArticleService.deleteBoard(entity);
        logger.info("Delete Result: " + result);
        redirectAttributes.addFlashAttribute("procName", "deleteProc");
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }

    // 댓글 작성 axios
    @PostMapping("comment_proc")
    @ResponseBody
    public Map<String, Object> commentProc(BoardCommentsEntity entity) throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        try {
            int insertCount = boardArticleService.insertBoardComments(entity);
            logger.info("commentId: " + insertCount);
            logger.info(entity.toString());
            BoardCommentsEntity newCommentEntity = boardArticleService.selectComments(entity.getBcId());

            if(insertCount == 1) {
                returnMap.put("result", "Y");
                returnMap.put("data", newCommentEntity);
            } else {
                returnMap.put("result", "N");
            }
        } catch (Exception e) {
            returnMap.put("result", "E");
            logger.debug(e.getMessage());
        }

        return returnMap;
    }

    // 댓글 삭제
    @DeleteMapping
    public @ResponseBody int deleteComment(int bcId) throws Exception {
        return boardArticleService.deleteComment(bcId);
    }

    // 댓글 수정

}