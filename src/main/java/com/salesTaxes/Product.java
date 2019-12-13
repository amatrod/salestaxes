package com.salesTaxes;

import com.salesTaxes.util.ExemptProducts;
import com.salesTaxes.util.Taxes;
import com.salesTaxes.util.RoundUp;

public class Product {
	
	/* ATTRIBUTES */
	
	private String name;
	private Double price;
	private Double basicTax;
	private Double importDuty;
	private String type;
	
	
	/* CONSTRUCTOR */
	
	public Product(String name, Double price, String type, Boolean imports) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.basicTax = ExemptProducts.EXEMPTPRODS.contains(type)? 0.0 : Taxes.BASIC;
		this.importDuty = imports ? Taxes.IMPORT : 0.0;
	}
	
	/* GETTERS & SETTERS */
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getBasicTax() {
		return basicTax;
	}
	
	public void setBasicTax(Double basicTax) {
		this.basicTax = basicTax;
	}
	
	public Double getImportDuty() {
		return importDuty;
	}
	
	public void setImportDuty(Double importDuty) {
		this.importDuty = importDuty;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
	/* METHODS */
	

	public Double getBasicTaxValue () {
		
		return RoundUp.round(this.price * this.basicTax / 100);
		
	}

	public Double getImportDutyValue () {
		
		return RoundUp.round(this.price * this.importDuty / 100);
		
	}

	public Double getFinalPrice () {
		
		return RoundUp.roundRest(this.price + this.getBasicTaxValue() + this.getImportDutyValue());
		
	}
	
}
