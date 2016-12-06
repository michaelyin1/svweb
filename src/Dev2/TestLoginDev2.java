package Dev2;
import java.util.concurrent.TimeUnit;
import AllPages.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import AllPages.Main_Fun;
import utility.ExcelUtils;

import static org.junit.Assert.*;
import TestData.HomeObject;
import utility.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestLoginDev2 extends Main_Fun {
//	public class TestLoginDev2 extends MainFirefox{
	static String Dev2baseUrl = "https://devportal.cluster2.dev.playphone.cc/";
	static String  Acbar2= "https://cluster2.dev.playphone.cc/ ";
	//@Test
	public void testDev2Login() {
		driver.get(Dev2baseUrl);
		Wait(3000);
		driver.findElement(By.xpath("/html/body/header/nav/ul/li[6]/a"))
				.click();
		Wait(1000);
		driver.findElement(By.cssSelector("div.field:nth-child(1) > input:nth-child(2)")).sendKeys("michaelyinqa@gmail.com");
		driver.findElement(By.cssSelector("div.field:nth-child(2) > input:nth-child(2)")).sendKeys("y8493187");
		driver.findElement(By.cssSelector("input.btn-blue:nth-child(5)")).click();
		
	}
	@Test
	public void ackbarLogin(){
		driver.get(Acbar2);
		Wait(2000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/div[1]/input")).sendKeys("michael.yin@playphone.com");
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/div[2]/input")).sendKeys("BottleR0ck!");
	Wait(1000);
	driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/input")).click();
	Wait(2000);
	}
	@After
	public void close(){
		driver.close();
	}
}

