package com.wiw.core.webscraper;

import org.springframework.stereotype.Component;

@Component
public interface Webscraper{
	
	void parse();

	void goToUrl(String url);
}
