package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
 */
import static com.mycompany.mavenproject4.compare.columnNumForFirst;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;


public class compare1 {

   public static void main(String[] args) throws IOException{
        try{
            ArrayList arr1 = new ArrayList<>();
	    ArrayList arr2 = new ArrayList<>();
            ArrayList arr3 = new ArrayList<>();
            ArrayList arr4 = new ArrayList<>();
           
            FileInputStream file = new FileInputStream(new File("D:\\Excel.xls"));
            FileInputStream file1 = new FileInputStream(new File("D:\\Excel1.xls"));
            
            //Create Workbook instance holding reference to .xlsx file
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFWorkbook workbook1 = new HSSFWorkbook(file1);
            
            //Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFSheet sheet1 = workbook1.getSheetAt(0);
            
            //int rowStart1 = sheet.getFirstRowNum();
            int rowEnd1 = sheet.getLastRowNum();
            
            for (int rowNum = 1; rowNum <= rowEnd1; rowNum++){
                Row row1 = sheet.getRow(rowNum);
                
                if (row1 == null){
                    System.out.print(" ");
                }
             Cell cell0 = row1.getCell(0);
             Cell cell1 = row1.getCell(1);
             Cell cell2 = row1.getCell(2);
             for (Cell cell : new Cell[]{cell0,cell1,cell2}){
                 switch(cell.getCellType()){
                     case NUMERIC:
                         System.out.print(cell.getNumericCellValue()+"\t");
                         break;
                         case STRING:
                         System.out.print(cell.getStringCellValue()+"\t");
                         break;
                 }
               }
             System.out.println(" ");
               
             }
            System.out.println("\n----------------------------------------");
            //int rowStart2 = sheet1.getFirstRowNum();
            int rowEnd2 = sheet1.getLastRowNum();
            
            for(int rowNum = 1; rowNum <= rowEnd2; rowNum++){
               Row row2 = sheet1.getRow(rowNum);
               
               if (row2 == null){
                   System.out.print(" ");
               }
               Cell cell0 = row2.getCell(0);
               Cell cell1 = row2.getCell(1);
               Cell cell2 = row2.getCell(2);
               for(Cell cell : new Cell[]{cell0,cell1,cell2}){
               
                 switch(cell.getCellType()){
                     case NUMERIC:
                         System.out.print(cell.getNumericCellValue()+"\t");
                         break;
                         case STRING:
                         System.out.print(cell.getStringCellValue()+"\t");
                         break;
                 }
               }
              System.out.println(" ");
            }
          file.close();
          
           int rowLast1 = sheet.getLastRowNum();
           for(int i = 1; i <= rowLast1; i++){
               Row rowRead1 = sheet.getRow(i);
                if (rowRead1 == null){
                   System.out.print(" ");
               }
               Cell column0 = rowRead1.getCell(0);
               Cell column1 = rowRead1.getCell(1);
               Cell column2 = rowRead1.getCell(2);
               for(Cell cell : new Cell[]{column1}){
                 switch(cell.getCellType()){
                     case NUMERIC:
                         arr1.add(cell.getNumericCellValue());
                         break;
                         case STRING:
                         arr1.add(cell.getStringCellValue());
                         break;  
                 }
               }
           }
           int rowLast2 = sheet1.getLastRowNum();
           for(int i = 1; i <= rowLast2; i++){
               Row rowRead2 = sheet1.getRow(i);
                if (rowRead2 == null){
                   System.out.print(" ");
               }
               Cell column0 = rowRead2.getCell(0);
               Cell column1 = rowRead2.getCell(1);
               Cell column2 = rowRead2.getCell(2);
               for(Cell cell : new Cell[]{column0}){
                 switch(cell.getCellType()){
                     case NUMERIC:
                         arr2.add(cell.getNumericCellValue());
                         break;
                         case STRING:
                         arr2.add(cell.getStringCellValue());
                         break;
                    }
                }
            }
            for (Object process : arr1) {
	     if (!arr2.contains(process)) {
	           arr3.add(process);
              }
            }
            for (Object process : arr1) {
	     if (arr2.contains(process)) {
	           arr4.add(process);
              } 
            }
            System.out.println("Student who did not submit : " + arr3);
            System.out.println("student who submit: " + arr4);
            writeResultDataToExcel(arr3);
            writeResultDataToExcel1(arr4);
            
           // closing the files
	file.close();
        file1.close();
            
            } catch (FileNotFoundException e) {
	    e.printStackTrace();
            }catch (IOException e) {
	    e.printStackTrace();
            
		}
    }
   private static void writeResultDataToExcel(ArrayList arr3)  {

		FileOutputStream resultExcel = null;
		try {
			resultExcel = new FileOutputStream("D:\\List of matricno not submmited.xls");

			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet spreadSheet = workBook.createSheet("New");
			HSSFRow row;
			HSSFCell cell;
                         for (int i1 = 0; i1 < arr3.size(); i1++) {
				row = spreadSheet.createRow(i1);
				cell = row.createCell(0);
				cell.setCellValue(arr3.get(i1).toString().trim());
			}
                        int j = 0;    
                        spreadSheet.autoSizeColumn(j);
			workBook.write(resultExcel);
                        
		}  catch (FileNotFoundException e) {
	           e.printStackTrace();
                  }catch (IOException e) {
	           e.printStackTrace();
		}
        }
    private static void writeResultDataToExcel1(ArrayList arr4)  {

		FileOutputStream resultExcel = null;
		try {
			resultExcel = new FileOutputStream("D:\\List of matricno submmited.xls");

			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet spreadSheet = workBook.createSheet("New");
			HSSFRow row;
			HSSFCell cell;
                         for (int i1 = 0; i1 < arr4.size(); i1++) {
				row = spreadSheet.createRow(i1);
				cell = row.createCell(0);
				cell.setCellValue(arr4.get(i1).toString().trim());
			}
                        int j = 0;    
                        spreadSheet.autoSizeColumn(j);
			workBook.write(resultExcel);
                        
		}  catch (FileNotFoundException e) {
	           e.printStackTrace();
                  }catch (IOException e) {
	           e.printStackTrace();
		}
        }
    
}
        

