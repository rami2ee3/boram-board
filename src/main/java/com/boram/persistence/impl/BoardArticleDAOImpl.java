package com.boram.persistence.impl;

import com.boram.domain.entity.BoardArticleEntity;
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
    public List<BoardArticleEntity> selectBoardArticleList() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".selectBoardArticleList");
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
}
