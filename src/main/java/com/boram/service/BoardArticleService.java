package com.boram.service;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.vo.BoardArticleVo;

import java.util.List;

public interface BoardArticleService {
    void insertBoardArticle(BoardArticleEntity boardArticleEntity) throws Exception;

    List<BoardArticleEntity> selectBoardArticleList(BoardArticleVo boardArticleVo) throws Exception;

    BoardArticleEntity selectOneBoard(int id) throws Exception;

    int deleteBoard(BoardArticleEntity boardArticleEntity) throws Exception;

    int updateBoard(BoardArticleEntity boardArticleEntity) throws Exception;
}
