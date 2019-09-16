package com.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drandanddrop_demo {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Automation\\29062019\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		String title=driver.getTitle();
		System.out.println("The title of web page is:"+title);
		
		List<WebElement> ls=driver.findElements(By.tagName("iframe"));
		 int count=ls.size();
		 System.out.println("The no of iframes are:"+count);
		 driver.switchTo().frame(0);
		 WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		 WebElement target=driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
		 
		 Actions action=new Actions(driver);
		 action.dragAndDrop(source, target).build().perform();
		 driver.switchTo().defaultContent();
		 driver.findElement(By.linkText("About")).click();
		 driver.navigate().back();
		 driver.findElement(By.xpath("//body[@class='jquery-ui page page-id-27 page-template-default page-slug-droppable single-author singular']")).click();
		 driver.navigate().back();
		 String title1=driver.getTitle();
		 System.out.println("The title of webpage is:"+title1);
		 System.out.println("driver closed"); 
		 
				 
	} 

}
