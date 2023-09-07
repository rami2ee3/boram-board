package com.boram.common;

public class Critertia {
    private int page;   //현재 페이지 번호
    private int perPageNum; //페이지 당 출력 되는 게시글 갯수

    public Critertia() {
        this.page = 1;
        this.perPageNum = 3;
    }

    public void setPage(int page){
        if(page <= 0){
            this.page = 1;
            return;
        }
        this.page = page;
    }

    public int getPage(){
        return page;
    }

    public void setPerPageNum(int perPageNum){
        if(perPageNum <= 0 || perPageNum > 100){
            this.perPageNum = 10;
            return;
        }
        this.perPageNum = perPageNum;
    }

    public int getPerPageNum() {
        return this.perPageNum;
    }

    public int getPageStart(){
        return (this.page - 1) * perPageNum;
    }
}
