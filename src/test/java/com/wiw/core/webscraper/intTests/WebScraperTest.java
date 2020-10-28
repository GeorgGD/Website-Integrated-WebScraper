package com.wiw.core.webscraper.intTests;

import com.wiw.core.webscraper.WebScraper;

import config.springConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class WebScraperTest {

	@Autowired
	private WebScraper webScraper;

	@Autowired
	ExtentReports extentReport;
	
	ExtentSparkReporter spark;

	@Before
	@Order(1)
	public void extentReportSetup() {
		spark = new ExtentSparkReporter("./extentReport.html");
	   extentReport.attachReporter(spark);
	}
	
	@Before
	@Order(3)
	public void setup() {
		webScraper.setDriver();
	}

	@Before
	@Order(2)
	@Test
	public void springAutowiredTest() {
		assertNotNull(webScraper);
	}

	@After
	public void closeDriver() {
		webScraper.closeDriver();
	}

	@After
	public void createExtentReportPage() {
		extentReport.flush();
	}
	
	@Test
	public void goToUrlTest() {
		String expectedUrl = "https://www.georgiosdavakos.se";
		webScraper.goToUrl(expectedUrl);
		String url = webScraper.currentLocation();
		expectedUrl = expectedUrl + "/";
		assertEquals(expectedUrl, url);
	}

	@Test
	public void scrapElemByIdTest() {
		String id = "h-Braattvetaomriskerochavkastning";
		String expectedText = "Bra att veta om risker och avkastning.";
		String url = "https://www.nordnet.se/se";
		webScraper.goToUrl(url);
		String actualText = webScraper.scrapElemById(id);
		assertEquals(expectedText, actualText);
	}
}
