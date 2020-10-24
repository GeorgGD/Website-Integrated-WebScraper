package com.wiw.core.webscraper;

import org.openqa.selenium.WebDriver;
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
	public void parse() {
		// TODO Auto-generated method stub		
	}
	
}
