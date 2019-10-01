package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;

public class scrapeWikiData {
    public List<Data> findAll(){
        try {
            System.out.println("");
            String URL = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document doc = Jsoup.connect(URL).get();
            String tittle = doc.title();
            System.out.printf("%66s", tittle + "\n");
            System.out.printf("No.");
            System.out.print("    ");
            System.out.printf("Matric");
            System.out.print("    ");
            System.out.printf("Name\n");
            System.out.println("-----------------------------------------------------------------------------------------");
            List<Data> result = new ArrayList<Data>();

            for (int i = 1; i <= 35; i++) {
                Elements No = doc.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(1)");
                Elements Matric = doc.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
                Elements Name = doc.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
                //System.out.printf("%2d", i);
                //System.out.print(" : ");
                System.out.printf("%1s", No.text());
                System.out.print("    ");
                System.out.printf("%3s", Matric.text());
                System.out.print("    ");
                System.out.printf("%5s", Name.text() + "\n");
                result.add(new Data(No.text(), Matric.text(),Name.text()));
            }
            return result;

        }catch (Exception e){
            return null;
        }

    }

}