package com.example.springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface TblSaleOrderService {

    /**
     * 读取excel中的数据,生成list
     */
    String readExcelFile( MultipartFile file);
}
