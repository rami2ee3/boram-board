package com.boram.service.impl;

import com.boram.domain.BoardArticleVO;
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
    public int insertBoardArticle(BoardArticleVO vo) throws Exception {
//        String password = vo.getBaPassword();
//        String encodePassword =  bCryptPasswordEncoder.encode(password);
        vo.setBaPassword(bCryptPasswordEncoder.encode(vo.getBaPassword()));

        /*

        <!-- 암호화 -->
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));

        <!-- 비교 -->
        boolean passwordMatch = passwordEncoder.matches(memberDTO.getPassword(), userDTO.getPassword());

         */

        return boardArticleDAO.insertBoardArticle(vo);
    }

    @Override
    public List<BoardArticleVO> selectBoardArticleList() throws Exception {
        return boardArticleDAO.selectBoardArticleList();
    }

    @Override
    public BoardArticleVO selectOneBoard(int id) throws Exception {
        this.updateReadCount(id);
        return boardArticleDAO.selectOneBoard(id);
    }

    public void updateReadCount(int id) throws Exception {
        boardArticleDAO.updateReadCount(id);
    }

}
