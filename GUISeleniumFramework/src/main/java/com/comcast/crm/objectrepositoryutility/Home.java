package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Deepak
 * 
 * Contains Login page elements & business lib like login()
 *
 */  
public class Home extends WebDriverUtility{                             
                           
	WebDriver driver;
	 public Home(WebDriver driver) {            
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath = "//input[@value='Log out']")
	 private WebElement lgBtn;
	 
	 private void syso() {
		// TODO Auto-generated method stub

	}
	 
	 public void read() {
		 
	 }
	public void login()
	{
		System.out.println("hellooooo");
	}
	public void login2()
	{
		System.out.println("hellooooo2");
	}

	public WebElement getLgBtn() {
		return lgBtn;
	}


	public void logout() {
	getLgBtn().click();
		
	}
	

	
	
}
