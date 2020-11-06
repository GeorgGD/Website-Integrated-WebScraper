package com.wiw.core.webscraper;

import org.openqa.selenium.WebDriverException;

/**
 * This class is meant for when an attempt to navigate to a given url leads nowhere.
 * It can also be used for when a user doesn't provide a URL. 
 * Either way you, the user of this exception must specify how this exception is used 
 * in your the error message!
 * @author Georgios Davakos
 * @since 2020-11-05
 */
public class URLNotFoundException extends Exception {

	private String errorMsg;
	private WebDriverException webDriverException;
	
	private static final long serialVersionUID = 1L;

	public URLNotFoundException(String msg) {
		this.errorMsg = msg;
	}
	
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
