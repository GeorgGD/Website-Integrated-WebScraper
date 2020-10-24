package com.wiw.core.webscraper;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public interface Webscraper{
    
	void goToUrl(String url);

	String scrapElement(By identifier);

	void closeBrowser();
}
