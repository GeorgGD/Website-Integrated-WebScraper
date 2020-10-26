package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

/**
 * Class for 
 */
@Component
class SeleniumDriver implements DriverManager{
	
	private static WebDriver webDriver;
	
	public SeleniumDriver() {
	}

	@Override
	public void setWebDriver(WebDriver webDriver) {
		SeleniumDriver.webDriver = webDriver;
	}
	
	@Override
	public void goToUrl(String url) {
		webDriver.get(url);
	}

	@Override
    public String scrapElement(By identifier) {
		WebElement element = webDriver.findElement(identifier);
		
		if(element.isSelected()) {
			return element.getText();
		}
		
		return null;
	}

	@Override
	public void closeBrowser() {
		if(webDriver != null) {
			webDriver.quit();
		}
	}
}
