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
import com.comcast.crm.objectrepositoryutility.EditManufacturerPage;
import com.comcast.crm.objectrepositoryutility.Home;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.ManageCategoryPage;
import com.comcast.crm.objectrepositoryutility.Manageunitpage;
import com.comcast.crm.objectrepositoryutility.ManufacturerPage;
import com.comcast.crm.objectrepositoryutility.NewOrderPage;
import com.comcast.crm.objectrepositoryutility.OrdersPage;
import com.comcast.crm.objectrepositoryutility.RetailerPage;
@Listeners(com.comcast.crm.generic.listenerutility.ListImpClass.class)
public class FullRegressionTest extends BaseClass {
	@Test
	public void AddcategoryTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp();
		Home ho = new Home(driver);// (//tr)//tr[last()]
		ho.getHomeManageCategory().click();
		ManageCategoryPage manca = new ManageCategoryPage(driver);
		manca.getAddcategorybutton().click();
		String catgname = eLib.getDataFromExcel("sheet1", 9, 1) + jLib.getRandomNumber();
		String Details = eLib.getDataFromExcel("sheet1", 9, 2);
		manca.getcategoryname().sendKeys(catgname);
		manca.getcategorydetails().sendKeys(Details);
		manca.getAddcategorybutton2().click();
		wLib.switchtoAlertAndAccept(driver);
		// verify
		ho.getHomeManageCategory().click();
		String actcateg = manca.getActcategry().getText();
		Assert.assertEquals(catgname, actcateg);
		// Edit category
		Thread.sleep(3000);
		// driver.findElement(By.xpath("//td[text()='"+" "+catgname+"
		// "+"']/..//img]")).click();
		manca.getEditcategorybtn().click();
		String edtcatgname = eLib.getDataFromExcel("sheet1", 9, 3) + jLib.getRandomNumber();
		manca.geteditcategoryname().clear();
		manca.geteditcategoryname().sendKeys(edtcatgname);
		manca.getupdatecategorybtn().click();
		wLib.switchtoAlertAndAccept(driver);
		ho.getHomeManageCategory().click();
		String text = driver.findElement(By.xpath("//td[text()='" + " " + edtcatgname + " " + "']")).getText();
		Assert.assertEquals(edtcatgname, text);
	}

	@Test
	public void addproducttTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();
		UtilityClassObject.getTest().log(Status.INFO, "login as manufacturer");
		Home ho = new Home(driver);
		ho.getHomeAddProducts().click();
		AddProductPage adpr = new AddProductPage(driver);
		String prdname = eLib.getDataFromExcel("sheet1", 13, 1) + jLib.getRandomNumber();
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
		// verify
		String table = driver.findElement(By.xpath("//td[text()='" + " " + prdname + " " + "']")).getText();
		Assert.assertTrue(table.contains(prdname));
	}

	@Test
	public void addRetailertest() throws Throwable {
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
		String Status = eLib.getDataFromExcel("sheet1", 7, 9);
		wLib.select(ele2, Status);
		ord.getOrdersSearchbutton().click();
		ord.getDetailink().click();
//*[@id="td_section"]/section/form/table/tbody/tr[2]/td[1]
		String actquantity = ord.getProdctname().getText();
		Assert.assertTrue(actquantity.contains(quantity));
	}

	@Test
	public void addAndDeleteUnitTest() throws Throwable {
		LoginPage lp = new LoginPage(driver);
		lp.loginToappManu();
		Home hp = new Home(driver);
		hp.getHomeManageUnit().click();
		hp.getHomeManageUnit().click();
		Manageunitpage mup = new Manageunitpage(driver);
		mup.getAddunitbtn().click();
		String unitname = eLib.getDataFromExcel("sheet1", 11, 1);
		String Details = eLib.getDataFromExcel("sheet1", 11, 2);
		mup.getUnitNameEdit().sendKeys(unitname);
		mup.getDtailseEdit().sendKeys(Details);
		mup.getAddunitBtn2().click();
		wLib.switchtoAlertAndAccept(driver);
		// verification
		hp.getHomeManageUnit().click();
		String actunit = mup.getActunit().getText();
		Assert.assertEquals(actunit, unitname);
		driver.findElement(By.xpath("//*[@class='table_mainWrapper']//section//form//tr[last()]//td")).click();

		mup.getDeletbtn().click();
//verification
		wLib.switchtoAlertAndAccept(driver);
//	hp.logout();
	}

	@Test
	public void AddmanufacturerTest() throws Throwable {
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
