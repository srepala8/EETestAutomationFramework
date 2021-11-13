package com.ee.qa.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ee.qa.base.TestBase;
import com.ee.qa.pages.HotelBookingFormPage;
import com.ee.qa.util.TestUtil;

public class HotelBookingFormPageTest extends TestBase {
	
	TestUtil testutil;
	HotelBookingFormPage hbfpage;
	
	
	
	public HotelBookingFormPageTest() {
		
		super();
		
	}
	
@BeforeMethod
	
	public void setup() {
	
		initialization();
					
		hbfpage = new HotelBookingFormPage();
		
		testutil = new TestUtil();			
	}


@Test(priority =1)
	
	public void verifyTitleTest() throws InterruptedException  {	
		
	Thread.sleep(2000);
		Assert.assertEquals(hbfpage.validateTitle(), "Hotel booking form");
			}


@Test(priority=2)

	public void verifyHBFormLabelTest() {
		
	    boolean Label = hbfpage.validateHBText();
		Assert.assertTrue(Label);
		}
	
@Test(priority=3)

public void createAbookingTest() {
	
hbfpage.createAbooking();
 
 System.out.println("Create a booking done successfully");
	
	}

@Test(priority=4)

public void deleteAbookingTest() {
	
hbfpage.deleteABooking();
 
 System.out.println("Delete a booking done successfully");
	
	}
@AfterMethod

public void screenShot(ITestResult result){
	
	 //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
	 if(ITestResult.FAILURE==result.getStatus()){
	 try{
		 
	 // To create reference of TakesScreenshot
	 TakesScreenshot screenshot=(TakesScreenshot)driver;
	 
	 // Call method to capture screenshot
	 File src=screenshot.getScreenshotAs(OutputType.FILE);
	 
	 // Copy files to specific location 
	
	 FileUtils.copyFile(src, new File("C:\\Users\\srrepala\\Desktop\\EqualEx\\Hotel\\Failed_Screenshots\\Screenshots"+result.getName()+".png"));
	 System.out.println("Successfully captured a screenshot");
	  }catch (Exception e){
	 System.out.println("Exception while taking screenshot "+e.getMessage());
	 }
	 }
	
	        driver.quit();
		
}

	
}
