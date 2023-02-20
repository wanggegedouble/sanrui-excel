package com.example.service;

import com.sanrui.plugs.excel.service.BaseExcelService;
import com.sanrui.plugs.excel.service.ExportExcelService;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Workbook workbook =  BaseExcelService.getWorkBook("C:\\Users\\huawei\\Desktop\\wy01.xls");
        Sheet sheet = workbook.getSheet("Sheet1");
        Person person = new Person("1001","16","高等数学","1");
        List<Person> personList= new ArrayList();
        personList.add(person);
       // ExportExcelService service = new ExportExcelService(personList, sheet, new String[]{"1001","高等数学", "2"}, "学校课程");
        ExportExcelService service = new ExportExcelService(personList, sheet, "学校课程");
        // service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");//设置数据字典
        service.doExport();
    }


}
