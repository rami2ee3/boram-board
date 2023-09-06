package com.boram.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentsVO {
    private int bcId;
    private int baId;
    private String bcContents;
    private String bcPassword;
    private Date bcInsertDt;
}
