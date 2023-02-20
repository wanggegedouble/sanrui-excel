/*
 * Copyright 2015 www.hyberbin.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * Email:hyberbin@qq.com
 */
package excel;

import com.sanrui.plugs.excel.annotation.ExcelColumnGroup;
import com.sanrui.plugs.excel.annotation.ExcelVoConfig;
import com.sanrui.plugs.excel.annotation.Lang;
import com.sanrui.plugs.excel.annotation.TitleStyle;
import com.sanrui.plugs.excel.annotation.input.InputDicConfig;
import com.sanrui.plugs.excel.annotation.output.OutputDicConfig;
import com.sanrui.plugs.excel.annotation.validate.DicValidateConfig;
import com.sanrui.plugs.excel.bean.BaseExcelVo;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.util.List;

@ExcelVoConfig//Excel导出的配置
public class SchoolCourse extends BaseExcelVo {

    @Lang(value = "ID")//Excel导出的配置
    @TitleStyle(height = 50, hAlign = HorizontalAlignment.CENTER)
    private String id;
    @Lang(value = "课程名称")//Excel导出的配置
    @TitleStyle(width= 30)
    private String courseName;

    @InputDicConfig(dicCode = "KCLX")//Excel导入的配置
    @OutputDicConfig(dicCode = "KCLX")//Excel导出的配置
    @DicValidateConfig(dicCode = "KCLX")//如果要导出下拉框就加这个
    @Lang(value = "课程类型")//Excel导出的配置
    @TitleStyle(width= 20,
            bgColor = IndexedColors.BLUE_GREY, color = IndexedColors.WHITE,
            border = BorderStyle.MEDIUM)
    private String type;

    @ExcelColumnGroup(type = String.class)
    private List<String> baseArray;
    @ExcelColumnGroup(type = InnerVo.class)
    private List<InnerVo> innerVoArray;

    public SchoolCourse() {
    }

    public SchoolCourse(String id, String courseName, String type) {
        this.id = id;
        this.courseName = courseName;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getBaseArray() {
        return baseArray;
    }

    public void setBaseArray(List<String> baseArray) {
        this.baseArray = baseArray;
    }

    public List<InnerVo> getInnerVoArray() {
        return innerVoArray;
    }

    public void setInnerVoArray(List<InnerVo> innerVoArray) {
        this.innerVoArray = innerVoArray;
    }

    @Override
    public int getHashVal() {
        return 0;
    }

}
