package com.wiw.core.webscraper;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Class meant for scraping data from websites
 * @author Georgios Davakos
 * @since 2020-10-26
 */
@Component
public class WebScraper {

	@Autowired
	private DriverManager driverManager;

	private boolean hasDriver = false;
	
	/**
	 * Assigns the given value to driverManager 
	 * @param driverManager The manager for the web scraper	
	 */	
	public void setDriverManager(DriverManager driverManager) {
		if(driverManager == null)
			return;
		
		if(this.driverManager != null)
			this.driverManager.closeBrowser();
			
		this.driverManager = driverManager;
		this.hasDriver = true;
	}
	
	/**
	 * Sets up the options for the chrome driver
	 * @return The chrome driver options
	 */
	private ChromeOptions setupOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless",
							 "--disable-gpu",
							 "--window-size=1920,1080",
							 "--ignore-certificate-errors");
		options.setBinary("/usr/bin/google-chrome");
		return options;
	}

	/**
	 * Sets up the web driver with the given options
	 * @param options The desired options for the web driver
	 * @return The web driver	
	 */
	private WebDriver setupWebDriver(ChromeOptions options) {
		File file = new File(getClass().getClassLoader().getResource("/chromedriver").getFile());
		String path = file.getPath();
		
		System.setProperty("webdriver.chrome.driver", path);
		WebDriver driver = new ChromeDriver(options);		
		return driver;
	}

	/**
	 * Provides driverManager with a web driver	
	 */
	public void setDriver() {
		ChromeOptions options = setupOptions();
		WebDriver driver = setupWebDriver(options);
		driverManager.setWebDriver(driver);
		this.hasDriver = true;
	}

	/**
	 * Takes web driver to the given url	
	 * @param url The desired url
	 * @throws URLNotFoundException when url doesn't lead to a website
	 */	
	public void goToUrl(String url) throws URLNotFoundException {
		if(hasDriver)
			driverManager.goToUrl(url);
	}
	
	/**
	 * Collects the contents of the element with the given identifier
	 * @param name The name of the identifier
	 * @return The contents of the element	
	 */
	public String scrapElemById(String name) {
		By identifier = By.id(name);
		String content = driverManager.scrapElement(identifier);		
		return content;
	}

	/**
	 * Collects the contents of the element with the given identifier
	 * @param name The name of the identifier
	 * @return The contents of the element	
	 */
	public String scrapElemByName(String name) {
		By identifier = By.name(name);
		String content = driverManager.scrapElement(identifier);
		return content;
	}

	/**
	 * Collects the contents of the element with the given identifier
	 * @param name The name of the identifier
	 * @return The contents of the element	
	 */
	public String scrapElemByClass(String name) {
		By identifier = By.className(name);
		String content = driverManager.scrapElement(identifier);
		return content;
	}

	/**
	 * Collects the contents of the element with the given identifier
	 * @param name The name of the identifier
	 * @return The contents of the element	
	 */
	public String scrapElemByXpath(String name) {
		By identifier = By.xpath(name);
		String content = driverManager.scrapElement(identifier);
		return content;
	}

	/**
	 * Shuts down the web driver
	 */
	public void closeDriver() {
		driverManager.closeBrowser();
		this.hasDriver = false;
	}

	/**
	 * Provides the current url that the driver is at the moment
	 * @return The current url
	 */
	public String currentLocation() {
		String url = driverManager.currentUrl();
		return url;
	}

	/**
	 * Checks if driver has been setup
	 * @return True if driver has been setup	
	 */
	public boolean hasDriverSetup() {		
		return this.hasDriver;
	}
}
