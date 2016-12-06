package AllPages;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
import utility.ExcelUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import utility.ExcelUtils;

//public class Manage_Profile extends MainFirefox {
public class Manage_Profile extends Main_Fun {
	@Rule
	public ErrorCollector errcollector=new ErrorCollector();
	 static TestLoginPage home = new TestLoginPage();
  protected static String sheetName="Manage_Profile";
	public static void goProfile() throws Throwable {
		home.goLogin(ExcelUtils.getCellData(sheetName,1,3), ExcelUtils.getCellData(sheetName,1,5));
		Wait(2000);
		driver.findElement(By.xpath("//div[2]/div/ul/li[2]/a/img")).click();
		
	}
    // Can implement change password testing 
   
	
	/*
	 * Testing: Check Company Information tab flow to fill all information with valid data
	 */
	
	@Test
	public void TestCompanyInformation() throws Throwable {

		Manage_Profile.goProfile();
		Wait(2000);
		
	assertEquals("http://tendra.pp.pluto.vn.ua/profile/manage",
			driver.getCurrentUrl());

		
	/*
	 * Step: click "company information" icon
	 */
		driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(2)"))
				.click();
		Wait(2000);
		driver.findElement(
				By.cssSelector(".image-input-field"))
				.sendKeys("/Users/michael/Desktop/Screen.png"); 
		Wait(2000);
		driver.findElement( 
				By.cssSelector("form.ng-invalid > div:nth-child(2) > input:nth-child(2)"))
				.clear();
		driver.findElement(
				By.cssSelector("form.ng-invalid > div:nth-child(2) > input:nth-child(2)"))
				.sendKeys("abc");
		Wait(2000);
		
 	/*
 	 * Step: input company phone number
 	 */
		driver.findElement(
				By.cssSelector("div.form-group:nth-child(3) > input:nth-child(2)"))
				.sendKeys("abcd");
		Wait(2000);
		/*
	 	 * Step: Select county to USA
	 	 */
		try{
		driver.findElement(By.cssSelector("input.ng-invalid:nth-child(1)")).click();
		Wait(2000);
		driver.findElement(By.xpath("//div[@value='us']")).click();
		Wait(2000);}
		catch (Throwable e){errcollector.addError(e);}
		/*
	 	 * Step: type address
	 	 */
		driver.findElement(
				By.cssSelector("div.form-group:nth-child(5) > input:nth-child(2)"))
				.sendKeys("1746 view dr");
		Wait(1000);
		driver.findElement(
				By.cssSelector("div.form-group:nth-child(6) > input:nth-child(2)"))
				.sendKeys("milpitas");
		Wait(2000);
        /*
         * Two side Testing: Select city may select option or input CA 
         */
		try{
		 driver.findElement(By.cssSelector("div.form-group:nth-child(7) > input:nth-child(2)")).sendKeys("CA");
		 Wait(1000);}
         catch (Throwable e){errcollector.addError(e);
         System.out.println("Company state needs to choose option instead of input ");
         }
		try{
			driver.findElement(By.cssSelector("#contentInner > div > div > div > div:nth-child(1) > div > form > div:nth-child(7) > div.form-control.combo-box.ng-invalid > input")).click();
			//driver.findElement(By.xpath("(//input[@type='text'])[6]")).click();
		Wait(2000);
		driver.findElement(By.xpath("//div[@value='CA']")).click();
		Wait(2000);}
		catch(Throwable e1) {errcollector.addError(e1);
		System.out.println("Company state needs to input instead of choose option");}
		
		driver.findElement(
				By.cssSelector("div.form-group:nth-child(8) > input:nth-child(2)"))
				.sendKeys("95035");
		Wait(1000);
		/*
		 * Step: fill info for Privacy URL & Customer support URL
		 */
		driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[2]/div/form/div[1]/input")).sendKeys("https://playphone.com/legal/terms");
		Wait(1000);
		driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[2]/div/form/div[2]/input")).sendKeys("https://playphone.com/legal/support");
		Wait(1000);
		
		driver.findElement(By.cssSelector(".profile-company > div:nth-child(3) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > input:nth-child(2)")).sendKeys("#$%45ABC");
		Wait(1000);
		/*
		 * Step: Сountry of Registration choose US
		 */
		try{
			driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[3]/div/form/div[2]/div[2]/input")).click(); 
			Wait(1000);
			driver.findElement(By.xpath("//div[@value='us']")).click();
			Wait(1000);}
			catch (Throwable e){errcollector.addError(e);}
		
		
		WebElement element = driver.findElement(By.xpath("//button[2]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
		
		Wait(2000);
		String status = driver.findElement(
				By.cssSelector("a.ui-checkbox-after:nth-child(2)"))
				.getAttribute("class");
		System.out.println("after save class attribute is" + status);
		assertTrue(home.VerifyElementTextPresent("checked-after active", "a.ui-checkbox-after:nth-child(3)"));
	/*	String CMcheck = driver.findElement(
				By.xpath("//div[3]/div/div[2]/ul/li[2]/a/span[2]"))
				.getAttribute("class");
		System.out.println("color is" + CMcheck);
		assertEquals("icon right check-green", CMcheck);
		System.out.println("company information successfully input"); */
	}

	/*
	 * Testing: Check Payment Information tab flow to fill all information
	 */
	@Test
	public void TestPaymengInformation() throws Throwable {
		Manage_Profile.goProfile();
		
		Wait(2000);
		driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(4)"))
				.click();
		
Wait(2000);
driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > input:nth-child(2)")).sendKeys("bank of america");
Wait(1000);
driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(2) > input:nth-child(2)")).sendKeys("03845sfsf");
Wait(1000);
driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(3) > input:nth-child(2)")).sendKeys("ABCjiu1783");
Wait(1000);
driver.findElement(By.cssSelector("div.col-md-6:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > input:nth-child(2)")).sendKeys("check123");
/*
 * Step: Select country to US
 */
driver.findElement(By.cssSelector("div.form-group:nth-child(5) > div:nth-child(2) > input:nth-child(1)")).click();
Wait(2000);
try{
//driver.findElement(By.xpath("//div[@value='USD']")).click();
driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[1]/div/form/div[5]/div[2]/div/div/div[1]")).click();	
}
catch(Throwable e){errcollector.addError(e);
	
}

Wait(1000);
driver.findElement(By.cssSelector("div.form-group:nth-child(6) > input:nth-child(2)")).sendKeys("1748 sddf rd");
Wait(1000);
/*
 * Step: input bank city name
 */
driver.findElement(By.cssSelector("#contentInner > div > div > div > div:nth-child(1) > div > form > div:nth-child(7) > input")).sendKeys("ABCdfsf");
Wait(1000);
/*
 * Testing: test state_Province sometimes have pull down menu sometimes not
 */

try{
driver.findElement(By.cssSelector("div.form-group:nth-child(9) > input:nth-child(2)")).click();
Wait(2000);
driver.findElement(By.xpath("//div[@value='CA']")).click(); 
Wait(1000);
}
catch(Throwable e){
	errcollector.addError(e);
System.out.println("getting state use editing characters in state field");	
}

try{
driver.findElement(By.cssSelector("div.form-group:nth-child(9) > input:nth-child(2)")).sendKeys("@#$ABCD123");
Wait(1000);}
catch(Throwable e){
	errcollector.addError(e);
System.out.println("getting state use select option under state menu");	
}


driver.findElement(By.cssSelector("div.form-group:nth-child(10) > input:nth-child(2)")).sendKeys("ACCB12367");


try{
//driver.findElement(By.cssSelector("(div.form-group:nth-child(11) > div:nth-child(2) > input:nth-child(1)")).click();
	driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[1]/div/form/div[11]/div[2]/input")).click();
Wait(1000);
driver.findElement(By.xpath("//div[@value='USD']")).click();}
catch(Throwable e3) {errcollector.addError(e3);}

Wait(1000);
driver.findElement(By.cssSelector("form.ng-valid-email > div:nth-child(1) > input:nth-child(2)")).sendKeys("ACCBMichael");
Wait(1000);
driver.findElement(By.cssSelector("form.ng-valid-email > div:nth-child(2) > input:nth-child(2)")).sendKeys("ACCB1898234");
Wait(1000);
	driver.findElement(By.cssSelector("input.ng-valid-email")).sendKeys("ACCBdfsdf@sdffie.com");
	Wait(1000);
	driver.findElement(By.xpath("//*[@id='contentInner']/div/div/div/div[2]/div/form/div[4]/input")).sendKeys("ABC2#$129df");
	Wait(1000);
	/*
	 * Step: click save button
	 */
	driver.findElement(By.xpath("//*[@id='subheader']/div[1]")).click();
	/*
	String PIcheck = driver.findElement(
			By.xpath("//div[3]/div/div[1]/span[2]/button[2]"))
			.getAttribute("class");
	System.out.println("color is" + PIcheck);
	assertEquals("icon right check-green", PIcheck);
	System.out.println("Payment info has successfully input"); */
	Wait(1000);
	String status = driver.findElement(
			By.cssSelector("a.ui-checkbox-after:nth-child(4)"))
			.getAttribute("class");
	System.out.println("payment info after save class attribute is" + status);
	assertTrue(home.VerifyElementTextPresent("checked-after active", "a.ui-checkbox-after:nth-child(4)"));
	} 
	/*
	 * Testing: Test agreement & contracts and confirm 
	 */
@Test

public void TestAgreementContract() throws Throwable {
	home.goLogin("michaelyinqa@gmail.com","y8493187");
	Wait(2000);
	driver.findElement(By.xpath("//div[2]/div/ul/li[2]/a/img")).click();
	Wait(2000);
	driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(3)")).click();
	Wait(3000);
	WebElement element = driver.findElement(By.cssSelector(".accept-terms-checkbox-label > span:nth-child(1)"));
	Actions actions = new Actions(driver);
	actions.moveToElement(element).click().perform();
	Wait(1000);
	driver.findElement(By.cssSelector(".accept-terms-control > button:nth-child(3)")).click();
	Wait(1000);
	}



	@After
	public void teardown() {
		driver.close();
	}
		

}
