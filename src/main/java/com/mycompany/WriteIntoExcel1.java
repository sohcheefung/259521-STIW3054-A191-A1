package com.mycompany;

/**
 *
 * @author Chee Fung
 */

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import java.io.File;
import java.io.FileOutputStream;


public class WriteIntoExcel1 {
    public void writeData() {
        try {

             GithubWikiData getWikiData = new GithubWikiData();
             HSSFWorkbook workbook = new HSSFWorkbook();
             HSSFSheet sheet = workbook.createSheet("List of Student");
            
             //Create row header 
             Row rowtitle = sheet.createRow(0);
             rowtitle.createCell(0).setCellValue("  No. ");
             rowtitle.createCell(1).setCellValue("         Matric       ");
             rowtitle.createCell(2).setCellValue("         Name          ");

             //set row heading size, font and position
             for (int i = 0; i <= 2; i++) {
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowtitle.getCell(i).setCellStyle(style);
             }
            
             int r = 1;
             for (Retrive info : getWikiData.Scrape()) {
                 //Create row
                 Row row = sheet.createRow(r);
                 //column 1: td no
                 Cell Column1 = row.createCell(0);
                 Column1.setCellValue(info.Column1());
                 //column 2: td matric no
                 Cell Column2 = row.createCell(1);
                 Column2.setCellValue(info.Column2());
                 //column 3: td name
                 Cell Column3 = row.createCell(2);
                 Column3.setCellValue(info.Column3());
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
