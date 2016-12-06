package AllPages;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ExcelUtils;
import static org.junit.Assert.*;
import TestData.HomeObject;

import org.openqa.selenium.firefox.FirefoxDriver;

import utility.ExcelUtils;

public class TestLoginPage extends Main_Fun {
	// public class TestLoginPage extends MainFirefox{

	/*
	 * Description: Step of clicking login button
	 */
	@Rule
	public  ErrorCollector errcollector=new ErrorCollector();
	//static String baseUrl = "http://tendra.pp.pluto.vn.ua/";
	static String baseUrl = "http://tendra.cluster04.dev.playphone.cc/index.html";
	Main_Fun main = new Main_Fun();
	protected  static String sheetName="TestLoginPage";

	
	/*
	 * Description: Step of clicking login button
	 */
	public static void goLoginButton() {
		driver.get(baseUrl);
		Wait(3000);
		driver.findElement(By.xpath("//div[1]//header//nav//ul//li[6]//a"))
				.click();
		Wait(2000);
	}

	/*
	 * Description: Step of input username and pass to login
	 */
	public static void goLogin(String emailadd, String password) {
		TestLoginPage.goLoginButton();
		driver.findElement(By.name("email")).sendKeys(emailadd);

		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.btn-blue.submit")).click();
		Wait(3000);
		String manageUrl = driver.getCurrentUrl();
		System.out.println("manager url:" + manageUrl);
		
	}

	/*
	 * Testing: login with valid usesrname and password
	 */
	
	@Test
	public void testLogin() throws Exception {
		TestLoginPage.goLoginButton();
		try{
		assertEquals(
				"Email",
				driver.findElement(
						By.xpath(".//*[@id='loginForm']/div/div[2]/input[@placeholder]"))
						.getAttribute("placeholder"));}
		catch (Throwable e){errcollector.addError(e);}
		String userdata = ExcelUtils.getCellData(sheetName,1,3);
		// String userdata=ExcelUtils.getCellData(3,1);
		String userpass = ExcelUtils.getCellData(sheetName, 2, 3);
		TestLoginPage.goLogin(userdata, userpass);
		// TestLoginPage.goLogin(userdata, ExcelUtils.getCellData(3,2));
		Wait(2000);
		String manageUrl = driver.getCurrentUrl();
		System.out.println("manager url:" + manageUrl);
		try{
			assertEquals("http://tendra.cluster04.dev.playphone.cc/games/", manageUrl);}
			
			catch(Exception e){
			System.out.println("Login error");}
	}
	/*
	 * Testing: login with mutiple characters login name
	 */
	@Test
	public void LoginEdge(){
		try{
			TestLoginPage.goLogin(ExcelUtils.getCellData(sheetName, 1, 4), ExcelUtils.getCellData(sheetName, 2, 4));}
			catch (Throwable e) {errcollector.addError(e);}
		Wait(2000);
		String manageUrl = driver.getCurrentUrl();
		try{
			assertEquals("http://tendra.cluster04.dev.playphone.cc/games/", manageUrl);}
			
			catch(Exception e){
			System.out.println("mutiple characters Login error");}
	}
	
	/*
	 * Testing: login with invalid username and password, should have error
	 * message
	 */

	@Test
	public void LoginFail() {
		try{
		TestLoginPage.goLogin(ExcelUtils.getCellData(sheetName, 4, 3), ExcelUtils.getCellData(sheetName, 5, 3));}
		catch (Throwable e) {errcollector.addError(e);}
		WebElement UserError = driver.findElement(By
				.xpath("//*[@id='loginForm']/div/div[1]"));
		System.out.println("Error message is" + UserError.getText());
		assertTrue(main.IsTextPresent(UserError.getText()));
		String color = UserError.getCssValue("color");
		System.out.println("Error message color is" + color);
		assertEquals("rgba(226, 121, 121, 1)", color);
	}

	/*
	 * Testing: login with username and invalid password, should have error message with red color
	 
	 */
	@Test
	public void LoginPassFail() {
		try{
		TestLoginPage.goLogin(ExcelUtils.getCellData(sheetName, 7, 3), ExcelUtils.getCellData(sheetName, 8, 3));}
		catch(Throwable e){}
		WebElement PassError = driver.findElement(By
				.xpath("//*[@id='loginForm']/div/div[1]"));
		System.out.println("Error message is" + PassError.getText());
		assertTrue(main.IsTextPresent(PassError.getText()));
		String color = PassError.getCssValue("color");
		System.out.println("Error message color is" + color);
		assertEquals("rgba(226, 121, 121, 1)", color);
		// assertTrue(driver.isElementPresent("css=td[bgcolor=#ff0000]"));
	}
	/*
	 * Testing: test forget password on login dialog and send email to receiver
	 */
	//@Test
	public void ForgotPass(){
		TestLoginPage.goLoginButton();
		driver.findElement(By.cssSelector("a.forgot:nth-child(1)")).click();
		Wait(1000);
		try{
		driver.findElement(By.cssSelector("form.ng-pristine:nth-child(3) > label:nth-child(2) > input:nth-child(2)")).sendKeys(ExcelUtils.getCellData(sheetName, 9, 3));
		main.Snapshot((TakesScreenshot)driver, "forgotPassError.png");}
		catch(Throwable e){errcollector.addError(e);
		Wait(2000);
		main.Snapshot((TakesScreenshot)driver, "forgotPassError.png");
		}
		
			driver.findElement(By.cssSelector("input.submit:nth-child(1)")).click();
		
		Wait(1000);
		
			assertTrue(main.IsTextPresent("We’ve sent a password reset link to your email."));
		
		}
	
	

	@After
	public void close() {
		driver.close();
        

	}

}
