package com.boram.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentsEntity {
    private int bcId;
    private int baId;
    private String bcContents;
    private String bcPassword;
    private String bcInsertDt;
    private String bcModifyDt;
}
