package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	//1. Private By locators: Page objects
	private By firstname= By.id("input-email");
	private By password= By.id("input-password");
	private By loginBtn= By.xpath("//input[@value='Login']");
	private By forgotPwdLink= By.linkText("Forgotten Password");
	private By logo = By.cssSelector("img.img-responsive");
	
	//2. public page Constant
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	//3. public page Actions/Methods
	public String getLoginPageTitle() {
		String title= driver.getTitle(); 
		System.out.println("Login Page title: "+title);
		return title;
	}
	public String getLoginPageURL() {
		String url=driver.getCurrentUrl();
		System.out.println("Login Page URL: "+url);
		return url;
	}
	public boolean forgotPasswordlinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
		}
	public boolean isLogoExist() {
		return eleUtil.isElementDisplayed(logo);		
	}

	public String doLogin(String userName, String pwd) {
		driver.findElement(firstname).sendKeys(userName);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		String accPageTitle= driver.getTitle();
		System.out.println("Acc Page title: "+accPageTitle);
		return accPageTitle;
		
	}
	
	

}
