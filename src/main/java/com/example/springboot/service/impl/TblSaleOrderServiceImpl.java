package com.example.springboot.service.impl;

import antlr.StringUtils;
import com.example.springboot.Util.ReadExcel;
import com.example.springboot.mapper.TblSaleItemMapper;
import com.example.springboot.mapper.TblSaleItemSpecMapper;
import com.example.springboot.mapper.TblSaleOrderDetailMapper;
import com.example.springboot.mapper.TblSaleOrderMapper;
import com.example.springboot.model.*;
import com.example.springboot.service.TblSaleOrderService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TblSaleOrderServiceImpl implements TblSaleOrderService{
    private Logger logger= LoggerFactory.getLogger(TblSaleOrderServiceImpl.class);
    @Resource
    private TblSaleOrderMapper tblSaleOrderMapper;
    @Resource
    private TblSaleOrderDetailMapper tblSaleOrderDetailMapper;
    @Resource
    private TblSaleItemMapper tblSaleItemMapper;
    @Resource
    private TblSaleItemSpecMapper tblSaleItemSpecMapper;
    @Override
    public String readExcelFile(MultipartFile file) {
            String result ="";
            //创建处理EXCEL的类
            ReadExcel readExcel=new ReadExcel();
            //解析excel，获取上传的事件单
            List<ExcelModel> modelList = readExcel.getExcelInfo(file);
            logger.info("这个实体类的大小{}",modelList.size());

            if(modelList != null && !modelList.isEmpty()){
                for(ExcelModel excelModel:modelList){
                    //取备注当中的订单号
                    String string=excelModel.getRemark();
                    if(string!=null&&string!=""){
                        if(string.contains("订单：")){
                            String[] strings=string.split("订单：");
                            //通过订单号查询出主订单
                            TblSaleOrder tblSaleOrder=tblSaleOrderMapper.getByOrderNo(strings[1]);
                            if(tblSaleOrder!=null){
                                //通过订单记录的id查询对应订单的detail
                                TblSaleOrderDetail tblSaleOrderDetail=tblSaleOrderDetailMapper.getById(tblSaleOrder.getId());
                                //查询出商品和规格的名称
                                if(tblSaleOrderDetail!=null){
                                    TblSaleItem tblSaleItem=tblSaleItemMapper.getById(tblSaleOrderDetail.getItemId());
                                    TblSaleItemSpec tblSaleItemSpec=tblSaleItemSpecMapper.getById(tblSaleOrderDetail.getSpecId());
                                    if(tblSaleItem.getItemName().equals(excelModel.getItemName())&&tblSaleItemSpec.getSpecName().equals(excelModel.getSpecName())){

                                        TblSaleOrder saleOrder=new TblSaleOrder();
                                        saleOrder.setCreatedate(new Date());
                                        saleOrder.setDealdate(new Date());
                                        saleOrder.setState(0);
                                        saleOrder.setNickname(excelModel.getName());
                                        saleOrder.setShopId(1L);
                                        saleOrder.setTotalprice(excelModel.getTotalPrice());
                                        saleOrder.setOrderno(strings[1]);
                                        saleOrder.setParentId(tblSaleOrder.getId());
                                        //todo 往order表中插入记录

                                        TblSaleOrderDetail saleOrderDetail=new TblSaleOrderDetail();
                                        try {
                                            BeanUtils.copyProperties(saleOrderDetail, tblSaleOrderDetail);
                                        } catch (Exception e) {
                                            //throw new TenmakerException("拷贝订单数据失败");
                                        }
                                        saleOrderDetail.setId(null);
                                        saleOrderDetail.setTotalPrice(excelModel.getTotalPrice());
                                        saleOrderDetail.setQuantity(tblSaleOrderDetail.getQuantity()-excelModel.getResidualCount());
                                        saleOrderDetail.setOrderId(saleOrder.getId());
                                        saleOrderDetail.setUpdateTime(new Date());
                                        //todo 往orderdetail表插入记录

                                    }
                                }
                            }
                        }
                    }
                }

                result = "login";
            }else{
                result = "上传失败";
            }
            return result;
        }
}
