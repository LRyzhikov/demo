package com.lryzhikov.demo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lryzhikov.demo.EbayPage;


public class EbayTest
{
	private static final String ITEM = "Electric Guitar";

	private WebDriver driver;

	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
	}

	@Test
	public void testEbayItemSearch()
	{
		EbayPage ebayPage = PageFactory.initElements(driver, EbayPage.class);
		ebayPage.open(driver);
		ebayPage.search(ITEM);
		System.out.println("Price of " + ITEM + " is " + ebayPage.getItemPrice(0));
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
