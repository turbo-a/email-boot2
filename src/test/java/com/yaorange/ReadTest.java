package com.yaorange;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ClassName ReadTest
 * @Description TODO
 * @Auther elsfk
 * @Date2021/4/21 10:25
 * @Version 1.0
 **/
public class ReadTest {
    public static void main(String[] args) throws IOException {
        //读取xls文件
//        Workbook wb = new HSSFWorkbook(new FileInputStream("C:\\Users\\elsfk\\Desktop\\test\\名单.xls"));
        //读取后缀名为xlsx的文件
        Workbook wb = new XSSFWorkbook(new FileInputStream("C:/Users/elsfk/Desktop/test/名单.xlsx"));
        //
        /*
        Workbook workbook = null;
        try {
            //通过工厂类创建工作簿(根据文件版本选择HSSF或XSSF创建工作簿)
            workbook = WorkbookFactory.create(new FileInputStream("E:/test.xls"));
        } catch (InvalidFormatException e) {
        }
        */
        //获取工作簿指定索引的表
        Sheet sheet = wb.getSheetAt(0);
        Row row = sheet.getRow(1);//获取表中第二行
        Cell cell = row.getCell(0);//获取第二行的第一列
        cell.setCellValue(Cell.CELL_TYPE_STRING);
        //不同单元格数据需要使用不同方法获取：
        //getNumericCellValue():获取数字值单元格数据
        //getStringCellValue():获取字符值单元格数据
        //.......
        double num = cell.getNumericCellValue();//获取单元格的数字值
        //给单元格设置内容
        cell.setCellValue("设置新的值");
        Cell cell_1 = row.getCell(1);
        String name = cell_1.getStringCellValue();//获取单元格的字符值
        System.out.println(num +"----------"+name);
        //省略其他代码

        wb.close();

    }
}
