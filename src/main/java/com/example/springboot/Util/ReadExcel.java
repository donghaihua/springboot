package com.example.springboot.Util;

import com.example.springboot.model.ExcelModel;
import com.example.springboot.model.TblSaleOrder;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadExcel {
    private Logger logger= LoggerFactory.getLogger(ReadExcel.class);
    //总行数
    private int totalRows = 0;
    //总条数
    private int totalCells = 0;
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;}
    //获取总列数
    public int getTotalCells() {  return totalCells;}
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }

    /**
     * 读EXCEL文件，获取信息集合
     * @param
     * @return
     */
    public List<ExcelModel> getExcelInfo(MultipartFile mFile) {
        String fileName = mFile.getOriginalFilename();//获取文件名
        try {
            if (!validateExcel(fileName)) {// 验证文件名是否合格
                return null;
            }
            boolean isExcel2003 = true;// 根据文件名判断文件是2003版本还是2007版本
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            List<ExcelModel> userList = createExcel(mFile.getInputStream(), isExcel2003);
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据excel里面的内容读取客户信息
     * @param is 输入流
     * @param isExcel2003 excel是2003还是2007版本
     * @return
     * @throws IOException
     */
    public List<ExcelModel> createExcel(InputStream is, boolean isExcel2003) {
        try{
            Workbook wb = null;
            if (isExcel2003) {// 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(is);
            } else {// 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(is);
            }
            List<ExcelModel> userList = readExcelValue(wb);// 读取Excel里面客户的信息
            return userList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 读取Excel里面客户的信息
     * @param wb
     * @return
     */
    private List<ExcelModel> readExcelValue(Workbook wb) {
        // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > 1 && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        List<ExcelModel> excelList = new ArrayList<ExcelModel>();
        // 循环Excel行数
        for (int r = 3; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            ExcelModel excelModel = new ExcelModel();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if (c == 2) {
                        //如果是纯数字,比如你写的是25,cell.getNumericCellValue()获得是25.0,通过截取字符串去掉.0获得25
                    /*    if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                            String name = String.valueOf(cell.getNumericCellValue());
                            user.setName(name.substring(0, name.length()-2>0?name.length()-2:1));//名称
                        }else{
                            user.setName(cell.getStringCellValue());//名称
                        }*/
                        excelModel.setName(cell.getStringCellValue());
                    } else if (c == 10) {

                        excelModel.setItemName(cell.getStringCellValue());
                    } else if(c == 11){
                        excelModel.setSpecName(cell.getStringCellValue());
                    } else if(c == 12){
                            String residualCount = String.valueOf(cell.getNumericCellValue());
                            excelModel.setResidualCount(Integer.valueOf(residualCount.substring(0, residualCount.length()-2>0?residualCount.length()-2:1)));//名称

                    }else if(c == 13){
                        excelModel.setUnitPrice(cell.getNumericCellValue());
                    } else if (c == 15){

                        excelModel.setTotalPrice(cell.getNumericCellValue());
                    }else if(c == 17){
                        excelModel.setPrice(cell.getNumericCellValue());
                    }else if(c == 45){
                        excelModel.setRemark(cell.getStringCellValue());
                    }
                }
            }
            // 添加到list
            excelList.add(excelModel);
            logger.info("这个集合大小为{}",excelList.size());
        }
        return excelList;
    }

    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    // 是否是2003的excel，返回true是2003
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    //是否是2007的excel，返回true是2007
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

}
