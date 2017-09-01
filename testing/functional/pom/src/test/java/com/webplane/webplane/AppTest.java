package com.webplane.webplane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	WebDriver driver = null;
	
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "C://alex//selenium//geckodriver-v0.18.0-win64//geckodriver.exe");
		driver = new FirefoxDriver();
    }

    public void testMainPage()
    {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.open(driver, Config.baseURL);
        assertEquals(Config.baseURL, homepage.getCurrentUrl());
        assertEquals("Home", homepage.getTitle());
        assertEquals(Config.homeTopLinkText, homepage.getHomeTopLink().getText());
        assertEquals(Config.simulatorTopLinkText, homepage.getSimulatorTopLink().getText());
        assertEquals(Config.theoryTopLinkText, homepage.getTheoryTopLink().getText());
        //testing link url
        assertEquals(Config.homeTopLinkURL, homepage.getHomeTopLink().getAttribute("href"));
        assertEquals(Config.simulatorTopLinkURL, homepage.getSimulatorTopLink().getAttribute("href"));
        assertEquals(Config.theoryTopLinkURL, homepage.getTheoryTopLink().getAttribute("href"));
    }
    
    public void testSimulatorPage() {
    	
    }
    
    public void tearDown() {
    	driver.quit();
    }
}
