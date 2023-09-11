package com.boram.service;

import com.boram.domain.entity.BoardArticleEntity;

import java.util.List;

public interface BoardArticleService {
    int insertBoardArticle(BoardArticleEntity boardArticleEntity) throws Exception;

    List<BoardArticleEntity> selectBoardArticleList() throws Exception;

    BoardArticleEntity selectOneBoard(int id) throws Exception;

    int deleteBoard(int id) throws Exception;

    int updateBoard(BoardArticleEntity boardArticleEntity) throws Exception;

}
