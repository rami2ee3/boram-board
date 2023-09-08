package com.boram.service.impl;

import com.boram.domain.BoardArticleVO;
import com.boram.domain.BoardCommentsVO;
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

    @Override
    public int deleteBoard(int id) {
        int result = 1;
        int boardResult = boardArticleDAO.deleteBoard(id);
        if(boardResult == 0){
            result = boardResult;
        }
        return result;
    }

    @Override
    public int modifyBoard(BoardArticleVO vo) throws Exception {
        return boardArticleDAO.modifyBoard(vo);
    }

    public void updateReadCount(int id) throws Exception {
        boardArticleDAO.updateReadCount(id);
    }

    @Override
    public int insertComments(BoardCommentsVO vo) throws Exception {
        return boardArticleDAO.insertComments(vo);
    }

    @Override
    public BoardCommentsVO selectComments(int commentsId) throws Exception {
        return boardArticleDAO.selectComments(commentsId);
    }

    @Override
    public List<BoardCommentsVO> selectCommentsList(int baId) throws Exception {
        return boardArticleDAO.selectCommentsList(baId);
    }


}
