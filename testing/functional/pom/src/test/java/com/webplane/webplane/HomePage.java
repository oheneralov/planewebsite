package com.webplane.webplane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Helper to test home page due to POM design pattern
 * @author oheneralov
 *
 */
public class HomePage {
	@FindBy(how=How.LINK_TEXT,using="Home")
	WebElement homeTopLink;
	
	@FindBy(how=How.LINK_TEXT,using="Simulator")
	WebElement simulatorTopLink;
	
	@FindBy(how=How.LINK_TEXT,using="Theory")
	WebElement theoryTopLink;
	
	public WebDriver driver;

	public void open(WebDriver driver, String url) {
		this.driver = driver;
		this.driver.get(url);

	}
	
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return this.driver.getTitle();
	}

}
