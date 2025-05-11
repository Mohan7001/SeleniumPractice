package org.demo.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
private	WebDriver driver;
	@FindBy(id="user-name") WebElement userName; 
	@FindBy(id="password") WebElement passWord; 
	@FindBy(id="login-button") WebElement loginButton; 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String user , String pass){
		userName.sendKeys(user);
		passWord.sendKeys(pass);
		loginButton.click();
//		Alert alert = driver.switchTo().alert();
//		alert.accept();
	}

}
