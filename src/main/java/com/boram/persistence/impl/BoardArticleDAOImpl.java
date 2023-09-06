package com.boram.persistence.impl;

import com.boram.domain.BoardArticleVO;
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

}
