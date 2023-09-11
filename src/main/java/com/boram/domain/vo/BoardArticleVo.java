package com.boram.domain.vo;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardArticleVo {

    private int baId;
    private String baTitle;
    private String baContents;
    private Date baInsertDt;
    private int baReadCount;
    private String baPassword;

    private int currentPageNo;
    private String searchType;
    private String searchKeyword;

}