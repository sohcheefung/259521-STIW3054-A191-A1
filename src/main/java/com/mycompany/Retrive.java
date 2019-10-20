package com.mycompany;

/**
 *
 * @author Chee Fung
 */

import java.util.*;

public class Retrive {
    private String Column1, Column2, Column3;
    
    public Retrive(String Column1, String Column2, String Column3) {
        super();
        this.Column1 = Column1;
        this.Column2 = Column2;
        this.Column3 = Column3;
        
    }
    
    public String getColumn1() {
        return Column1;
    }

    public void forColumn1(String column1) {
        this.Column1 = column1;
    }

    public String getColumn2() {
        return Column2;
    }

    public void forColumn2(String Column2) {
        this.Column2 = Column2;
    }
    
    public String getColumn3(){
        return Column3;
    }
    
    public void forColumn3(String Column3) {
        this.Column3 = Column3;
    }
}
