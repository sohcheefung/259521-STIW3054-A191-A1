package com.mycompany.mavenproject4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class compare {
	static Boolean check = false;
	
	//Change column number whatever you want to take data
	
	public static void main(String args[]) throws IOException {

		try {

			ArrayList arr1 = new ArrayList();
			ArrayList arr2 = new ArrayList();
			ArrayList arr3 = new ArrayList();
                        ArrayList arr4 = new ArrayList();

			FileInputStream file1 = new FileInputStream(new File(
					"D://Excel.xls"));

			FileInputStream file2 = new FileInputStream(new File(
					"D://Excel1.xls"));

			// Get the workbook instance for XLSX file
			HSSFWorkbook workbook1 = new HSSFWorkbook(file1);
			HSSFWorkbook workbook2 = new HSSFWorkbook(file2);

			// Get only first sheet from the workbook
			HSSFSheet sheet1 = workbook1.getSheetAt(0);
			HSSFSheet sheet2 = workbook2.getSheetAt(0);

			
			// Get iterator to all the rows in current sheet1
			Iterator<Row> rowIterator1 = sheet1.iterator();
			Iterator<Row> rowIterator2 = sheet2.iterator();
                        Iterator<Row> rowIterator3 = sheet1.iterator();
                        Iterator<Row> rowIterator4 = sheet2.iterator();
			
			//getting date from first excel file
			while (rowIterator1.hasNext()) {
				Row row = rowIterator1.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// This is for read only one column from excel
					if (cell.getColumnIndex() == 1) {
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
						case NUMERIC:
							
							arr1.add(cell.getNumericCellValue());
							break;
                                                case STRING:
							arr1.add(cell.getStringCellValue());
							
							break;
                                                case BOOLEAN:
							arr1.add(cell.getBooleanCellValue());
							
							break;
						}

					}

				}

				
			}

			file1.close();

			
			// For retrive the second excel data
			while (rowIterator2.hasNext()) {
				Row row1 = rowIterator2.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator1 = row1.cellIterator();

				while (cellIterator1.hasNext()) {

					Cell cell1 = cellIterator1.next();
					// Check the cell type and format accordingly

					// This is for read only one column from excel
					if (cell1.getColumnIndex() == 0) {
						switch (cell1.getCellType()) {
                                                case NUMERIC:
							arr2.add(cell1.getNumericCellValue());
							
							break;
						case STRING:
							arr2.add(cell1.getStringCellValue());
							
							break;
                                                case BOOLEAN:
							arr2.add(cell1.getBooleanCellValue());
							
							break;

						}

					}
					
				}

				
			}

			

			// compare two arrays
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
			System.out.println("\narr3 list values, here arr1 has some values which arr2 DOES NOT have : " + arr3);
			 System.out.format("| %-10s| %-20s| %-40s| %-20s\n", "No","Matric","Name","Link");
                         int a = 0;
                        
                        while (rowIterator3.hasNext()){
                            Row row = rowIterator3.next();
                            
                            for(Object matric: arr3){
                                if (row.getCell(1).toString().equals(matric)){
                                    
                                    a++;
                                     System.out.printf("| %-10s| %-20s| %-40s| %-20s\n",a,row.getCell(1),row.getCell(2),row.getCell(3));
                                }
                            }
                        }
                        System.out.println("\narr3 list values, here arr1 has some values which arr2 DOES NOT have : " + arr4);
			 System.out.format("| %-10s| %-20s| %-40s| %-20s\n", "No","Matric","Name","Link");
                         int b = 0;
                        
                        while (rowIterator4.hasNext()){
                            Row row = rowIterator4.next();
                            
                            for(Object matric: arr4){
                                if (row.getCell(0).toString().equals(matric)){
                                    
                                    b++;
                                     System.out.printf("| %-10s| %-20s| %-40s| %-20s\n",b,row.getCell(0),row.getCell(1),row.getCell(2));
                                }
                            }
                        }

			// closing the files
			file1.close();
			file2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        }
}
	
