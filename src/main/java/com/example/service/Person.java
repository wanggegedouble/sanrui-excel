package com.example.service;

import com.sanrui.plugs.excel.annotation.ExcelVoConfig;
import com.sanrui.plugs.excel.annotation.Lang;
import com.sanrui.plugs.excel.annotation.TitleStyle;
import com.sanrui.plugs.excel.annotation.input.InputDicConfig;
import com.sanrui.plugs.excel.annotation.output.OutputDicConfig;
import com.sanrui.plugs.excel.annotation.output.OutputTargetConfig;
import com.sanrui.plugs.excel.annotation.validate.DicValidateConfig;
import com.sanrui.plugs.excel.bean.BaseExcelVo;
import lombok.Data;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

@ExcelVoConfig
@Data
public class Person extends BaseExcelVo {
    @Lang(value = "id")
    @TitleStyle(width = 20,height = 50,hAlign = HorizontalAlignment.CENTER)//样式处理
    private String id;

    @OutputTargetConfig //导出时忽略字段
    private String hideValue;


    @Lang(value = "age")
    @TitleStyle(width= 10, height = 50, hAlign = HorizontalAlignment.CENTER)//样式处理
    private String age;

    @Lang(value = "课程名称")
    @TitleStyle(width = 10, height = 50,hAlign = HorizontalAlignment.CENTER)//样式处理
    private String Name;

    @InputDicConfig(dicCode = "KCLX")//Excel导入的配置
    @OutputDicConfig(dicCode = "KCLX")//Excel导出的配置
    @DicValidateConfig(dicCode = "KCLX")//如果要导出下拉框就加这个
    @Lang(value = "课程类型")
    @TitleStyle(width= 20,
            bgColor = IndexedColors.BLUE_GREY, color = IndexedColors.WHITE)
    private String type;

    public Person(String id,  String age, String name, String type) {
        this.id = id;
        this.age = age;
        Name = name;
        this.type = type;
    }

    public Person() {
    }

    @Override
    public int getHashVal() {
        return 0;
    }

}
