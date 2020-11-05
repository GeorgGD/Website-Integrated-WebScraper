package com.wiw.core.webscraper;

import org.openqa.selenium.WebDriverException;

/**
 * This class is meant for when an attempt to navigate to a given url leads nowhere
 * @author Georgios Davakos
 * @since 2020-11-05
 */
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
