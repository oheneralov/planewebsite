package com.webplane.webplane;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	WebDriver driver = null;
	HomePage homePage;
	SimulatorPage simulatorPage;
	TheoryPage theoryPage;

	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "C://alex//selenium//geckodriver-v0.18.0-win64//geckodriver.exe");
		driver = new FirefoxDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		simulatorPage = PageFactory.initElements(driver, SimulatorPage.class);
		theoryPage = PageFactory.initElements(driver, TheoryPage.class);
	}

	public void testMainPageLinks() {
		homePage.open(driver, Config.HomePage.baseURL);
		assertEquals(Config.HomePage.baseURL, homePage.getCurrentUrl());
		assertEquals("Home", homePage.getTitle());
		checkTopMenu(homePage);
		// click on the Home link
		homePage.getHomeTopLink().click();
		checkTopMenu(homePage);
	}

	public void testMainPageContent() {
		homePage.open(driver, Config.HomePage.baseURL);
		assertEquals(Config.HomePage.content, homePage.getContent());
	}

	/**
	 * Open home page, click on simulator top link and check if no errors
	 */
	public void testSimulatorPageLinks() {
		simulatorPage.open(driver, Config.HomePage.baseURL);
		// click on the simulator link
		simulatorPage.getSimulatorTopLink().click();
		assertEquals(Config.SimulatorPage.baseURL, simulatorPage.getCurrentUrl());
		assertEquals("simulator", simulatorPage.getTitle());
		checkTopMenu(simulatorPage);
	}

	public void testSimulatorPageContent() {
		simulatorPage.open(driver, Config.SimulatorPage.baseURL);
		assertEquals(Config.SimulatorPage.content, simulatorPage.getContent());
	}
	
	/**
	 * Open home page, click on theory top link and check if no errors
	 */
	public void testTheoryPageLinks() {
		theoryPage.open(driver, Config.HomePage.baseURL);
		// click on the simulator link
		theoryPage.getTheoryTopLink().click();
		assertEquals(Config.TheoryPage.baseURL, theoryPage.getCurrentUrl());
		assertEquals("theory", theoryPage.getTitle());
		checkTopMenu(theoryPage);
	}

	public void testTheoryPageContent() {
		theoryPage.open(driver, Config.TheoryPage.baseURL);
		assertEquals(Config.TheoryPage.content, theoryPage.getContent());
	}

	private void checkTopMenu(DriverUtils page) {
		assertEquals(Config.Menu.homeTopLinkText, page.getHomeTopLink().getText());
		assertEquals(Config.Menu.simulatorTopLinkText, page.getSimulatorTopLink().getText());
		assertEquals(Config.Menu.theoryTopLinkText, page.getTheoryTopLink().getText());
		// testing links url
		assertEquals(Config.Menu.homeTopLinkURL, page.getHomeTopLink().getAttribute("href"));
		assertEquals(Config.Menu.simulatorTopLinkURL, page.getSimulatorTopLink().getAttribute("href"));
		assertEquals(Config.Menu.theoryTopLinkURL, page.getTheoryTopLink().getAttribute("href"));
	}

	public void tearDown() {
		driver.quit();
	}
}
