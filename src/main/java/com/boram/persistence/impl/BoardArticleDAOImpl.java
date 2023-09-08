package com.boram.persistence.impl;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;
import com.boram.persistence.BoardArticleDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardArticleDAOImpl implements BoardArticleDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "com.boram.mapper.boardArticleMapper";

    @Override
    public int insertBoardArticle(BoardArticleVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertBoardArticle", vo);
    }

    @Override
    public List<BoardArticleVO> selectBoardArticleList() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".selectBoardArticleList");
    }

    @Override
    public BoardArticleVO selectOneBoard(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectOneBoard", id);
    }

    @Override
    public void updateReadCount(int id) throws Exception {
        sqlSession.update(NAMESPACE + ".updateReadCount", id);
    }

    @Override
    public int deleteBoard(int id) {
        return sqlSession.delete(NAMESPACE + ".deleteBoard", id);
    }

    @Override
    public int modifyBoard(BoardArticleVO vo) throws Exception {
        return sqlSession.update(NAMESPACE + ".modifyBoard", vo);
    }

    @Override
    public int insertComments(BoardCommentsVO vo) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertComments");
    }

    @Override
    public BoardCommentsVO selectComments(int commentsId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectComments", commentsId);
    }

    @Override
    public List<BoardCommentsVO> selectCommentsList(int baId) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".selectCommentsList", baId);
    }



}
