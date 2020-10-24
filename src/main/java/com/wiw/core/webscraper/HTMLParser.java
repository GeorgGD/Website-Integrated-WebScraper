package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class HTMLParser implements Webscraper{
	
	private static WebDriver webDriver;
	
	public HTMLParser() {
	}

	@Override
	public void setWebDriver(WebDriver webDriver) {
		HTMLParser.webDriver = webDriver;
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
