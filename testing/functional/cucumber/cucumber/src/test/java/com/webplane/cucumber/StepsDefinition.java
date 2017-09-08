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
import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StepsDefinition 
    
{
	WebDriver driver = null;
	HomePage homePage;
	SimulatorPage simulatorPage;
	TheoryPage theoryPage;

    
    public void setUp() throws Exception {
    	
    }
    
    @Given("^I have open the browser$")
    public void openMainPage() {
    	System.setProperty("webdriver.chrome.driver", "C:\\alex\\training\\java\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		homePage = PageFactory.initElements(driver, HomePage.class);
		simulatorPage = PageFactory.initElements(driver, SimulatorPage.class);
		theoryPage = PageFactory.initElements(driver, TheoryPage.class);
    }

    
    
    
    
    @When("^I open home page$")
    public void open_home_page() {
    	homePage.open(driver, Config.HomePage.baseURL);
    }
    
    @Then("^Home page current URL, menu and title must be similar to ones from config$")
    public void testMainPageLinks() {
		
		Assert.assertEquals(Config.HomePage.baseURL, homePage.getCurrentUrl());
		Assert.assertEquals("Home", homePage.getTitle());
		checkTopMenu(homePage);
		// click on the Home link
		homePage.getHomeTopLink().click();
		checkTopMenu(homePage);
	}
    
    
    @Then("^Content of the page should coincide with the one from Config$")
	public void testMainPageContent() {
		Assert.assertEquals(Config.HomePage.content, homePage.getContent());
	}

	/**
	 * Open home page, click on simulator top link and check if no errors
	 */
    @When("^I open home page and click on the simulator link$")
    public void open_home_and_simulator_page() {
    	simulatorPage.open(driver, Config.HomePage.baseURL);
		// click on the simulator link
		simulatorPage.getSimulatorTopLink().click();
    }
    
    @Then("^Then Simulator page current URL, menu and title must be similar to ones from config$")
	public void testSimulatorPageLinks() {
		Assert.assertEquals(Config.SimulatorPage.baseURL, simulatorPage.getCurrentUrl());
		Assert.assertEquals("simulator", simulatorPage.getTitle());
		checkTopMenu(simulatorPage);
	}
    
    @When("^I open simulator page$")
    public void open_simulator_page() {
    	simulatorPage.open(driver, Config.SimulatorPage.baseURL);
    }

    @Then("^Content of the simulator page should coincide with the one from Config$")
	public void testSimulatorPageContent() {
		
		Assert.assertEquals(Config.SimulatorPage.content, simulatorPage.getContent());
	}
	
	/**
	 * Open home page, click on theory top link and check if no errors
	 */
	public void testTheoryPageLinks() {
		theoryPage.open(driver, Config.HomePage.baseURL);
		// click on the simulator link
		theoryPage.getTheoryTopLink().click();
		Assert.assertEquals(Config.TheoryPage.baseURL, theoryPage.getCurrentUrl());
		Assert.assertEquals("theory", theoryPage.getTitle());
		checkTopMenu(theoryPage);
	}

	public void testTheoryPageContent() {
		theoryPage.open(driver, Config.TheoryPage.baseURL);
		Assert.assertEquals(Config.TheoryPage.content, theoryPage.getContent());
	}

	private void checkTopMenu(DriverUtils page) {
		Assert.assertEquals(Config.Menu.homeTopLinkText, page.getHomeTopLink().getText());
		Assert.assertEquals(Config.Menu.simulatorTopLinkText, page.getSimulatorTopLink().getText());
		Assert.assertEquals(Config.Menu.theoryTopLinkText, page.getTheoryTopLink().getText());
		// testing links url
		Assert.assertEquals(Config.Menu.homeTopLinkURL, page.getHomeTopLink().getAttribute("href"));
		Assert.assertEquals(Config.Menu.simulatorTopLinkURL, page.getSimulatorTopLink().getAttribute("href"));
		Assert.assertEquals(Config.Menu.theoryTopLinkURL, page.getTheoryTopLink().getAttribute("href"));
	}

    
    
}
