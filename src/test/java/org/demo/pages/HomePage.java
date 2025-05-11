package org.demo.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	@FindBy(xpath = "//div[@class='product_label']")
	WebElement productsLabel;
	@FindBy(xpath = "//button[text()='Open Menu']")
	WebElement openMenuButton;
	@FindBy(id = "logout_sidebar_link")
	WebElement logoutLink;
	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//button")
	WebElement addtoCardButton;
	@FindBy(xpath = "//div[@id='shopping_cart_container']/child::a//child::span")
WebElement cartBadge;
	
	
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verify_login() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actual = productsLabel.getText();
		System.out.println(actual);
		String expected = "Products";
		Assert.assertEquals(actual, expected, "Unable to login");
		System.out.println("Logged in");
	}
	public void logOut(){
		openMenuButton.click();
		logoutLink.click();
	}
	public void additemToCart() throws InterruptedException{
		Thread.sleep(2000);
		addtoCardButton.click();
	}
	public boolean isProductAddedToCart() throws InterruptedException{
		Thread.sleep(5000);
		return cartBadge.isDisplayed();
	}
	public String getCartItemCount(){
		return cartBadge.getText();
			
		
	}
	
}
