package org.demo.tests;

import org.demo.pages.HomePage;
import org.demo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utilities.Base;

public class LoginTest extends Base {

	
	@BeforeClass
	public void setUp(){
	driver=chromeSetup("https://www.saucedemo.com/v1/");
	}
	@AfterClass
	public void tearDown(){
		browserTearDown();
		
	}
	@Test
	public void login_Test() throws InterruptedException {
		LoginPage lPage  =new LoginPage(driver);
		lPage.login("standard_user", "secret_sauce");
		HomePage hPage = new HomePage(driver);
		hPage.verify_login();
		hPage.additemToCart();
	
		Assert.assertTrue(hPage.isProductAddedToCart(),"productNotAdded");
		
		System.out.println("Total items available in cart: "+hPage.getCartItemCount());hPage.getCartItemCount();
		Assert.assertEquals(hPage.getCartItemCount(),"6","productNotAdded");
	}

	

}
