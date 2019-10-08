package com.mycompany.mavenproject4;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;


public class compareagain {
    public static void main(String[] srgs) throws IOException {


        FileInputStream fileInputStream1 = new FileInputStream("D:\\Book11.xls");

        HSSFWorkbook workbook1 = new HSSFWorkbook(fileInputStream1);

        HSSFSheet worksheet1 = workbook1.getSheet("Sheet1");

        int rowCount1= worksheet1.getPhysicalNumberOfRows();


        FileInputStream fileInputStream2 = new FileInputStream("D:\\Book22.xls");

        HSSFWorkbook workbook2 = new HSSFWorkbook(fileInputStream2);

        HSSFSheet worksheet2 = workbook2.getSheet("Sheet1");

        int rowCount2= worksheet2.getPhysicalNumberOfRows();

if(rowCount1==rowCount2) {
    for (int i = 1; i < rowCount1; i++) {
        HSSFRow row1 = worksheet1.getRow(i);
        HSSFRow row2 = worksheet2.getRow(i);
//------------------------------ comapring ID --------------------------
        String idstr1 = "";
        HSSFCell id1 = row1.getCell(0);
        if (id1 != null) {
            id1.setCellType(CellType.STRING);
            idstr1 = id1.getStringCellValue();
        }


        String idstr2 = "";
        HSSFCell id2 = row2.getCell(0);
        if (id2 != null) {
            id2.setCellType(CellType.STRING);
            idstr2 = id2.getStringCellValue();
        }

        if(!idstr1.equals(idstr2))
        {
            System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + "| Book 1 id = " + idstr1+ " | Book 2 id = " + idstr2);
            System.out.println("Diference for id (book1) " + idstr1 + "| Book 1 id = " + idstr1+ "| Book 2 id = " + idstr2);
        }

//------------------------------ End ID ---------------------------------

// ------------------------------ comapring Name --------------------------
        String namestr1 = "";
        HSSFCell name1 = row1.getCell(1);
        if (name1 != null) {
            name1.setCellType(CellType.STRING);
            namestr1 = name1.getStringCellValue();
        }


        String namestr2 = "";
        HSSFCell name2 = row2.getCell(1);
        if (name2 != null) {
            name2.setCellType(CellType.STRING);
            namestr2 = name2.getStringCellValue();
        }

        if(!namestr1.equals(namestr2))
        {
            System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + " | Book 1 name = " + namestr1+ "| Book 2 name = " + namestr2);
            System.out.println("Diference for id (book1) " + idstr1 + " | Book 1 name = " + namestr1+ "| Book 2 name = " + namestr2);
        }
//------------------------------ End Name Comparison---------------------------------

        // ------------------------------ comapring branch --------------------------
        String branchstr1 = "";
        HSSFCell branch1 = row1.getCell(2);
        if (branch1 != null) {
            branch1.setCellType(CellType.STRING);
            branchstr1 = branch1.getStringCellValue();
        }


        String branchstr2 = "";
        HSSFCell branch2 = row2.getCell(2);
        if (branch2 != null) {
            branch2.setCellType(CellType.STRING);
            branchstr2 = branch2.getStringCellValue();
        }

        if(!branchstr1.equals(branchstr2))
        {
            System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + "| Book 1 branch = " + branchstr1+ "| Book 2 branch = " + branchstr2);
            System.out.println("Diference for id (book1) " + idstr1 + "| Book 1 branch = " + branchstr1+ "| Book 2 branch = " + branchstr2);
        }
//------------------------------ End branch Comparison---------------------------------

// ------------------------------ comapring marks --------------------------
        String marksstr1 = "";
        HSSFCell marks1 = row1.getCell(3);
        if (marks1 != null) {
            marks1.setCellType(CellType.STRING);
            marksstr1 = marks1.getStringCellValue();
        }


        String marksstr2 = "";
        HSSFCell marks2 = row2.getCell(3);
        if (marks2 != null) {
            marks2.setCellType(CellType.STRING);
            marksstr2 = marks2.getStringCellValue();
        }

        if(!marksstr1.equals(marksstr2))
        {
            System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + " | Book 1 marks = " + marksstr1+ " | Book 2 marks = " + marksstr2);
            System.out.println("Diference for id (book1) " + idstr1 + " | Book 1 marks = " + marksstr1+ " | Book 2 marks = " + marksstr2);
        }
//------------------------------ End marks Comparison---------------------------------

// ------------------------------ comapring city --------------------------
        String citystr1 = "";
        HSSFCell city1 = row1.getCell(4);
        if (city1 != null) {
            city1.setCellType(CellType.STRING);
            citystr1 = city1.getStringCellValue();
        }


        String citystr2 = "";
        HSSFCell city2 = row2.getCell(4);
        if (city2 != null) {
            city2.setCellType(CellType.STRING);
            citystr2 = city2.getStringCellValue();
        }

        if(!citystr1.equals(citystr2))
        {
            System.out.println("[ERROR] :"+"Diference for id (book1) " + idstr1 + " | Book 1 city = " + citystr1+ " | Book 2 city = " + citystr2);
            System.out.println("Diference for id (book1) " + idstr1 + " | Book 1 city = " + citystr1+ " | Book 2 city = " + citystr2);
        }
//------------------------------ End city Comparison---------------------------------

        System.out.println("[Processing] :"+"ID " + idstr1 + "=> Book 1 id = " + idstr1+ " Book 2 id = " + idstr2);

    }


}
else {
    System.out.println("Row count 1=" + rowCount1 + "  Rocunt 2 = " + rowCount2);

    System.out.println("Row count 1=" + rowCount1 + "  Rocunt 2 = " + rowCount2);
         }
    }
}
