
package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
 */
public class app {
        public static void main(String[] args) {
            try{
                saveToExcel save = new saveToExcel();
                save.saveData();

                System.out.println("\n\nSaving data to Excel...");
                Thread.sleep(2000);// wait for 2 second
                System.out.println("Excel Written Successfully");
                System.out.println("END");
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }//End Main
}
