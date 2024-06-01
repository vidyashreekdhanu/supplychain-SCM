package com.fensbury.SCM.systemTest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.EditManufacturerPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManufacturerPage;

public class Endtoend_secenarioTest extends BaseClass 
{
	@Test
	public void AddmanufacturerTest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
	Home ho = new Home(driver);
		ho.getHomeAddManufacturer().click();
	ManufacturerPage man = new ManufacturerPage(driver);
	man.addmanufacturer();
	wLib.switchtoAlertAndAccept(driver);
	ho.logout();
	String manufusername = eLib.getDataFromExcel("sheet1", 2, 4);
	String manufpassword = eLib.getDataFromExcel("sheet1", 2, 5);
	lp.getUsernameEdt().sendKeys(manufusername);
	lp.getPasswordEdt().sendKeys(manufpassword);
	 String txt = eLib.getDataFromExcel("Sheet1", 0, 2);
	 WebElement ele = lp.getSelectDD();
	 wLib.select(ele, txt);
	 lp.getLoginBtn().click();
EditManufacturerPage edtm = new EditManufacturerPage(driver);
edtm.getEditprofiletab2().click();
	edtm.getChangepass().click();
String manufactnewPaswrd = eLib.getDataFromExcel("sheet1", 4, 2);
String manufactPaswrd = eLib.getDataFromExcel("sheet1", 2, 5);

edtm.getOldpass().sendKeys(manufactPaswrd);
	edtm.getNewpass().sendKeys(manufactnewPaswrd);
	edtm.getConfpass().sendKeys(manufactnewPaswrd);
	edtm.getChangepass2().click();
	wLib.switchtoAlertAndAccept(driver);
	
	}
	

		
		
}		
		

