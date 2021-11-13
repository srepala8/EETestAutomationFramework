package com.ee.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ee.qa.base.TestBase;
import com.ee.qa.util.TestUtil;

public class HotelBookingFormPage  extends TestBase {
	
	
	TestUtil testutil;
	
	@FindBy(xpath = "//input[@id='firstname']")
	WebElement FirstName;
	
	@FindBy(xpath = "//input[@id='lastname']")
	WebElement SurName;
	
	
	@FindBy(xpath = "//input[@id='totalprice']")
	WebElement Price;
	
	@FindBy(xpath = "//*[@id='depositpaid']")
	WebElement Deposit;
	
	@FindBy(xpath = "//input[@id='checkin']")
	WebElement Checkin;
	
	@FindBy(xpath = "//input[@id='checkout']")
	WebElement Checkout;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	WebElement Save;
	
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement Delete;
	
	@FindBy(xpath = "//h1[contains(text(),'Hotel booking form')]")
	WebElement HBText;
	
	
	public HotelBookingFormPage() {
		
		PageFactory.initElements(driver, this);
		//Alternate method - replace HomePage.class - in place of "this"
		testutil = new TestUtil();
	}
	
public String validateTitle() {
		
		testutil.Sleep();
		return driver.getTitle();
	}


	public boolean validateHBText() {
		
		testutil.Sleep();
		return HBText.isDisplayed();
	}
	
	
	public HotelBookingFormPage createAbooking() {
		
		testutil.Sleep();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Test");
		//FirstName.sendKeys(prop.getProperty("FName"));
		SurName.sendKeys(prop.getProperty("SName"));
		Price.sendKeys(prop.getProperty("Price"));
		Select deposit = new Select(Deposit);
		deposit.selectByVisibleText(prop.getProperty("Option"));
		Checkin.sendKeys(prop.getProperty("CheckinDate"),Keys.ENTER);
		testutil.Sleep();
		Checkout.sendKeys(prop.getProperty("CheckOutDate"),Keys.ENTER);
		testutil.Sleep();
		Save.click();
		return new HotelBookingFormPage();
		
		
	}
	
	public void deleteABooking()
	{
       testutil.Sleep();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Delete.click();
		
	}

}
