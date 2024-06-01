package com.fensbury.SCM.systemTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.AddProductPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddproductverifyTest extends BaseClass {
	
@Test
public void addproducttTest() throws Throwable
{
	LoginPage lp = new LoginPage(driver);
	lp.loginToappManu();
	UtilityClassObject.getTest().log(Status.INFO, "login as manufacturer");
	Home ho = new Home(driver);
	ho.getHomeAddProducts().click();
	AddProductPage adpr = new AddProductPage(driver);
	String prdname = eLib.getDataFromExcel("sheet1", 13, 1)+jLib.getRandomNumber();
	String unitTpe = eLib.getDataFromExcel("sheet1", 13, 3);
	String category = eLib.getDataFromExcel("sheet1", 13, 4);
	adpr.getProductEdt().sendKeys(prdname);
	adpr.getPriceEdt().sendKeys(eLib.getDataFromExcel("sheet1", 13, 2));
	WebElement webEle = adpr.getUnitDD();
	wLib.select(webEle, unitTpe);
	WebElement web = adpr.getCategDD();
	wLib.select(web, category);
	adpr.getEnableRbtn().click();
	adpr.getDescriptn().sendKeys(eLib.getDataFromExcel("sheet1", 13, 6));
	adpr.getAddpbtn().click();
	wLib.switchtoAlertAndAccept(driver);
	ho.getHomeProducts().click();
	//verify      
	String table = driver.findElement(By.xpath("//td[text()='"+" "+prdname+" "+"']")).getText();
	Assert.assertTrue(table.contains(prdname));
}
}
