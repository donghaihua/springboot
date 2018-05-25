package com.example.springboot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.config.OnefieldRequestVo;
import com.example.springboot.model.Dhh;
import com.example.springboot.model.RequestMessage;
import com.example.springboot.model.ResponseMessage;
import com.example.springboot.model.TbUser;
import com.example.springboot.service.DhhService;
import com.example.springboot.service.TblSaleOrderService;
import com.example.springboot.service.findByIdService;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class testController {
    private Logger logger= LoggerFactory.getLogger(testController.class);

    @Resource
    private findByIdService service;
    @Resource
    private DhhService dhhService;
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TblSaleOrderService saleOrderService;

    @ApiOperation(value="mysql的测试")
    @PostMapping("/testMysql")
    public TbUser find(@RequestBody(required = false)OnefieldRequestVo requestVo){
        logger.info("首先执行了这个");

        return service.findByid(requestVo.getId());
    }

    @ApiOperation(value="mongodb的findall测试")
    @PostMapping("/testMongodbfindall")
    @ResponseBody
    public List<Dhh> getAll(@RequestParam(required = false) String param){
        return dhhService.findAll();
    }

    @ApiOperation(value="mongodb的find测试")
    @PostMapping("/testMongodbfind")
    @ResponseBody
    public List<Dhh> find(@RequestParam(required = false) String param){
        return dhhService.find(param);
    }

    @ApiOperation(value="mongodb的删除测试")
    @PostMapping("/testMongodbdele")
    @ResponseBody
    public void delete(@RequestParam(required = false) String param){
        dhhService.delete(param);
    }

    @ApiOperation(value="mongodb的findandmodify测试")
    @PostMapping("/testMongodbmodify")
    @ResponseBody
    public Dhh findandmodify(@RequestParam(required = false) String param){
        return dhhService.findAndModify(param);
    }

    @ApiOperation(value="redis的插入测试")
    @PostMapping("/testRedis")
    public void setRedis(@RequestParam(required = false) String param,@RequestParam(required = false) String value){
        redisTemplate.opsForValue().set(param,value);
    }


    @ApiOperation(value="redis的查询测试")
    @PostMapping("/testRedisFind")
    public String getRedis(@RequestParam(required = false) String param){
        String value=redisTemplate.opsForValue().get(param).toString();
        return value;
    }


    @ApiOperation(value="测试MD5加密算法")
    @PostMapping("/add")
    public String addUser(@RequestParam(required = false) String param){
        JSONObject object= JSON.parseObject(param);
        int count=dhhService.insert(object);
        if(count>0){
            return "插入成功";
        }else {
            return "插入失败";
        }
    }




    @RequestMapping("/index")
    public String testindex(){
        return "index";
    }


    /**
     * 将页面上的数据导出到excel中   ----Hayward
     * @param request
     * @return
     */
    @RequestMapping("/exportExcel")
    public void exportExcel( HttpServletRequest request, HttpServletResponse response){
        try {

            //先根据传过来的参数查询出符合条件的记录
            List<TbUser> list=service.findAll();
            //创建一个webbook也就是对应的一个Excel文件
            HSSFWorkbook workbook=new HSSFWorkbook();
            HSSFFont font=workbook.createFont();
            font.setColor(HSSFFont.COLOR_RED);
            //在webbook中添加一个sheet也就是在excel中的sheet
            HSSFSheet sheet=workbook.createSheet("已付款订单");
            //在sheet中添加表头的第0行
            HSSFRow row=sheet.createRow( 0);
            //创建单元格并设置表头且居中
            HSSFCellStyle style=workbook.createCellStyle();
            style.setFont(font);
            style.setAlignment(HorizontalAlignment.CENTER);
            HSSFCell cell = row.createCell(0);
            cell.setCellValue("用户名");
            cell.setCellStyle(style);

            cell = row.createCell( 1);
            cell.setCellValue("密码");
            cell.setCellStyle(style);

            cell = row.createCell( 2);
            cell.setCellValue("电话");
            cell.setCellStyle(style);

            cell = row.createCell( 3);
            cell.setCellValue("邮箱");
            cell.setCellStyle(style);

            cell = row.createCell( 4);
            cell.setCellValue("创建时间");
            cell.setCellStyle(style);

            cell = row.createCell( 5);
            cell.setCellValue("更新时间");
            cell.setCellStyle(style);


            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //将数据写入到excel中
            for(int i=0;i<list.size();i++){
                //第二行开始写数据
                row=sheet.createRow(i+1);
                TbUser tbUser=list.get(i);
                //订单号
                row.createCell( 0).setCellValue(tbUser.getUsername());
                //下单时间
                row.createCell( 1).setCellValue(tbUser.getPassword());
                //下单人
                row.createCell( 2).setCellValue(tbUser.getPhone());
                //商品名称
                row.createCell( 3).setCellValue(tbUser.getEmail());
                //规格
                row.createCell( 4).setCellValue(simpleDateFormat.format(tbUser.getCreated()));
                //数量
                row.createCell( 5).setCellValue(simpleDateFormat.format(tbUser.getUpdated()));

            }

            OutputStream output = response.getOutputStream();
            //response.setCharacterEncoding("ISO8859-1");
            //response.addHeader("Content-Disposition", "attachment;filename=已付款订单报表.xls");


            // todo 兼容浏览器的版本，待和中台联调测试，默认文件名
           String browser="";
            String fileName="已付款订单报表.xls";
            browser = request.getHeader("User-Agent");
            if (-1 < browser.indexOf("MSIE 6.0") || -1 < browser.indexOf("MSIE 7.0")) {
                // IE6, IE7 浏览器
                response.addHeader("content-disposition", "attachment;filename="
                        + new String(fileName.getBytes(), "ISO8859-1"));
            } else if (-1 < browser.indexOf("MSIE 8.0")) {
                // IE8
                response.addHeader("content-disposition", "attachment;filename="
                        + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("MSIE 9.0")) {
                // IE9
                response.addHeader("content-disposition", "attachment;filename="
                        + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Chrome")) {
                // 谷歌
                response.addHeader("content-disposition",
                        "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
            } else if (-1 < browser.indexOf("Safari")) {
                // 苹果
                response.addHeader("content-disposition", "attachment;filename="
                        + new String(fileName.getBytes(), "ISO8859-1"));
            } else {
                // 火狐或者其他的浏览器
                response.addHeader("content-disposition",
                        "attachment;filename*=UTF-8''" + URLEncoder.encode(fileName, "UTF-8"));
            }

            response.setContentType("application/vnd.ms-excel");
            workbook.write(output);
            output.close();


        }catch (Exception e){
            e.printStackTrace();
        }

    }


    /**
     * 上传excel文件，读取数据
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value="/upload",method = {RequestMethod.POST})
    public String  upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        logger.info("文件名为{}",file.getOriginalFilename());
        String result = saleOrderService.readExcelFile(file);
        return result;
    }
}
