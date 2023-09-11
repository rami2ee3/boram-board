package com.boram.service.impl;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.persistence.BoardArticleDAO;
import com.boram.service.BoardArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardArticleServiceImpl implements BoardArticleService {

    @Autowired
    private BoardArticleDAO boardArticleDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public int insertBoardArticle(BoardArticleEntity boardArticleEntity) throws Exception {
//        String password = boardArticleEntity.getBaPassword();
//        String encodePassword =  bCryptPasswordEncoder.encode(password);
        boardArticleEntity.setBaPassword(bCryptPasswordEncoder.encode(boardArticleEntity.getBaPassword()));

        /*
        <!-- 암호화 -->
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));

        <!-- 비교 -->
        boolean passwordMatch = passwordEncoder.matches(memberDTO.getPassword(), userDTO.getPassword());
         */

        return boardArticleDAO.insertBoardArticle(boardArticleEntity);
    }

    @Override
    public List<BoardArticleEntity> selectBoardArticleList() throws Exception {
        return boardArticleDAO.selectBoardArticleList();
    }

    @Override
    public BoardArticleEntity selectOneBoard(int id) throws Exception {
        this.updateReadCount(id);
        return boardArticleDAO.selectOneBoard(id);
    }

    @Override
    public int deleteBoard(BoardArticleEntity boardArticleEntity) throws Exception {
        BoardArticleEntity originalBoardArticleEntity = boardArticleDAO.selectOneBoard(boardArticleEntity.getBaId());
        boolean passwordMatch = bCryptPasswordEncoder.matches(
                boardArticleEntity.getBaPassword(),
                originalBoardArticleEntity.getBaPassword());

        if (passwordMatch) {
            return boardArticleDAO.deleteBoard(boardArticleEntity.getBaId());
        } else {
            return 0;
        }

    }

    @Override
    public int updateBoard(BoardArticleEntity boardArticleEntity) throws Exception {
        BoardArticleEntity originalBoardArticleEntity = boardArticleDAO.selectOneBoard(boardArticleEntity.getBaId());

        boolean passwordMatch = bCryptPasswordEncoder.matches(
                boardArticleEntity.getBaPassword(),
                originalBoardArticleEntity.getBaPassword());

        if (passwordMatch) {
            return boardArticleDAO.updateBoard(boardArticleEntity);

        } else {
            return 0;
        }
    }

    public void updateReadCount(int id) throws Exception {
        boardArticleDAO.updateReadCount(id);
    }
}
