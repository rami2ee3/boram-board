package com.boram.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardArticleEntity {
    private int baId;
    private String baTitle;
    private String baContents;
    private Date baInsertDt;
    private int baReadCount;
    private String baPassword;
}
