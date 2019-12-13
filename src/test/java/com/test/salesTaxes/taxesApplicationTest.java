package com.test.salesTaxes;

import org.junit.Assert;
import org.junit.Test;

import com.salesTaxes.Product;
import com.salesTaxes.ShoppingChart;

public class taxesApplicationTest {
	
	private Product book1 = new Product("big_book", 15.0, "book", false);
	private Product flowers1 = new Product("blue_flowers", 14.99, "flowers", true);
	
	
	@Test
	public void exemptBasicTaxApplicableIs0() {

		Assert.assertEquals(Double.valueOf(0), book1.getBasicTax());
		
	}
	
	@Test
	public void notExemptBasicTaxApplicableIs10() {
		
		Assert.assertEquals(Double.valueOf(10),flowers1.getBasicTax());
		
	}
	
	@Test
	public void importTaxApplicableIs5() {
		
		Assert.assertEquals(Double.valueOf(5),flowers1.getImportDuty());
		
	}
	
	@Test
	public void notImportTaxApplicableIs0() {
		
		Assert.assertEquals(Double.valueOf(0),book1.getImportDuty());
		
	}
	
	@Test
	public void checkBasicTaxesAppliedExempt() {
		
		Assert.assertEquals(Double.valueOf(0),book1.getBasicTaxValue());
		
	}
	
	@Test
	public void checkBasicTaxesApplied() {

		Assert.assertEquals(Double.valueOf(1.5),flowers1.getBasicTaxValue());
		
	}
	
	@Test
	public void checkImportDutyAppliedExempt() {
		
		Assert.assertEquals(Double.valueOf(0),book1.getImportDutyValue());
		
	}
	
	@Test
	public void checkImportDutyApplied() {

		Assert.assertEquals(Double.valueOf(0.75),flowers1.getImportDutyValue());
		
	}
	
	@Test
	public void checkChartSalesTaxes() {
		
		Product book = new Product("book", 12.49, "book", false);
		Product music = new Product("music CD", 14.99, "music", false);
		ShoppingChart chart = new ShoppingChart();
		chart.getShoppingChart().put(book, 1);
		chart.getShoppingChart().put(music, 1);

		Assert.assertEquals(Double.valueOf(1.50),chart.getChartTaxes());
		
	}
	
	@Test
	public void checkChartTotal() {
		
		Product book = new Product("book", 12.49, "book", false);
		Product music = new Product("music CD", 14.99, "music", false);
		ShoppingChart chart = new ShoppingChart();
		chart.getShoppingChart().put(book, 2);
		chart.getShoppingChart().put(music, 7);

		Assert.assertEquals(Double.valueOf(140.41),chart.printResults());
		
	}
	
	@Test
	public void checkInput1() {
		
		Product book = new Product("book", 12.49, "book", false);
		Product music = new Product("music CD", 14.99, "music", false);
		Product chocolate = new Product("chocolate bar", 0.85, "food", false);
		ShoppingChart chart = new ShoppingChart();
		chart.getShoppingChart().put(book, 1);
		chart.getShoppingChart().put(music, 1);
		chart.getShoppingChart().put(chocolate, 1);

		Assert.assertEquals(Double.valueOf(29.83),chart.printResults());
		
	}
	
	@Test
	public void checkInput2() {
		
		Product chocolate = new Product("imported box of chocolates", 10.00, "food", true);
		Product perfume = new Product("imported bottle of perfume", 47.50, "perfume", true);
		ShoppingChart chart = new ShoppingChart();
		chart.getShoppingChart().put(chocolate, 1);
		chart.getShoppingChart().put(perfume, 1);

		Assert.assertEquals(Double.valueOf(65.15),chart.printResults());
		
	}
	
	@Test
	public void checkInput3() {
		
		Product perfume = new Product("imported bottle of perfume", 27.99, "perfume", true);
		Product perfume2 = new Product("bottle of perfume", 18.99, "perfume", false);
		Product pills = new Product("packet of headache pills", 9.75, "medical", false);
		Product chocolate = new Product("box of imported chocolates", 11.25, "food", true);
		
		ShoppingChart chart = new ShoppingChart();
		chart.getShoppingChart().put(perfume, 1);
		chart.getShoppingChart().put(perfume2, 1);
		chart.getShoppingChart().put(pills, 1);
		chart.getShoppingChart().put(chocolate, 1);

		Assert.assertEquals(Double.valueOf(74.68),chart.printResults());
		
	}
	
	

	
	

}
