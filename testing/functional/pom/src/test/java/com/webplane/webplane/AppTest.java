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

    /**
     * Rigourous Test :-)
     */
    public void testMainPage()
    {
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.open(driver, Config.baseURL);
        assertEquals(Config.baseURL, homepage.getCurrentUrl());
        assertEquals("", homepage.getTitle());
    }
    
    public void tearDown() {
    	driver.quit();
    }
}
