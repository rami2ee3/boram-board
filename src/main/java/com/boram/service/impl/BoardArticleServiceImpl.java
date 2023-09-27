package com.boram.service.impl;

import com.boram.domain.entity.BoardArticleEntity;
import com.boram.domain.entity.BoardCommentsEntity;
import com.boram.domain.vo.BoardArticleVo;
import com.boram.persistence.BoardArticleDAO;
import com.boram.service.BoardArticleService;
import com.boram.util.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;
import java.util.Map;

@Service
public class BoardArticleServiceImpl implements BoardArticleService {

    private static final Logger logger = LogManager.getLogger(BoardArticleServiceImpl.class);

    @Autowired
    private FileUtils fileUtils;
    @Autowired
    private BoardArticleDAO boardArticleDAO;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void insertBoardArticle(BoardArticleEntity boardArticleEntity, MultipartHttpServletRequest mpRequest ) throws Exception {
//        String password = boardArticleEntity.getBaPassword();
//        String encodePassword =  bCryptPasswordEncoder.encode(password);
//        boardArticleEntity.setBaPassword(encodePassword);
        boardArticleEntity.setBaPassword(bCryptPasswordEncoder.encode(boardArticleEntity.getBaPassword()));

        List<Map<String, Object>> list = fileUtils.parseInsertFileInfo(boardArticleEntity, mpRequest);
        int size = list.size();
        for(int i = 0; i < size; i++){
            boardArticleDAO.insertFile(list.get(i));
        }

        /*
        <!-- 암호화 -->
        memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));

        <!-- 비교 -->
        boolean passwordMatch = passwordEncoder.matches(memberDTO.getPassword(), userDTO.getPassword());
         */

        boardArticleDAO.insertBoardArticle(boardArticleEntity);
    }

    @Override
    public List<BoardArticleEntity> selectBoardArticleList(BoardArticleVo boardArticleVo) throws Exception {

        int selectBoardArticleTotalCount = boardArticleDAO.selectBoardArticleTotalCount(boardArticleVo);
        logger.info("selectBoardArticleTotalCount: " + selectBoardArticleTotalCount);

        int countPerPage = 5;
        int currentPageNo = (boardArticleVo.getCurrentPageNo() == 0) ? 1 : boardArticleVo.getCurrentPageNo();
        int offset = ((currentPageNo) - 1) * countPerPage;
        boardArticleVo.setOffset(offset);
        boardArticleVo.setLimit(countPerPage);

//        int currentBlock = ((currentPageNo % countPerPage) == 0) ? currentPageNo / countPerPage : currentPageNo / countPerPage + 1;
//        int startPage = (currentBlock - 1) * countPerPage + 1;
        int startPage = 1;
        int endPage = (selectBoardArticleTotalCount / countPerPage) + 1;
//        int endPage = startPage + countPerPage - 1;

//        if (endPage > selectBoardArticleTotalCount){
//            endPage = selectBoardArticleTotalCount;
//        }

        boardArticleVo.setCurrentPageNo(currentPageNo);
        boardArticleVo.setTotalCount(selectBoardArticleTotalCount);
        boardArticleVo.setStartPage(startPage);
        boardArticleVo.setEndPage(endPage);
        
        return boardArticleDAO.selectBoardArticleList(boardArticleVo);
    }

    @Override
    public BoardArticleEntity selectOneBoard(int id) throws Exception {
        this.updateReadCount(id);
        return boardArticleDAO.selectOneBoard(id);
    }

    public void updateReadCount(int id) throws Exception {
        boardArticleDAO.updateReadCount(id);
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

    @Override
    public int insertBoardComments(BoardCommentsEntity boardCommentsEntity) throws Exception {
        boardCommentsEntity.setBcPassword(bCryptPasswordEncoder.encode(boardCommentsEntity.getBcPassword()));
        return boardArticleDAO.insertBoardComments(boardCommentsEntity);
    }

    @Override
    public List<BoardCommentsEntity> selectBoardCommentsList(int boardArticleId) throws Exception {
        return boardArticleDAO.selectBoardCommentsList(boardArticleId);
    }

    @Override
    public BoardCommentsEntity selectComments(int bcId) throws Exception {
        return boardArticleDAO.selectComments(bcId);
    }

    @Override
    public int deleteComment(BoardCommentsEntity boardCommentsEntity) throws Exception {
        BoardCommentsEntity orginalBoardCommentsEntity = boardArticleDAO.selectComments(boardCommentsEntity.getBcId());
        boolean passwordMatch = bCryptPasswordEncoder.matches(
                boardCommentsEntity.getBcPassword(),
                orginalBoardCommentsEntity.getBcPassword());

        if(passwordMatch){
            return  boardArticleDAO.deleteComment(boardCommentsEntity);
        } else {
            return 0;
        }
    }

    @Override
    public int updateComment(BoardCommentsEntity boardCommentsEntity) throws Exception {
        BoardCommentsEntity originalBoardCommentsEntity = boardArticleDAO.selectComments(boardCommentsEntity.getBcId());
        boolean passwordMatch = bCryptPasswordEncoder.matches(
                boardCommentsEntity.getBcPassword(),
                originalBoardCommentsEntity.getBcPassword());

        if (passwordMatch) {
            return boardArticleDAO.updateComment(boardCommentsEntity);
        } else {
            return 0;
        }
    }

}
