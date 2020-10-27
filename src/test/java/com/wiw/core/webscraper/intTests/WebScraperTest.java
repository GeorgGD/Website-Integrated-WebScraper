package com.wiw.core.webscraper.intTests;

import com.wiw.core.webscraper.WebScraper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.springConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class WebScraperTest {

	@Autowired
	private WebScraper webScraper;

	@Before
	@Order(2)
	public void setup() {
		webScraper.setDriver();
	}

	@Before
	@Order(1)
	@Test
	public void springAutowiredTest() {
		assertNotNull(webScraper);
		webScraper.closeDriver();
	}

	
}
