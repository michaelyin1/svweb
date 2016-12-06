package AllPages;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utility.ExcelUtils;


public class TestUser_Game extends Main_Fun {
	 static TestLoginPage home = new TestLoginPage();
protected static String sheetName="TestLoginPage"; 	 
	public static void goGame() throws Exception {
		home.goLogin(ExcelUtils.getCellData(sheetName, 1, 3), ExcelUtils.getCellData(sheetName, 2, 3));
		Wait(2000);
	}
	/*
	 * Step: login to games page, search name"fgdgdfg" to check only show 
	 */
	@Test
	public void testGameFilterSearch() throws Exception {
		TestUser_Game.goGame();
		Wait(2000);
		System.out.println(driver.getCurrentUrl());
		assertEquals("http://tendra.pp.pluto.vn.ua/games/",driver.getCurrentUrl()); 
		//String a=driver.findElement(By.xpath("//div[3]/div/div[2]/div[2]/div/div/i[2]")).getText();
		//System.out.println(a);
		/*
		 * Step: check if filter click "Not Ready" then not ready app should be removed, need implement
		 */
		Wait(1000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector(".label"));
		action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector("li.item:nth-child(2) > span:nth-child(2) > input:nth-child(1)"))).click().build().perform();
        Wait(1000);
       // assertTrue(Main_Fun.IsTextPresent("game12"));
       // assertTrue(Main_Fun.IsTextNotPresent("fgdgdfg"));
        assertTrue(Main_Fun.VerifyElementTextNotPresent("show-action-needed", ".current-filters"));
	
		/*
		 * Step: check search "dgd" and see if only show "dgd" app 
		 */
    	Wait(1000);
		driver.findElement(By.xpath("//*[@id='subheader']/div/label/input")).clear();
		driver.findElement(By.xpath("//*[@id='subheader']/div/label/input")).sendKeys("dgd");
		Wait(1000);
		assertTrue(Main_Fun.IsTextPresent("fgdgdfg"));
		assertTrue(Main_Fun.IsTextNotPresent("game12"));
	}
	
@After
public void TearDown(){
	driver.close();
}

}
