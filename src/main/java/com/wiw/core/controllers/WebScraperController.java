package com.wiw.core.controllers;

import com.wiw.core.webscraper.URLNotFoundException;
import com.wiw.core.webscraper.WebScraper;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the website integrated web scraper
 * @author Georgios Davakos
 * @since 2020-11-05
 */
@Controller
public class WebScraperController {

	@Autowired
	private WebScraper webScraper;

	/**
	 * Scraps the desired content from the website the user provided
	 * @param url The url of the website to scrap from
	 * @param byIdent The identifier to be used for locating the desired element
	 * @param attributeName The name/value of the identifier
	 * @return A model and view holding the scraped content	
	 */
	@RequestMapping("/scrap")
	public ModelAndView scrap(@RequestParam("url") String url, @RequestParam("scrapBy") String byIdent, @RequestParam("attributeName") String attributeName) {
		if(!webScraper.hasDriverSetup())
			webScraper.setDriver();

		String scrapedStr;
		ModelAndView mav = new ModelAndView();

		if(url == null || url.equals("") || attributeName == null || attributeName.equals("")) {
			scrapedStr = "ERROR: One of the fields were left empty! \nPlease try again.";
			mav = setupModelAndView(mav, scrapedStr);
			return mav;
		}
		
		try {
			webScraper.goToUrl(url);
				
		    scrapedStr = whichByIdent(byIdent, attributeName);
			
			mav = setupModelAndView(mav, scrapedStr);
			
			return mav;
		} catch (URLNotFoundException e) {
			scrapedStr = "ERROR: The url you provided (" + url + ") was incorrect! \nPlease try again.";
			mav = setupModelAndView(mav, scrapedStr);
			return mav;
		} catch (NoSuchElementException e) {
			scrapedStr = "ERROR: Their was no element with the given attribute name! \nPlease try again.";
			mav = setupModelAndView(mav, scrapedStr);
			return mav;
		}
	}

	/**
	 * A helper function to scrap-method, sets up the model and view
	 * @param mav The model and view
	 * @param scrapedStr the string that the model and view should hold
	 * @return the modefied model and view	
	 */	
	private ModelAndView setupModelAndView(ModelAndView mav, String scrapedStr) {
		mav.setViewName("webIntegratedScraper");
		mav.addObject("scrapResult", scrapedStr);		
		return mav;
	}
	
	/**
	 * A helper function to scrap-method, scraps the website for the given 
	 * identifier and attributeName
	 * @param byIdent The identifier to be used for locating the desired element
	 * @param attributeName The name/value of the identifier
	 * @return The scraped content	
	 */
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
