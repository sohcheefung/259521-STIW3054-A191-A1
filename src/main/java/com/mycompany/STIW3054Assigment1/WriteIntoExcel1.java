package com.mycompany.STIW3054Assigment1;

/**
 *
 * @author Chee Fung
 */

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileOutputStream;

public class WriteIntoExcel1 {
    public void writeData() {
        try {

             GithubWikiData getWikiData = new GithubWikiData();
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet("List of Student");
            
             //Create row header 
             Row rowHeader = sheet.createRow(0);
             rowHeader.createCell(0).setCellValue("  No. ");
             rowHeader.createCell(1).setCellValue("         Matric       ");
             rowHeader.createCell(2).setCellValue("         Name          ");

             //set row heading size, font and position
             for (int i = 0; i <= 2; i++) {
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowHeader.getCell(i).setCellStyle(style);
             }
            
             int r = 1;
             for (Retrive info : getWikiData.Scrape()) {
                 //Create row
                 Row row = sheet.createRow(r);
                 //column 1: td no
                 Cell Column1 = row.createCell(0);
                 Column1.setCellValue(info.getColumn1());
                 //column 2: td matric no
                 Cell Column2 = row.createCell(1);
                 Column2.setCellValue(info.getColumn2());
                 //column 3: td name
                 Cell Column3 = row.createCell(2);
                 Column3.setCellValue(info.getColumn3());
                 r++;
            }
             
              //column size
             for (int i = 1; i <= 35; i++)
                sheet.autoSizeColumn(i);
           
             //Save to Excel
             FileOutputStream out = new FileOutputStream(new File("D:\\GithubWikiTable.xls"));
             workbook.write(out);
             out.close();
             workbook.close();

            } catch (Exception e) {
              System.out.print(e.getStackTrace());
        }
    }
}
