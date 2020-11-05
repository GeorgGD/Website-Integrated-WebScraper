package com.wiw.core.webscraper;

import org.openqa.selenium.WebDriverException;

public class URLNotFoundException extends Exception {

	private String errorMsg;
	private WebDriverException webDriverException;
	
	private static final long serialVersionUID = 1L;

	public URLNotFoundException(String msg, WebDriverException e) {
		this.errorMsg = msg;
		this.webDriverException = e;
	}

	public WebDriverException getWebDriverException() {
		return webDriverException;
	}

	@Override
	public String toString() {
		return errorMsg;
	}
}
