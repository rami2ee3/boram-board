package com.boram.domain.vo;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardCommentsVO {
    private int bcId;
    private int baId;
    private String bcContents;
    private String bcPassword;
    private String bcInsertDt;
    private String bcModifyDt;
}
