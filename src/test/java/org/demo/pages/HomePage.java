package org.demo.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']/ancestor::div[@class='inventory_item']//button") /*
																												 * div[
																												 * text(
																												 * )='
																												 * Test.
																												 * allTheThings
																												 * () T-
																												 * Shirt
																												 * (Red)
																												 * ']/*
																												 * ancestor
																												 * ::div
																												 * [@
																												 * class
																												 * ='
																												 * inventory_item_label
																												 * ']/
																												 * following
																												 * -
																												 * sibling
																												 * ::div
																												 * //
																												 * child
																												 * ::
																												 * button
																												 */
	WebElement addtoCardButton;
	@FindBy(xpath = "//div[@id='shopping_cart_container']/child::a//child::span")
	WebElement cartBadge;

	@FindBy(xpath ="//div[@class='inventory_item_name']")
	List<WebElement> allItems;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verify_login() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actual = productsLabel.getText();
		
		String expected = "Products";
		Assert.assertEquals(actual, expected, "Unable to login");
		System.out.println("Logged in");
	}

	public void logOut() {
		openMenuButton.click();
		logoutLink.click();
	}

	public void additemToCart() {
		
		for (WebElement name : allItems) {
			
			System.out.println(name.getText());
			driver.findElement(By.xpath("//div[text()='" + name.getText() + "']/ancestor::div[@class='inventory_item']//button")).click();
		}
	
		

	}

	public boolean isProductAddedToCart() {

		return cartBadge.isDisplayed();
	}

	public String getCartItemCount() {
		return cartBadge.getText();

	}

}
