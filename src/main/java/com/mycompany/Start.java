package com.mycompany;

/**
 *
 * @author Chee Fung
 */
public class Start {

    public static void main(String[] args) {
        try {
            WriteIntoExcel1 save = new WriteIntoExcel1();
            save.writeData();
            System.out.println("\nWriting data to Excel...");
            System.out.println("Excel has been saved");
            System.out.println("Done");

            WriteIntoExcel2 save1 = new WriteIntoExcel2();
            save1.writeData();
            System.out.println("\nWriting data to Excel...");
            System.out.println("Excel has been saved");
            System.out.println("Done");

            CompareData output = new CompareData();
            output.comparison();

            System.out.println("END");

        } catch (Exception e) {
            System.out.println("Program execution failed...");
        }
    }
}
