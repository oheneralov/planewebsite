package com.webplane.cucumber;
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.webplane.cucumber.Config;
import com.webplane.cucumber.HomePage;

import cucumber.annotation.en.Given; 
import cucumber.annotation.en.Then; 
import cucumber.annotation.en.When; 

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class cucumberJava 
    
{
	WebDriver driver = null;
	 HomePage homepage = null;

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( cucumberJava.class );
    }
    
    public void setUp() throws Exception {
    	System.setProperty("webdriver.gecko.driver", "C://alex//selenium//geckodriver-v0.18.0-win64//geckodriver.exe");
		driver = new ChromeDriver();
    }
    
    @Given("^I have open the browser and main page$")
    public void openMainPage() {
    	homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.open(driver, Config.baseURL);
    }

    @Then ("^baseURL should be http://localhost:8080/simulator$")
    public void testMainPage()
    {
    	if(Config.baseURL == homepage.getCurrentUrl()) { 
            System.out.println("Test 1 Pass"); 
         } else { 
            System.out.println("Test 1 Fail"); 
         } 
       
    }
    
    public void tearDown() {
    	driver.quit();
    }
}
