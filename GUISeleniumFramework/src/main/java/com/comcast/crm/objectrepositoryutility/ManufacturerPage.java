package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/*
 * @auother:Preethi
 *
 * contains Manufacture page web elemnets
 */

public class ManufacturerPage{

WebDriver driver;
public ManufacturerPage(WebDriver driver)
{            
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(id = "manufacturer:name")
private WebElement manufname;

public WebElement getmanufname() {
return manufname;
}
@FindBy(id = "manufacturer:email")
private WebElement manufemail;

public WebElement getmanufemail() {
return manufemail;
}
@FindBy(id = "manufacturer:phone")
private WebElement manufphone;

public WebElement getmanufphone() {
return manufphone;
}
@FindBy(id = "manufacturer:username")
private WebElement manufusername;

public WebElement getmanufusername() {
return manufusername;
}
@FindBy(id = "manufacturer:password")
private WebElement manufpassword;

public WebElement getmanufpassword() {
return manufpassword;
}

@FindBy(xpath= "//input[@value='Add Manufacturer']")
private WebElement manufaddbutton;

public WebElement getmanufaddbutton()
{
return manufaddbutton;
}

public void addmanufacturer() throws Throwable
{
	ExcelUtility eLib = new ExcelUtility();
	manufname.sendKeys(eLib.getDataFromExcel("sheet1", 2, 1));
	manufemail.sendKeys(eLib.getDataFromExcel("sheet1", 2, 2));
	manufphone.sendKeys(eLib.getDataFromExcel("sheet1", 2, 3));
	manufusername.sendKeys(eLib.getDataFromExcel("sheet1", 2, 4));
	manufpassword.sendKeys(eLib.getDataFromExcel("sheet1", 2, 5));
	manufaddbutton.click();
	
}

}
