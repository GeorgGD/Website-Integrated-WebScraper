package com.wiw.core.webscraper;

import org.springframework.stereotype.Component;

@Component
public interface Webscraper{
	
	HTMLParser getHtmlParser();
}
