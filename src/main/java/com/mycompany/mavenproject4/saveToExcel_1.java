package com.mycompany.mavenproject4;



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

public class saveToExcel_1 {
    public void saveData() {
        try {

            link link = new link();
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("data");
            
            //Create Heading
            Row rowHeading = sheet.createRow(0);
             rowHeading.createCell(0).setCellValue("         Matric        ");
            rowHeading.createCell(1).setCellValue("         Name             ");
            rowHeading.createCell(2).setCellValue("         Github Link      ");

            //1st Row Font Size
            for (int i = 0; i <= 2; i++) {
                CellStyle style = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                font.setFontName(HSSFFont.FONT_ARIAL);
                font.setFontHeightInPoints((short) 12);
                style.setFont(font);
                style.setVerticalAlignment(VerticalAlignment.CENTER);
                rowHeading.getCell(i).setCellStyle(style);
            }

            int r = 1;
            for (Data data : link.FindAll()) {
                //Create row
                Row row = sheet.createRow(r);
                //Column 1
                //Cell cellId = row.createCell(0);
                //cellId.setCellValue(data.getNum());
                //Column 2 : TR Data
                Cell cellColumn1 = row.createCell(0);
                cellColumn1.setCellValue(data.getColumn1());
                //Column 3: TD Data
                Cell cellColumn2 = row.createCell(1);
                cellColumn2.setCellValue(data.getColumn2());
                //Column 4
                Cell cellColumn3 = row.createCell(2);
                cellColumn3.setCellValue(data.getColumn3());
                r++;
            }
              for (int i = 1; i <= 35; i++)
                sheet.autoSizeColumn(i);
            
           

            //Save to Excel FILE
            FileOutputStream out = new FileOutputStream(new File("D:\\Excel1.xls"));
            workbook.write(out);
            out.close();
            workbook.close();

        } catch (
                Exception e) {
            System.out.print(e.getStackTrace());
        }
    }

}
