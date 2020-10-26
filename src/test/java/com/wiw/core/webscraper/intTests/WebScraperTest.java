package com.wiw.core.webscraper.intTests;

import com.wiw.core.webscraper.WebScraper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import config.springConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../../main/java/config/", classes = springConfig.class, loader = AnnotationConfigContextLoader.class)
public class WebScraperTest {

	@Autowired
	private WebScraper webScraper;

	@Before
	public void setup() {
		webScraper.setDriver();
	}
	
	@Test
	public void setDriverTest() {
		assertNull(webScraper);
	}
}
