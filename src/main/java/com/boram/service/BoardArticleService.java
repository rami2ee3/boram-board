package com.boram.service;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardArticleService {
    void insertBoardArticle(BoardArticleEntity boardArticleEntity, MultipartHttpServletRequest mpRequest) throws Exception;

    List<BoardArticleEntity> selectBoardArticleList(BoardArticleVo boardArticleVo) throws Exception;

    BoardArticleEntity selectOneBoard(int id) throws Exception;

    int deleteBoard(BoardArticleEntity boardArticleEntity) throws Exception;

    int updateBoard(BoardArticleEntity boardArticleEntity) throws Exception;

    int insertBoardComments(BoardCommentsEntity boardCommentsEntity) throws Exception;

    List<BoardCommentsEntity> selectBoardCommentsList(int boardArticleId) throws Exception;

    BoardCommentsEntity selectComments(int bcId) throws Exception;

    int deleteComment(BoardCommentsEntity boardCommentsEntity) throws Exception;

    int updateComment(BoardCommentsEntity boardCommentsEntity) throws Exception;
}
