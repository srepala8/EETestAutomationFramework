package com.ee.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ee.qa.base.TestBase;

public class Test extends TestBase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srrepala\\Desktop\\EqualEx\\Hotel\\Drivers\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://hotel-test.equalexperts.io/");
		 String s=driver.getTitle();
		 System.out.println(s);
		 driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("wer");
		 driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("wer");
		 driver.findElement(By.xpath("//input[@id='totalprice']")).sendKeys("1200");
		 Select deposit = new Select( driver.findElement(By.xpath("//*[@id='depositpaid']")));
			deposit.selectByVisibleText("true");
			driver.findElement(By.xpath("//input[@id='checkin']")).sendKeys("2021-11-12",Keys.ENTER);
			driver.findElement(By.xpath("//input[@id='checkout']")).sendKeys("2021-12-12",Keys.ENTER);
			driver.findElement(By.xpath("//input[@value=' Save ']")).click();
			
	}

}
