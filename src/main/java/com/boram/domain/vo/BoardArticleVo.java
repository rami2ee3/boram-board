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

    private String searchType;
    private String searchKeyword;

    private int currentPageNo;
    private int limit;
    private int offset;
    private int totalCount;
    private int startPage;
    private int endPage;


}
