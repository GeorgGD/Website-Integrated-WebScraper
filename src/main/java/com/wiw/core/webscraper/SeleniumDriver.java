package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Class for managing seleniums WebDriver interface
 * @author Georgios Davakos
 * @since 2020-10-26
 */
@Component
class SeleniumDriver implements DriverManager{
	
	private static WebDriver webDriver;

	public SeleniumDriver() {
	}
	
	/**
	 * Assigns the webDriver value
	 * @param webDriver The webdriver to use	
	 */
	@Override
	public void setWebDriver(WebDriver webDriver) {
		SeleniumDriver.webDriver = webDriver;
	}
	
	/**
	 * Takes the driver to the given url
	 * @param url The url to use	
	 * @throws URLNotFoundException when url doesn't lead to a website
	 */
	@Override
	public void goToUrl(String url) throws URLNotFoundException {
		try{
			webDriver.get(url);
			// TODO: Needs to handles incorrect url and when url doesn't lead to a website
		} catch (WebDriverException e) {
			// log exception...
			String msg = "Incorrect url: " + url + "\n" + e;
			throw new URLNotFoundException(msg, e);
		}
	}

	/**
	 * Locates the element with the given identifier and 
	 * collects the contents inside the element
	 * @param identifier The identifier to use 
	 * @return The contents inside the element	
	 */
	@Override
    public String scrapElement(By identifier) {	    
		WebElement element = webDriver.findElement(identifier);
		return element.getText();
   	}
	
	/**
	 * Shuts down the driver 
	 */
	@Override
	public void closeBrowser() {
		if(webDriver != null) {
			webDriver.quit();
		}
	}

	/**
	 * Provides the current url that the driver is at the moment
	 * @return The current url
	 */
	@Override
	public String currentUrl() {
		if (this.webDriver != null) {
			String url = webDriver.getCurrentUrl();
			return url;
		} else {
			return null;
		}
	}
}
