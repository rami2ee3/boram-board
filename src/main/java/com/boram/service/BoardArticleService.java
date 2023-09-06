package com.boram.service;

import com.boram.domain.BoardArticleVO;

import java.util.List;

public interface BoardArticleService {
    int insertBoardArticle(BoardArticleVO vo) throws Exception;

    List<BoardArticleVO> selectBoardArticleList() throws Exception;
}
