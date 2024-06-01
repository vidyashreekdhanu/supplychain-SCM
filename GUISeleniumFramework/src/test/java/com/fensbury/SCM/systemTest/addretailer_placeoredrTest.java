package com.fensbury.SCM.systemTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.NewOrderPage;
import com.comcast.crm.objectrepositoryutility.OrdersPage;
import com.comcast.crm.objectrepositoryutility.RetailerPage;

public class addretailer_placeoredrTest extends BaseClass {
	@Test
	public void addRetailertest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		Home ho = new Home(driver);
		ho.getHomeAddRetailers().click();
		RetailerPage Ret = new RetailerPage(driver);
		Ret.addretailer();
		wLib.switchtoAlertAndAccept(driver);
		
		lp.loginToappRet();
		NewOrderPage orp = new NewOrderPage(driver);
		orp.getNewOrder().click();
		String quantity = eLib.getDataFromExcel("sheet1", 7, 7);
		orp.getQuantEdit().sendKeys(quantity);
	OrdersPage ord = new OrdersPage(driver);
	ord.getOrderstab().click();
	//verification
	WebElement ele = ord.getOrdersSearchBy();
	String text = eLib.getDataFromExcel("sheet1", 7, 8);
	wLib.select(ele, text);
	WebElement ele2 = ord.getOrdSerchselct();
	String  Status= eLib.getDataFromExcel("sheet1", 7, 9);
	wLib.select(ele2, Status);
	ord.getOrdersSearchbutton().click();
	ord.getDetailink().click();
	//*[@id="td_section"]/section/form/table/tbody/tr[2]/td[1]
	String actquantity = ord.getProdctname().getText();
	Assert.assertTrue(actquantity.contains(quantity));
	
	
		
		
	}

}
