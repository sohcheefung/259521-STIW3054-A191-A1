package com.mycompany;

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

public class GithubWikiData {
    public List<Retrive> Scrape(){
        try {
            System.out.println("");
            String Link = "https://github.com/STIW3054-A191/Assignments/wiki/List_of_Student";
            Document page = Jsoup.connect(Link).get();
            String title = page.title();
            System.out.printf("%66s", title + "\n");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.printf("| %-5s| %-17s| %-50s\n","No.","Matric","Name");
            System.out.println("--------------------------------------------------------------------------------");
            //define arraylist
            List<Retrive> information = new ArrayList<Retrive>();

            for (int i = 1; i <= 35; i++) {
                //Scrape data from table
                Elements No = page.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(1)");
                Elements Matric = page.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(2)");
                Elements Name = page.select("#wiki-body > div > table > tbody > tr:nth-child(" + i + ") > td:nth-child(3)");
               
                
                System.out.printf("| %-5s| %-17s| %-50s\n",No.text(),Matric.text(),Name.text());
                information.add(new Retrive(No.text(), Matric.text(),Name.text()));
            }
             return information;

            }catch (Exception e){
             return null;
        }

    }

}