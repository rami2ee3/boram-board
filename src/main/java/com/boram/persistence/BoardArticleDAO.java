package com.boram.persistence;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;

import java.util.List;

public interface BoardArticleDAO {
    int insertBoardArticle(BoardArticleEntity boardArticleEntity) throws Exception;

    List<BoardArticleEntity> selectBoardArticleList(BoardArticleVo boardArticleVo) throws Exception;

    int selectBoardArticleTotalCount(BoardArticleVo boardArticleVo) throws Exception;

    BoardArticleEntity selectOneBoard(int id) throws Exception;

    void updateReadCount(int id) throws Exception;

    int deleteBoard(int id) throws Exception;

    int updateBoard(BoardArticleEntity boardArticleEntity) throws Exception;

    int insertBoardComments(BoardCommentsEntity boardCommentsEntity) throws Exception;

    List<BoardCommentsEntity> selectBoardCommentsList(int boardArticleId) throws Exception;
}
