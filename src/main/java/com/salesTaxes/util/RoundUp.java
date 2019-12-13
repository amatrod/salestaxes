package com.salesTaxes.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoundUp {

	public static double round(double number) {
	    BigDecimal bigd = BigDecimal.valueOf(number);
	    bigd = bigd.setScale(2, RoundingMode.HALF_UP);
	    return Math.ceil(bigd.doubleValue() * 20)/20.0;
	}
	
	public static double roundRest(double number) {
	    BigDecimal bigd = BigDecimal.valueOf(number);
	    bigd = bigd.setScale(2, RoundingMode.HALF_UP);
	    return bigd.doubleValue();
	}
	
}
