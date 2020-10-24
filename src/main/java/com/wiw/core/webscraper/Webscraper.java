package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

@Component
public interface Webscraper{

	void setWebDriver(WebDriver webDriver);
	
	void goToUrl(String url);

	String scrapElement(By identifier);

	void closeBrowser();
}
