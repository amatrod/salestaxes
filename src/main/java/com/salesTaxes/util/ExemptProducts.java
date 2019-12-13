package com.salesTaxes.util;

import java.util.ArrayList;

public class ExemptProducts {
	
    public final static ArrayList<String> EXEMPTPRODS = new ArrayList<String>();
    static {
    	EXEMPTPRODS.add("book");
    	EXEMPTPRODS.add("food");
    	EXEMPTPRODS.add("medical");
	}

    public ArrayList<String> getExemptProducts() {

    	return EXEMPTPRODS;
    
    }

}
