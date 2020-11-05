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

	@RequestMapping("/scrap")
	public ModelAndView scrap(@RequestParam("url") String url, @RequestParam("scrapBy") String byIdent, @RequestParam("attributeName") String attributeName) {
		if(!webScraper.hasDriverSetup())
			webScraper.setDriver();

		// TODO: Needs to handle url not found exception!
		webScraper.goToUrl(url);

		// TODO: Needs to handle element not found exception 
		String scrapedStr = whichByIdent(byIdent, attributeName);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webIntegratedScraper.jsp");
		mav.addObject("scrapResult", scrapedStr);

		return mav;
	}

	private String whichByIdent(String byIdent, String attributeName) {
		String scrapedStr;
		
		if(byIdent.equals("ById")) {
			scrapedStr = webScraper.scrapElemById(attributeName);
		} else if(byIdent.equals("ByName")) {
			scrapedStr = webScraper.scrapElemByName(attributeName);
		} else if(byIdent.equals("ByClass")) {
			scrapedStr = webScraper.scrapElemByClass(attributeName);
		} else {
			scrapedStr = webScraper.scrapElemByXpath(attributeName);
		}
		
		return scrapedStr;
	}
}
