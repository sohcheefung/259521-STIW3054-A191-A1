package com.mycompany.STIW3054Assigment1;

/**
 *
 * @author Chee Fung
 */
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
import org.apache.poi.ss.usermodel.Row;


public class CompareData {

    public void comparison() {
        try{
            //create array to store data
            ArrayList array1 = new ArrayList<>();
	    ArrayList array2 = new ArrayList<>();
            ArrayList array3 = new ArrayList<>();
            ArrayList array4 = new ArrayList<>();
            ArrayList array5 = new ArrayList<>();
           
            //input excel file location
            FileInputStream file = new FileInputStream(new File("D:\\GithubWikiTable.xls"));
            FileInputStream file1 = new FileInputStream(new File("D:\\GithubMainIssue.xls"));
            
            //create Workbook instance
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFWorkbook workbook1 = new HSSFWorkbook(file1);
            
            //get sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);
            HSSFSheet sheet1 = workbook1.getSheetAt(0);
            
           
            //get row last number
            int rowLast1 = sheet.getLastRowNum();
                for(int i = 1; i <= rowLast1; i++){
                    Row rowRead1 = sheet.getRow(i);
                        if (rowRead1 == null){
                            
                            System.out.print(" ");
                }
            //get column index
            Cell column1 = rowRead1.getCell(1);
                for(Cell cell : new Cell[]{column1}){
                    switch(cell.getCellType()){
                        case NUMERIC:
                        //store the value into array
                        array1.add(cell.getNumericCellValue());
                        break;
                        case STRING:
                        array1.add(cell.getStringCellValue());
                        break;  
                    }
                }
            }
          
            int rowLast2 = sheet1.getLastRowNum();
                for(int j = 1; j <= rowLast2; j++){
                    Row rowRead2 = sheet1.getRow(j);
                        if (rowRead2 == null){
                            
                            System.out.print(" ");
                }
            Cell column0 = rowRead2.getCell(0);
                for(Cell cell : new Cell[]{column0}){
                    switch(cell.getCellType()){
                        case NUMERIC:
                        array2.add(cell.getNumericCellValue());
                        break;
                        case STRING:
                        array2.add(cell.getStringCellValue());
                        break;
                    }
                }
            }
            //Compare the value between array1 and array2 for different
            for (Object data : array1) {
	     if (array2.contains(data)) {
	           array3.add(data);
              }
            }
           for (Object data : array1) {
	     if (!array2.contains(data)) {
	           array4.add(data);
              } 
            }
            for (Object data : array2){
              if (!array1.contains(data)){
                   array5.add(data);
               }
           }
            //display the compare result
            Iterator<Row> rowIterator1 = sheet.iterator();
            Iterator<Row> rowIterator2 = sheet1.iterator();
            Iterator<Row> rowIterator3 = sheet1.iterator();
            
            System.out.println("STUDENT WHO SUBMIT GITHUB ACCOUNT: ");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.format("| %-5s| %-17s| %-50s| %-70s\n", "No.","Matric","Name","Link");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            int a = 0;
                        while (rowIterator2.hasNext()){
                            Row row = rowIterator2.next();
                                for(Object matric: array3){
                                    //check if the row value match the array
                                    if (row.getCell(0).toString().equals(matric)){
                                    a++;
                                    System.out.printf("| %-5s| %-17s| %-50s| %-70s\n",a,row.getCell(0),row.getCell(1),row.getCell(2));
                                }
                            }
                        } 
    
            System.out.println("STUDENT WHO DOES NOT SUBMIT GITHUB ACCOUNT: ");
            System.out.println("-----------------------------------------------------------");
            System.out.format("| %-5s| %-17s| %-50s\n", "No.","Matric","Name");
            System.out.println("-----------------------------------------------------------");
            int b = 0;
                        while (rowIterator1.hasNext()){
                            Row row = rowIterator1.next();
                                for(Object matric: array4){
                                    if (row.getCell(1).toString().equals(matric)){
                                    b++;
                                    System.out.printf("| %-5s| %-17s| %-50s\n",b,row.getCell(1),row.getCell(2));
                                }
                            }
                        }
           System.out.println("UNKNOWN LIST: ");
           System.out.println("--------------------------------------------------------------------------------------------------------------------");
           System.out.format("| %-5s| %-17s| %-50s| %-70s\n", "No.","Matric","Name","Link");
           System.out.println("--------------------------------------------------------------------------------------------------------------------");
           int c = 0;
                        while (rowIterator3.hasNext()){
                            Row row = rowIterator3.next();
                                for(Object matric: array5){
                                    if (row.getCell(0).toString().equals(matric)){
                                    c++;
                                    System.out.printf("| %-5s| %-17s| %-50s| %-70s\n",c,row.getCell(0),row.getCell(1),row.getCell(2));
                                }
                            }
                        }             
                       
                   
            }catch (Exception e) {
	    e.printStackTrace(); 
        }
    }
}

        
        
    
        
    

        

