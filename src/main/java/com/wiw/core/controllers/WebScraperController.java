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

	@RequestMapping("scrap")
	public ModelAndView scrap(@RequestParam("url") String url, @RequestParam("scrapBy") String byident) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("");
		mav.addObject("result", null);

		return mav;
	}
}
