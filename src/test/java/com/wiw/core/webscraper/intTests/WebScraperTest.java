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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfig.class)
public class WebScraperTest {

	@Autowired
	private WebScraper webScraper;

	private ExtentReports extentReport;
	
	private ExtentSparkReporter spark;
	private ExtentTest exTestCase;
	
	@Before
	@Order(1)
	public void extentReportSetup() {
		extentReport = new ExtentReports();
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
		//extentReport.flush();
	}
	
	@Test
	public void goToUrlTest() {
		exTestCase = extentReport.createTest("Go To URL Test", "Goes to the given website");
		String expectedUrl;
		String url = "";
		try {
			expectedUrl = "https://www.georgiosdavakos.se";
			webScraper.goToUrl(expectedUrl);
			url = webScraper.currentLocation();
			expectedUrl = expectedUrl + "/";
			assertEquals(expectedUrl, url);
			exTestCase.log(Status.PASS, "Navigated to the correct url");
			exTestCase.pass("Passed");
			extentReport.flush();
		} catch (AssertionError e) {
			exTestCase.log(Status.FAIL, "Failed to navigate to " + url);
			exTestCase.log(Status.INFO, "Assertion error " + e);
			exTestCase.fail("Failed");
			extentReport.flush();
			throw new AssertionError(e);
		}

	}
    
	/*	@Test
	public void scrapElemByIdTest() {
		exTestCase = extentReport.createTest("Test 2");
		String id = "h-Braattvetaomriskerochavkastning";
		String expectedText = "Bra att veta om risker och avkastning.";
		String url = "https://www.nordnet.se/se";
		webScraper.goToUrl(url);
		String actualText = webScraper.scrapElemById(id);
		assertEquals(expectedText, actualText);
		exTestCase.pass("PASSED");
		extentReport.flush();
		}*/
}
