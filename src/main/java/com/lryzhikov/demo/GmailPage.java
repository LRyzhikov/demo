package com.lryzhikov.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPage
{
	private final static String URL = "http://gmail.com";
	
	@FindBy(id = "identifierId")
	private WebElement emailTextField;

	@FindBy(name = "password")
	private WebElement passwordTextField;

	@FindBy(id = "identifierNext")
	private WebElement nextButton;

	@FindBy(xpath = "//a[contains(@class, 'gb_b') and contains(@title, 'Google Account')]")
	private WebElement userIcon;

	public void open(WebDriver driver)
	{
		driver.get(URL);
	}
	
	public void login(String email, String password)
	{
		emailTextField.sendKeys(email);
		nextButton.click();
		passwordTextField.sendKeys(password);
		nextButton.click();
	}
	
	public boolean isLogged()
	{
		return userIcon.isDisplayed();
	}
}
