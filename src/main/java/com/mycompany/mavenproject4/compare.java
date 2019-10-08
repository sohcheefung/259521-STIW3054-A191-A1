package com.mycompany.mavenproject4;

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
	public static int columnNumForFirst = 1;
	public static int columnNumForSecond = 0;

	public static void main(String args[]) throws IOException {

		try {

			ArrayList arr1 = new ArrayList();
			ArrayList arr2 = new ArrayList();
			ArrayList arr3 = new ArrayList();
                        ArrayList arr4 = new ArrayList();

			FileInputStream file1 = new FileInputStream(new File("D:\\Excel.xls"));

			FileInputStream file2 = new FileInputStream(new File("D:\\Excel1.xls"));

			// Get the workbook instance for XLSX file
			HSSFWorkbook workbook1 = new HSSFWorkbook(file1);
			HSSFWorkbook workbook2 = new HSSFWorkbook(file2);

			// Get only first sheet from the workbook
			HSSFSheet sheet1 = workbook1.getSheetAt(0);
			HSSFSheet sheet2 = workbook2.getSheetAt(0);
                        
			// Get iterator to all the rows in current sheet1
			Iterator<Row> rowIterator1 = sheet1.iterator();
			Iterator<Row> rowIterator2 = sheet2.iterator();
			
                       
			//getting date from first excel file
			while (rowIterator1.hasNext()) {
				Row row = rowIterator1.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					// This is for read only one column from excel
					if (cell.getColumnIndex() == columnNumForFirst) {
						// Check the cell type and format accordingly
						switch (cell.getCellType()) {
                                                case NUMERIC:
							arr1.add(cell.getNumericCellValue());
                                                         System.out.print(cell.getNumericCellValue());
							break;
						case STRING:
							arr1.add(cell.getStringCellValue());
							System.out.print(cell.getStringCellValue());
							break;
						}
					}
				}
				System.out.println(" ");
			}
			file1.close();

			System.out.println("\n-----------------------------------");
			// For retrive the second excel data
			while (rowIterator2.hasNext()) {
				Row row1 = rowIterator2.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator1 = row1.cellIterator();

				while (cellIterator1.hasNext()) {

					Cell cell1 = cellIterator1.next();
					// Check the cell type and format accordingly

					// This is for read only one column from excel
					if (cell1.getColumnIndex() == columnNumForSecond) {
						switch (cell1.getCellType()) {
						case NUMERIC:
							arr2.add(cell1.getNumericCellValue());
							System.out.print(cell1.getNumericCellValue());
							break;
						case STRING:
							arr2.add(cell1.getStringCellValue());
							System.out.print(cell1.getStringCellValue());
							break;
						}
					}
                                        // this continue is for
					// continue;
				}
				System.out.println("");
			}
			// compare two arrays
			for (Object process : arr1) {
				if (!arr2.contains(process)) {
					arr3.add(process);
				}
			}
                        for (Object process : arr1){
                                if (arr2.contains(process)){
                                        arr4.add(process);
                                }
                        }
			System.out.println("Student who did not submit : " + arr3);
                        System.out.println("student who submit: " + arr4);
			//writeResultDataToExcel(arr3);
			//StoreArraysToHashMap(arr1, arr2);

			// closing the files
			file1.close();
			file2.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// write into new file excel

	private static void writeResultDataToExcel(ArrayList arr3) {

		FileOutputStream resultExcel = null;
		try {
			resultExcel = new FileOutputStream(
					"D://ResultFile.xls");

			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet spreadSheet = workBook.createSheet("New");
			HSSFRow row;
			HSSFCell cell;
			// System.out.println("array size is :: "+minusArray.size());

			int cellnumber = 1;
			for (int i1 = 1; i1 < arr3.size(); i1++) {
				row = spreadSheet.createRow(i1);
				cell = row.createCell(cellnumber);
				// System.out.print(cell.getCellStyle());
				cell.setCellValue(arr3.get(i1).toString().trim());
			}
			int cellnumber2 = 4;
			for (int i2 = 1; i2 < arr3.size(); i2++) {
				row = spreadSheet.createRow(3);
				cell = row.createCell(cellnumber);
				// System.out.print(cell.getCellStyle());
				cell.setCellValue(arr3.get(i2).toString().trim());
			}
			workBook.write(resultExcel);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
