package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebScraper {

	@Autowired
	private DriverManager driverManager;
    	
	public WebScraper() {
		setDriver();
	}
	
	private ChromeOptions setupOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless",
							 "--disable-gpu",
							 "--window-size=1920,1080",
							 "--ignore-certificate-errors");
		return options;
	}

	private WebDriver setupWebDriver(ChromeOptions options) {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver(options);		
		return driver;
	}

	public void setDriver() {
		ChromeOptions options = setupOptions();
		WebDriver driver = setupWebDriver(options);
		driverManager.setWebDriver(driver);
	}

	public String scrapElemById(String name) {
		By identifier = By.id(name);
		String content = driverManager.scrapElement(identifier);		
		return content;
	}
}
