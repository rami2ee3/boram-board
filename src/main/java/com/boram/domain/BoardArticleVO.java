package com.boram.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardArticleVO {
    private int baId;
    private String baTitle;
    private String baContents;
    private Date baInsertDt;
    private int baReadCount;
    private String baPassword;
}
