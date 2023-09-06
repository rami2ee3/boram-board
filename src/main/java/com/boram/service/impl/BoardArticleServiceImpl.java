package com.boram.service.impl;

import com.boram.domain.BoardArticleVO;
import com.boram.persistence.BoardArticleDAO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardArticleServiceImpl implements BoardArticleService {

    @Autowired
    private BoardArticleDAO boardArticleDAO;

    @Override
    public int insertBoardArticle(BoardArticleVO vo) throws Exception {
        return boardArticleDAO.insertBoardArticle(vo);
    }

    @Override
    public List<BoardArticleVO> selectBoardArticleList() throws Exception {
        return boardArticleDAO.selectBoardArticleList();
    }

}
