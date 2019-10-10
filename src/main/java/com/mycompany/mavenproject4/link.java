package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
*/ 

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class link {
    public List<Data> FindAll() {
    
        try{
        Document doc = Jsoup.connect("https://github.com/STIW3054-A191/Main-Issues/issues/1").get();
        String title = doc.title();
        System.out.println("title :"+title);
        System.out.println("----------------------------------------------------------------");
        List<Data> result = new ArrayList<Data>();
        
      
            Elements data = doc.getElementsByClass("js-timeline-item js-timeline-progressive-focus-container");
            for (int i = 1; i<data.size(); i++){
            Elements content = data.get(i).getElementsByTag("p");
                for (int j=0; j<content.size(); j++){
                
                String ResultMatric = null;
                Pattern Matric = Pattern.compile("(\\d{6})");
                Matcher matricNo = Matric.matcher(content.get(j).text());
                
                Pattern Matric1 = Pattern.compile("(\\d{5})");
                Matcher matricNo1 = Matric1.matcher(content.get(j).text());
                if(matricNo.find()){
                System.out.print(i+" "+" Matric No: "+ matricNo.group());
                ResultMatric = matricNo.group();
                }
                else if(matricNo1.find()){
                System.out.print(i+" "+" Matric No: "+ matricNo1.group());
                ResultMatric = matricNo1.group();
                }
                else{
                    System.out.print(" ");
                }
                
                String NameResult = null;
                Pattern Name1 = Pattern.compile("(Name)(.*)(Matric)");
                Matcher NamePerson1 = Name1.matcher(content.get(j).text());
                
                Pattern Name2 = Pattern.compile("(name)(.*)(link)");
                Matcher NamePerson2 = Name2.matcher(content.get(j).text());
                
                Pattern Name3 = Pattern.compile("(Name)(.*)(Link)");
                Matcher NamePerson3 = Name3.matcher(content.get(j).text());
                if (NamePerson1.find()){
                    System.out.print(" Name "+NamePerson1.group(2));
                    NameResult = NamePerson1.group(2);
                }
                else if(NamePerson2.find()){
                    System.out.print(" Name "+NamePerson2.group(2));
                       NameResult = NamePerson2.group(2);
                }
                else if(NamePerson3.find()){
                        System.out.print(" Name "+NamePerson3.group(2));  
                        NameResult = NamePerson3.group(2);
                        }
                else{
                     System.out.print(" ");  
                }
                
                Pattern Link = Pattern.compile("https://.*");
                Matcher Githublink = Link.matcher(content.get(j).text());
                
                if(Githublink.find()){
                        System.out.println(" Link "+Githublink.group());  
                        }
                else{
                     System.out.print(" ");  
                 }
                
                 result.add(new Data(ResultMatric, NameResult, Githublink.group()));
                }
            }
            return result;

            }catch (Exception e){
           return null;
            }
        
        
    }

    
}
                
        
        
        

    
         

           
            
        
    


  

       
    


