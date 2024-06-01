package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * @auother:Preethi
 *
 * contains OrdersPAge web elements
 */
public class OrdersPage {

WebDriver driver;

public OrdersPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(id="cmbFilter")
private WebElement OrdersSearchBy;

@FindBy(linkText = "My Orders")
private WebElement Orderstab;

public WebElement getOrdersSearchBy() {
return OrdersSearchBy;
}

public WebElement getOrderstab() {
	return Orderstab;
}
@FindBy(xpath = "//input[@value='Search']")
private WebElement OrdersSearchbutton;

public WebElement getOrdersSearchbutton() {
return OrdersSearchbutton;
}

@FindBy(id="cmbStatus")
private WebElement OrdSerchselct;

public WebElement getOrdSerchselct() {
	return OrdSerchselct;
}


@FindBy(linkText ="Details" )
private WebElement Detailink;


@FindBy(xpath = "//*[@id='td_section']/section/form/table/tbody/tr[2]/td[3]" )
private WebElement prodctname;

public WebElement getProdctname() {
	return prodctname;
}

public WebElement getDetailink() {
	return Detailink;
}

}
