package com.lryzhikov.demo;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EbayPage
{
	private final static String URL = "http://www.ebay.com";
	
	@FindBy(id = "gh-ac")
	private WebElement searchTextField;
	
	@FindBy(id = "gh-btn")
	private WebElement searchBtn;

	@FindBy(xpath = "//ul[@id='ListViewInner']//h3/a")
	private List<WebElement> itemLinks;
	
	@FindBy(id = "prcIsum")
	private WebElement priceLabel;

	public void open(WebDriver driver)
	{
		driver.get(URL);
	}

	public void search(String itemName)
	{
		searchTextField.sendKeys(itemName);
		searchBtn.click();

	}

	public String getItemPrice(int itemIndex)
	{
		itemLinks.get(itemIndex).click();
		return priceLabel.getText();
	};
}
