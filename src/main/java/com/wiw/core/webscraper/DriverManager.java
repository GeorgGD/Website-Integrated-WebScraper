package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

/**
 * Main interface for all classes implementing a WebDriver solution
 * @author Georgios Davakos
 * @since 2020-10-26
 */
@Component
public interface DriverManager{

	/**
	 * Assigns the webDriver value
	 * @param webDriver The webdriver to use	
	 */
	void setWebDriver(WebDriver webDriver);

	/**
	 * Takes the driver to the given url
	 * @param url The url to use	
	 * @throws URLNotFoundException when url doesn't lead to a website
	 */
	void goToUrl(String url) throws URLNotFoundException;

	/**
	 * Locates the element with the given identifier and 
	 * collects the contents inside the element
	 * @param identifier The identifier to use 
	 * @return The contents inside the element	
	 */
	String scrapElement(By identifier);

	/**
	 * Shuts down the driver 
	 */
	void closeBrowser();

	/**
	 * Provides the current url that the driver is at the moment
	 * @return The current url
	 */	
	String currentUrl();
}
