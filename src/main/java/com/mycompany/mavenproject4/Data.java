package com.mycompany.mavenproject4;

/**
 *
 * @author Chee Fung
 */

import java.util.*;

public class Data {
    private int num;
    private String column1, column2, column3;

    public Data(){
        super();
    }

    public Data(String column1, String column2, String column3) {
        super();
        //this.num = num;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }
    
    public String getColumn3(){
        return column3;
    }
    
    public void setColumn3(String column3) {
        this.column3 = column3;
    }
}
