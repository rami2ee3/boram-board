package com.boram.persistence;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;

import java.util.List;

public interface BoardArticleDAO {
    int insertBoardArticle(BoardArticleVO vo) throws Exception;

    List<BoardArticleVO> selectBoardArticleList() throws Exception;

    BoardArticleVO selectOneBoard(int id) throws Exception;

    void updateReadCount(int id) throws Exception;

    int deleteBoard(int id);

    int modifyBoard(BoardArticleVO vo) throws Exception;

    //댓글
    int insertComments(BoardCommentsVO vo) throws Exception;

    BoardCommentsVO selectComments(int commentsId) throws Exception;

    List<BoardCommentsVO> selectCommentsList(int baId) throws Exception;


}
