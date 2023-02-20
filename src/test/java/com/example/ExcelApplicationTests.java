package com.example;

import com.example.service.Person;
import com.sanrui.plugs.excel.service.BaseExcelService;
import com.sanrui.plugs.excel.service.ExportExcelService;
import com.sanrui.plugs.excel.service.ImportExcelService;
import com.sanrui.plugs.excel.service.PrintExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class ExcelApplicationTests {
    /*@Test
    public void testVoHasListVoImport() throws Exception {
        Workbook workBook = BaseExcelService.getWorkBook("C:\\Users\\huawei\\Desktop\\wy01.xls");
        Sheet sheet = workBook.getSheet("Sheet1");
        log.info("word");
        Person person = new Person("1001","19","19","1");
        List<Person> personList= new ArrayList<>();
        personList.add(person);
        ExportExcelService<Person> service = new ExportExcelService<>(personList, sheet, new String[]{"id", "Name", "type"}, "1");
        log.info("hello");
        service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");//设置数据字典
        service.doExport();
    }*/

    @Test
    public void testSimpleVoExport() throws Exception {
        Workbook workBook = BaseExcelService.getWorkBook("C:\\Users\\huawei\\Documents\\Java_project\\excel\\src\\main\\resources\\wy01.xls");
        //Workbook workBook = BaseExcelService.createWorkbook();
        //Sheet sheet = BaseExcelService.createSheet(workBook,"testSimpleVoExport");
        Sheet sheet = BaseExcelService.getSheet(workBook,0);
        //ExportExcelService service = new ExportExcelService(list, sheet, "学校课程");
        Person person = new Person("1001","19","19","1");
        List<Person> personList= new ArrayList<>();
        personList.add(person);
        ExportExcelService<Person> service = new ExportExcelService<>(personList, sheet, new String[]{"id", "Name", "type"}, "Sheet1");
        service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");//设置数据字典
        service.doExport();
    }

    @Test
    public void testVoHasListVoImport() throws Exception {
        Workbook workBook = BaseExcelService.getWorkBook("C:\\Users\\huawei\\Documents\\Java_project\\excel\\src\\main\\resources\\wy01.xls");
        Sheet sheet = workBook.getSheet("Sheet1");
        ImportExcelService<Person> service = new ImportExcelService<>(Person.class, sheet);
//      service.addDic("KCLX", "1", "国家课程").addDic("KCLX", "2", "学校课程");//设置数据字典
        List<Person> people = service.doImport();
        System.out.println(people.size());
    }

}
