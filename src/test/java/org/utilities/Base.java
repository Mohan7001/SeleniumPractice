package org.utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class Base {
	protected WebDriver driver;
	
	public WebDriver edgeSetup(String url){
		System.setProperty("webdriver.edge.driver","C:\\Program Files\\Drivers\\msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
	}
	public WebDriver chromeSetup(String url){
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
//		 Map<String, Object> prefs = new HashMap<>();
//	        prefs.put("credentials_enable_service", false);
//	        prefs.put("profile.password_manager_enabled", false);
//
//	        options.setExperimentalOption("prefs", prefs);
//	        options.addArguments("--incognito"); //
		driver=new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
		
		
	}
	
	public void browserTearDown() {
		if(driver!=null) {
		driver.close();
	}
	}

}
