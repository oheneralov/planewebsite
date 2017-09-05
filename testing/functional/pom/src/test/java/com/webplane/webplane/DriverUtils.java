/**
 * 
 */
package com.webplane.webplane;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * @author oheneralov
 * General methods - wrapper for a selenium driver
 *
 */
public class DriverUtils {
	public WebElement getHomeTopLink() {
		return homeTopLink;
	}


	public WebElement getSimulatorTopLink() {
		return simulatorTopLink;
	}


	public WebElement getTheoryTopLink() {
		return theoryTopLink;
	}


	@FindBy(how=How.LINK_TEXT,using="Home")
	WebElement homeTopLink;
	
	@FindBy(how=How.LINK_TEXT,using="Simulator")
	WebElement simulatorTopLink;
	
	@FindBy(how=How.LINK_TEXT,using="Theory")
	WebElement theoryTopLink;
	
	public WebDriver driver = null;

	public void open(WebDriver driver, String url) {
		this.driver = driver;
		if (this.driver.getCurrentUrl() != "url") {
			this.driver.get(url);
		}
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return this.driver.getTitle();
	}
	
	
	@FindBy(how=How.XPATH,using="/html/body/div[last()]")
	WebElement content;
	public String getContent() {
		return content.getText();
	}


}
