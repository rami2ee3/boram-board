package com.boram.service;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;

import java.util.List;

public interface BoardArticleService {
    int insertBoardArticle(BoardArticleVO vo) throws Exception;

    List<BoardArticleVO> selectBoardArticleList() throws Exception;

    BoardArticleVO selectOneBoard(int id) throws Exception;

    int deleteBoard(int id);

    int updateBoard(BoardArticleVO vo) throws Exception;

    int insertComments(BoardCommentsVO vo) throws Exception;

    BoardCommentsVO selectComments(int commentsId) throws Exception;
}
