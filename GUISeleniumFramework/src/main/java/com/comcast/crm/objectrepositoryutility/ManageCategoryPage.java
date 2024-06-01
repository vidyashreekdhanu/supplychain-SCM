package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

/*
* @auother:Preethi
*
* contains ManageCategory web elemnets,edit category,add category
*/
public class ManageCategoryPage {

	WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@value='Delete']")
	private WebElement deletebutton;

	public WebElement getdeletebutton() {
		return deletebutton;
	}

	@FindBy(xpath = "//input[@value='+ Add Category']")
	private WebElement Addcategorybutton;

	public WebElement getAddcategorybutton() {
		return Addcategorybutton;
	}
//ADD Category

	@FindBy(id = "categoryName")
	private WebElement categoryname;

	public WebElement getcategoryname() {
		return categoryname;
	}

	@FindBy(id = "categoryDetails")
	private WebElement categorydetails;

	public WebElement getcategorydetails() {
		return categorydetails;
	}

	@FindBy(xpath = "//input[@value='Add Category']")
	private WebElement Addcategorybutton2;

	public WebElement getAddcategorybutton2() {
		return Addcategorybutton2;
	}
// edit category

	@FindBy(id = "categoryName")
	private WebElement editcategoryname;

	public WebElement geteditcategoryname() {
		return editcategoryname;
	}

	@FindBy(xpath = "//*[@class='table_mainWrapper']//section/form/table//tr[last()]/td[3]")
	private WebElement actcategry;

	public WebElement getActcategry() {
		return actcategry;
	}

	@FindBy(id = "categoryDetails2")
	private WebElement categorydetails2;

	public WebElement getcategorydetails2() {
		return categorydetails2;
	}

	@FindBy(xpath = "//input[@value='Update Category']")
	private WebElement updatecategorybtn;

	public WebElement getupdatecategorybtn() {
		return updatecategorybtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDeletebutton() {
		return deletebutton;
	}

	public WebElement getCategoryname() {
		return categoryname;
	}

	public WebElement getCategorydetails() {
		return categorydetails;
	}

	public WebElement getCategorydetails2() {
		return categorydetails2;
	}

	public WebElement getUpdatecategorybtn() {
		return updatecategorybtn;
	}

	@FindBy(xpath = "//section//form//table//tr[last()]//a")
	private WebElement editcategorybtn;

	public WebElement getEditcategorybtn() {
		return editcategorybtn;
	}
}
