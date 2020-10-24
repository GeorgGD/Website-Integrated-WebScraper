package com.wiw.core.webscraper;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WebScraper {

	@Autowired
	private DriverManager driverManager;

	private ChromeOptions setupOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless",
							 "--disable-gpu",
							 "--window-size=1920,1080",
							 "--ignore-certificate-errors");
		return options;
	}
}
