package com.example.service;

import com.sanrui.plugs.excel.service.BaseExcelService;
import com.sanrui.plugs.excel.service.ImportExcelService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public class Import {
    public static void main(String[] args) throws Exception {
        Workbook workbook =  BaseExcelService.getWorkBook("C:\\Users\\huawei\\Desktop\\wy01.xls");
        Sheet sheet = workbook.getSheet("Sheet1");
        ImportExcelService service = new ImportExcelService(Person.class, sheet);
        service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");
        List list = service.doImport();
        System.out.println("成功导入：" + list.size() + "条数据");
    }
}
