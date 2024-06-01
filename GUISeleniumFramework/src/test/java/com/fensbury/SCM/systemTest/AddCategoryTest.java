package com.fensbury.SCM.systemTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.generic.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManageCategoryPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class AddCategoryTest extends BaseClass{
	@Test
	public void AddcategoryTest() throws Throwable
	{
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		Home ho = new Home(driver);//(//tr)//tr[last()]
		ho.getHomeManageCategory().click();
		ManageCategoryPage manca = new ManageCategoryPage(driver);
		manca.getAddcategorybutton().click();
		String catgname = eLib.getDataFromExcel("sheet1", 9, 1)+jLib.getRandomNumber();
		String Details = eLib.getDataFromExcel("sheet1", 9, 2);
		manca.getcategoryname().sendKeys(catgname);
		manca.getcategorydetails().sendKeys(Details);
		manca.getAddcategorybutton2().click();
		wLib.switchtoAlertAndAccept(driver);
		//verify
		ho.getHomeManageCategory().click();
		String actcateg = manca.getActcategry().getText();
		Assert.assertEquals(catgname, actcateg);
		// Edit category
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//td[text()='"+" "+catgname+" "+"']/..//img]")).click();
		manca.getEditcategorybtn().click();
	
		String edtcatgname = eLib.getDataFromExcel("sheet1", 9, 3)+jLib.getRandomNumber();
		manca.geteditcategoryname().clear();
	manca.geteditcategoryname().sendKeys(edtcatgname);
	manca.getupdatecategorybtn().click();
	wLib.switchtoAlertAndAccept(driver);
	ho.getHomeManageCategory().click();
	String text = driver.findElement(By.xpath("//td[text()='"+" "+edtcatgname+" "+"']")).getText();
	Assert.assertEquals(edtcatgname, text);
	
		}

}
