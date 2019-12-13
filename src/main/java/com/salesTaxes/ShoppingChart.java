package com.salesTaxes;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.salesTaxes.util.RoundUp;

public class ShoppingChart {
	
	/* ATTRIBUTES */
	
	private LinkedHashMap<Product,Integer> shoppingChart;
	
	
	/* CONSTRUCTOR */
	
	public ShoppingChart() {
		super();
		this.shoppingChart = new LinkedHashMap<Product,Integer>();
	}
	
	
	/* GETTERS & SETTERS */

	public LinkedHashMap<Product, Integer> getShoppingChart() {
		return shoppingChart;
	}

	public void setShoppingChart(LinkedHashMap<Product, Integer> shoppingChart) {
		this.shoppingChart = shoppingChart;
	}
	
	
	/* METHODS */
	
	public Double getChartTaxes() {
		
		Double taxes = 0.0;

		for (Entry<Product,Integer> e : this.shoppingChart.entrySet()) {
			
			taxes = (RoundUp.roundRest(taxes + e.getKey().getBasicTaxValue() + e.getKey().getImportDutyValue()) * e.getValue());
			
		}
		
		return taxes;
	}
	
	public Double printResults() {
		
		Double total = 0.0;
		Double total_product = 0.0; 
		
		System.out.println("-------------------------------"); 
		
		for (Entry<Product,Integer> e : this.shoppingChart.entrySet()) {
			
			total_product = (e.getKey().getFinalPrice() * e.getValue());
			System.out.println(e.getValue() + " " + e.getKey().getName() + " : " + total_product);
			total = RoundUp.roundRest(total + total_product);
			
		}
		
		System.out.println("Sales taxes: " + getChartTaxes());
		System.out.println("Total: " + total); 
		
		System.out.println("-------------------------------"); 
		
		return total;
		
	}

}
