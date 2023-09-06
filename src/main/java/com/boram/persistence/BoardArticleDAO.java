package com.boram.persistence;

import com.boram.domain.BoardArticleVO;

import java.util.List;

public interface BoardArticleDAO {
    int insertBoardArticle(BoardArticleVO vo) throws Exception;

    List<BoardArticleVO> selectBoardArticleList() throws Exception;

}
