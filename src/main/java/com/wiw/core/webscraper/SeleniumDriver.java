package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	 */
	@Override
	public void goToUrl(String url) {
		webDriver.get(url);
	}

	/**
	 * Finds the element with the given identifier and 
	 * collects the contents inside the element
	 * @param identifier The identifier to use 
	 * @return The contents inside the element	
	 */
	@Override
    public String scrapElement(By identifier) {
		WebElement element = webDriver.findElement(identifier);
		
		if(element.isSelected()) {
			return element.getText();
		}
		
		return null;
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
}