package com.boram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;
import java.sql.Connection;

@Controller
public class BoardController {

//    @Autowired
//    private DataSource ds;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/detail")
    public String detail() {
        return "detail";
    }

    @GetMapping("/write")
    public String write() {
        return "write";
    }

    @GetMapping("/modify")
    public String modify() {
        return "modify";
    }

//    @GetMapping("/dbtest")
//    public String dbtest() {
//
//
//        try(Connection con = ds.getConnection()){
//            System.out.println(con);
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        return "main";
//    }

}
