package com.mycompany;

/**
 *
 * @author Chee Fung
*/ 

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class MainIssueData {
    public List<Retrive> Scrape1() {
        try {
            Document doc = Jsoup.connect("https://github.com/STIW3054-A191/Main-Issues/issues/1").get();
            String title = doc.title();
            System.out.printf("%66s", title + "\n");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            System.out.printf("| %-5s| %-17s| %-50s| %-70s\n", "No.","Matric","Name","Link");
            System.out.println("--------------------------------------------------------------------------------------------------------------------");
            //define arraylist
            List<Retrive> information1 = new ArrayList<Retrive>();
            
            //get the data using class name
            Elements data = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container");
            for (int i = 1; i<data.size(); i++){
                //get the content inside p tag
                Elements content = data.get(i).getElementsByTag("p");
                    for (int j=0; j<content.size(); j++){
                        
                        //String declaration to store data
                        String ListofMatric = null;
                        
                        //patter regex to capture the data
                        Pattern Matric = Pattern.compile("(\\d{6})");
                        Matcher matricNo = Matric.matcher(content.get(j).text());
                
                        Pattern Matric1 = Pattern.compile("(\\d{5})");
                        Matcher matricNo1 = Matric1.matcher(content.get(j).text());
                        
                        if(matricNo.find()){
                            
                            System.out.printf("| %-5s",i);
                            System.out.printf("| %-17s",matricNo.group());
                            ListofMatric = matricNo.group();
                            
                        }
                        else if(matricNo1.find()){
                            
                            System.out.printf("| %-5s",i);
                            System.out.printf("| %-17s",matricNo1.group());
                            ListofMatric = matricNo1.group();
                            
                        }
                        else{
                            
                            System.out.print(" ");
                            
                        }
                
                        String ListofName = null;
                        
                        Pattern Name1 = Pattern.compile("(Name)(.*)(Matric)");
                        Matcher NameStudent1 = Name1.matcher(content.get(j).text());
               
                        Pattern Name2 = Pattern.compile("(name)(.*)(link)");
                        Matcher NameStudent2 = Name2.matcher(content.get(j).text());
                
                        Pattern Name3 = Pattern.compile("(Name)(.*)(Link)");
                        Matcher NameStudent3 = Name3.matcher(content.get(j).text());
               
                        if(NameStudent1.find()){
                            
                            System.out.printf("| %-50s",NameStudent1.group(2).replaceAll(":"," "));
                            ListofName = NameStudent1.group(2).replaceAll(":"," ");
                            
                        }
                        else if(NameStudent2.find()){
                            
                            System.out.printf("| %-50s",NameStudent2.group(2).replaceAll(":"," "));
                            ListofName = NameStudent2.group(2).replaceAll(":"," ");
                            
                        }
                        else if(NameStudent3.find()){
                            
                            System.out.printf("| %-50s",NameStudent3.group(2).replaceAll(":"," ")); 
                            ListofName = NameStudent3.group(2).replaceAll(":"," ");
                            
                        }
                        else{
                            
                             System.out.print(" ");  
                             
                         }
                
                        Pattern Link = Pattern.compile("https://.*");
                        Matcher Listoflink = Link.matcher(content.get(j).text());
                
                        if(Listoflink.find()){
                            
                            System.out.printf("| %-70s\n",Listoflink.group());  
                        }
                        else{
                            
                            System.out.print(" ");  
                        }
                
                        information1.add(new Retrive(ListofMatric, ListofName, Listoflink.group()));
                    }
                }
             return information1;

           }catch (Exception e){
            return null;
        }
    }
}
                
        
        
        

    
         

           
            
        
    


  

       
    


