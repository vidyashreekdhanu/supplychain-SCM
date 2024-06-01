package com.fensbury.SCM.systemTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.Manageunitpage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class Addunit_DeleteunitTest extends BaseClass{
	
@Test
public void addAndDeleteUnitTest() throws Throwable {
	
		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();
		Home hp= new Home(driver);
		hp.getHomeManageUnit().click();
		hp.getHomeManageUnit().click();
Manageunitpage mup=new Manageunitpage(driver);
     mup.getAddunitbtn().click();
    String unitname = eLib.getDataFromExcel("sheet1", 11, 1);
    String Details = eLib.getDataFromExcel("sheet1", 11, 2);
     mup.getUnitNameEdit().sendKeys(unitname);
     mup.getDtailseEdit().sendKeys(Details);
     mup.getAddunitBtn2().click();
  wLib.switchtoAlertAndAccept(driver);
		//verification
		hp.getHomeManageUnit().click();
String actunit = mup.getActunit().getText();
	Assert.assertEquals(actunit, unitname);
	driver.findElement(By.xpath("//*[@class='table_mainWrapper']//section//form//tr[last()]//td")).click();

	mup.getDeletbtn().click();
	//verification
	wLib.switchtoAlertAndAccept(driver);
//		hp.logout();
}
}