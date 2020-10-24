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

	public void setWebDriver(WebDriver webDriver) {
		HTMLParser.webDriver = webDriver;
	}
	
	@Override
	public void goToUrl(String url) {
		webDriver.get(url);
	}

    public String scrapElemById(String elem) {
		By id = By.id(elem);
		WebElement element = webDriver.findElement(id);
		
		if(element.isSelected()) {
			return element.getText();
		}
		
		return null;
	}
}
