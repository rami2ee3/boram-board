package com.boram.util;

import com.boram.domain.entity.BoardArticleEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.util.*;

@Component("fileUtils")
public class FileUtils {
    private static final String filePath = "C:\\USER\\Developer\\projects\\boram\\BoramBoard\\file\\"; // 파일이 저장될 위치

    public List<Map<String, Object>> parseInsertFileInfo(BoardArticleEntity boardArticleEntity,
                                                         MultipartHttpServletRequest mpRequest) throws Exception{

        Iterator<String> iterator = mpRequest.getFileNames();

        MultipartFile multipartFile = null;
        String originalFileName = null;
        String originalFileExtension = null;
        String storedFileName = null;

        List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
        Map<String, Object> listMap = null;

        int bno = boardArticleEntity.getBaId();

        File file = new File(filePath);
        if(file.exists() == false) {
            file.mkdirs();
        }

        while(iterator.hasNext()) {
            multipartFile = mpRequest.getFile(iterator.next());
            if(multipartFile.isEmpty() == false) {
                originalFileName = multipartFile.getOriginalFilename();
                originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
                storedFileName = getRandomString() + originalFileExtension;

                file = new File(filePath + storedFileName);
                multipartFile.transferTo(file);
                listMap = new HashMap<String, Object>();
                listMap.put("bfId", bno);
                listMap.put("bfOrginName", originalFileName);
                listMap.put("bfStoredName", storedFileName);
                listMap.put("bfSize", multipartFile.getSize());
                list.add(listMap);
            }
        }
        return list;
    }

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

