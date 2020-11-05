package com.wiw.core.webscraper.controllerTest;

import config.SpringConfig;

import static org.junit.Assert.assertEquals;

import com.wiw.core.controllers.WebScraperController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ScrapContTest {

	@Autowired
	private WebScraperController webController;

	@Test
	public void scrapTest() {
		String expectedText = "Built for developers";
		String url = "http://github.com";
		String attributeName = "/html[1]/body[1]/div[4]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]";
		ModelAndView mav = webController.scrap(url, "By Xpath", attributeName);

		String actualText = (String) mav.getModelMap().getAttribute("scrapResult");
		assertEquals(expectedText, actualText);
	}
}
