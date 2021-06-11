package com.yaorange;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class POITest {
    public static void main(String[] args) throws IOException {
        //创建工作薄（新建Excel表格文件）
//        Workbook wb = new HSSFWorkbook();//操作03-版本文件，xls
//        Workbook wb = new XSSFWorkbook();//操作07+版本文件，xlsx
//        //在工作薄中新增工作表
//        Sheet sheet = wb.createSheet();//可以在方法参数中指定工作表名
//        //在表中创建行对象,参数为创建的行数索引，下标从0开始
//        for (int i = 0; i < 100000; i++) {//创建四行
//            Row row = sheet.createRow(i);
//            for (int j = 0; j < 4; j++) {//每行4列
//                //通过行创建单元格对象:参数为的列数索引，下标从0开始
//                Cell cell = row.createCell(j);////表示在工作表的第4行的第4个单元格
//                //给单元格设置内容
//                //实际开发中，一般通过查询数据库获取数据设置内容
//                cell.setCellValue("第"+(i+1)+"行,第"+(j+1)+"列");
//                //给单元格设置样式
//                //通过工作薄创建单元格样式对象
//                CellStyle cellStyle = wb.createCellStyle();
//                //通过工作薄创建字体对象
//                Font font = wb.createFont();
//                font.setBold(true);//加粗
//                font.setFontName("华文行楷");//字体
//                font.setFontHeightInPoints((short) 20);//字体大小
//                font.setColor(Font.COLOR_RED);//字体颜色
//                //将设置好的字体对象设置给单元格样式对象
//                cellStyle.setFont(font);
//                //设置文本对齐方式
//        		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
//        		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
//        		//设置边框
//        		cellStyle.setBorderTop(BorderStyle.THIN);//细边框
//                //自行补充边框颜色
//        		cellStyle.setBorderRight(BorderStyle.THIN);
//        		cellStyle.setBorderBottom(BorderStyle.THIN);
//        		cellStyle.setBorderLeft(BorderStyle.THIN);
//
//                //将准备好的单元格样式对象设置给单元格对象
//                cell.setCellStyle(cellStyle);
//                System.out.println(i);
//            }
//        }
//
//        //使用输出流将当前工作薄输出
//        wb.write(new FileOutputStream("E:/test.xlsx"));
//
//        wb.close();
        Workbook workbook = new SXSSFWorkbook();
        long s = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Sheet sheet = workbook.createSheet("测试"+j+1);
            System.out.println("正在创建表：测试"+j+1);
            for (int i = 1; i <= 1000000; i++) {
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue("测试人员" + i + "号");
                row.createCell(1).setCellValue("123");
                row.createCell(2).setCellValue("456");
            }
            System.out.println("已创建表：测试"+j+1);

        }
        long e = System.currentTimeMillis();

        workbook.write(new FileOutputStream("D:/test.xlsx"));
        System.out.println("耗时："+ (e-s));
        workbook.close();

    }

}
