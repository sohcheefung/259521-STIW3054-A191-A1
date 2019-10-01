package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
 */

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class link {
  public static void main(String[] args) throws IOException {
      
      Document doc = Jsoup.connect("https://github.com/STIW3054-A191/Main-Issues/issues/1").get();
      String title = doc.title();
      System.out.println("title :"+title);
      
      Elements links = doc.select("a[href]");
      
      for (Element link: links)
      {
          System.out.println("\nlink :"+link.attr("href"));
          System.out.println("text: "+link.text());
      }    
      
  }
}

