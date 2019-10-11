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

public class WriteIntoExcel2 {
    public void writeData() {
        try {

             MainIssueData link = new MainIssueData();
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet("Student");
            
             //create row Header
             Row rowHeader = sheet.createRow(0);
             rowHeader.createCell(0).setCellValue("      Matric          ");
             rowHeader.createCell(1).setCellValue("         Name             ");
             rowHeader.createCell(2).setCellValue("         Github Link      ");

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
            
             //column size
             
             int r = 1;
             for (Retrive info1 : link.Scrape1()) {
                 //Create row
                 Row row = sheet.createRow(r);
                 //column 1 : matric
                 Cell Column1 = row.createCell(0);
                 Column1.setCellValue(info1.getColumn1());
                 //column 2 : name
                 Cell Column2 = row.createCell(1);
                 Column2.setCellValue(info1.getColumn2());
                 //column 3 : link
                 Cell Column3 = row.createCell(2);
                 Column3.setCellValue(info1.getColumn3());
                 r++;
             }
             
              //column size
             for (int i = 1; i <= 35; i++)
                sheet.autoSizeColumn(i);
              
             //Save to Excel 
             FileOutputStream out = new FileOutputStream(new File("D:\\GithubMainIssue.xls"));
             workbook.write(out);
             out.close();
             workbook.close();

        } catch (Exception e) {
          System.out.print(e.getStackTrace());
        }
    }
}
