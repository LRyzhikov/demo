package com.lryzhikov.demo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.lryzhikov.demo.GmailPage;

public class GmailTest
{
	private static final String EMAIL = "<my_pswd>";
	private static final String PASSWORD = "<my_pswd>";

	private WebDriver driver;

	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
	}

	@Test
	public void testGmailLogin()
	{
		GmailPage gmailPage = PageFactory.initElements(driver, GmailPage.class);
		gmailPage.open(driver);
		gmailPage.login(EMAIL, PASSWORD);
		Assert.assertTrue(gmailPage.isLogged(), "User is not logged!");
	}

	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
}
