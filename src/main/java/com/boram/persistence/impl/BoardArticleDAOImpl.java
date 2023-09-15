package com.boram.persistence.impl;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
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
    public int insertBoardArticle(BoardArticleEntity boardArticleEntity) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertBoardArticle", boardArticleEntity);
    }

    @Override
    public List<BoardArticleEntity> selectBoardArticleList(BoardArticleVo boardArticleVo) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".selectBoardArticleList", boardArticleVo);
    }

    @Override
    public int selectBoardArticleTotalCount (BoardArticleVo boardArticleVo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectBoardArticleTotalCount", boardArticleVo);
    }

    @Override
    public BoardArticleEntity selectOneBoard(int id) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".selectOneBoard", id);
    }

    @Override
    public void updateReadCount(int id) throws Exception {
        sqlSession.update(NAMESPACE + ".updateReadCount", id);
    }

    @Override
    public int deleteBoard(int id) throws Exception {
        return sqlSession.delete(NAMESPACE + ".deleteBoard", id);
    }

    @Override
    public int updateBoard(BoardArticleEntity vo) throws Exception {
        return sqlSession.update(NAMESPACE + ".updateBoard", vo);
    }

    @Override
    public int insertBoardComments(BoardCommentsEntity boardCommentsEntity) throws Exception {
        return sqlSession.insert(NAMESPACE + ".insertBoardComments",boardCommentsEntity);
    }

    @Override
    public List<BoardCommentsEntity> selectBoardCommentsList(int boardArticleId) throws Exception {
        return sqlSession.selectList(NAMESPACE + ".selectBoardCommentsList", boardArticleId);
    }
}
