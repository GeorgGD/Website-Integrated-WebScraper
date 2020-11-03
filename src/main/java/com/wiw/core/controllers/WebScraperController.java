package com.wiw.core.controllers;

import com.wiw.core.webscraper.WebScraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebScraperController {

	@Autowired
	private WebScraper webScraper;

	/*
	 * 1. Navigate to the url
	 * 2. Figure out which scrapBy method to use
	 * 3. Scrap the element
	 * 4. Return the scraped element
	 */
	@RequestMapping("scrap")
	public ModelAndView scrap(@RequestParam("url") String url, @RequestParam("scrapBy") String byIdent, @RequestParam("attributeName") String attributeName) {
		if(!webScraper.hasDriverSetup())
			webScraper.setDriver();

		// handle url not found exception!
		webScraper.goToUrl(url);
		String scrapedStr = whichByIdent(byIdent, attributeName);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webIntegratedScraper");
		mav.addObject("scrapResult", scrapedStr);

		return mav;
	}
}
