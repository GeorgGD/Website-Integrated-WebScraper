package com.wiw.core.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebScraperController {

	public ModelAndView scrap(@RequestParam("url") String url, @RequestParam("scrapBy") String byident) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("");
		mav.addObject("result", null);

		return mav;
	}
}
