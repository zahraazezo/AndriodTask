package com.GmbH.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
	WebDriver driver;

	// create constructor
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void typeText(WebElement textBox, String text) {
		textBox.clear();
		textBox.sendKeys(text);

	}

}
