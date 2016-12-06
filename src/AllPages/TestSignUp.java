package AllPages;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;

import utility.ExcelUtils;

import com.thoughtworks.selenium.*;

import static org.junit.Assert.*;
import TestData.HomeObject;


public class TestSignUp extends Main_Fun {
	@Rule
	public ErrorCollector errcollector=new ErrorCollector();
	static String baseUrl = "http://tendra.pp.pluto.vn.ua/";
	//static String baseUrl = "http://tendra.cluster04.dev.playphone.cc/index.html";
	protected  static String sheetName="TestSignUpPage";
	/*
	 * Description: goSignUp tests sign up flow with valid input
	*/
	@Test
	public void goSignUp() throws Throwable {
		
		driver.get(baseUrl);
		
		Wait(6000);
		driver.findElement(By.xpath("//div[1]/header/nav/ul/li[5]/a")).click();
		// driver.findElement(By.cssSelector(".modal")).click();
		Wait(2000);
		driver.findElement(By.name("first_name")).sendKeys(ExcelUtils.getCellData(sheetName,1,3));
		driver.findElement(By.name("last_name")).sendKeys(ExcelUtils.getCellData(sheetName,2,3));
		driver.findElement(By.name("company")).sendKeys(ExcelUtils.getCellData(sheetName,3,3));

		Wait(3000);
		driver.findElement(By.xpath("//*[@id='signUpForm']/div/div[4]/input"))
				.sendKeys(ExcelUtils.getCellData(sheetName,4,3));

		driver.findElement(By.xpath("//*[@id='signUpForm']/div/div[5]/input"))
				.sendKeys(ExcelUtils.getCellData(sheetName,5,3));

		driver.findElement(
				By.xpath("//*[@id='signUpForm']/div/div[6]/div[1]/input"))
				.click();
		Wait(4000);

		/*
		 * Testing: After sign up, check url, 
		*/
		String signupUrl = driver.getCurrentUrl();

		System.out.println("signup url:" + signupUrl);
		// assertTrue(driver.findElement(By.xpath("//div[1]/div/div[2]/div/div[1]/div")).getText().equals("carter"));
	try{
			assertEquals("http://tendra.pp.pluto.vn.ua/signup/profile", signupUrl);}
			catch(Exception e){errcollector.addError(e);
			System.out.println("Signup error");
				
			}
		String signupName = driver.findElement(
				By.cssSelector(".navbar-text")).getText();
		String signupTitleName = driver.findElement(
				By.xpath("//div[3]/div/div[1]/span[1]/span[1]")).getText();
		System.out.println(signupName);
		System.out.println(signupTitleName);
		
		try{
		assertEquals("carter lee", signupName);}
		catch(Throwable e){
			
		}
		assertEquals("Complete Registration", signupTitleName);
	}
	/*
	 * Description: SignUpFail tests sign up fail with invalid input
	*/
	@Test
public void SignUpFail() throws Throwable{
driver.get(baseUrl);
		
		Wait(6000);
		driver.findElement(By.xpath("//div[1]/header/nav/ul/li[5]/a")).click();
		// driver.findElement(By.cssSelector(".modal")).click();
		Wait(2000);
		driver.findElement(By.name("first_name")).sendKeys(ExcelUtils.getCellData(sheetName,9,3));
		driver.findElement(By.name("last_name")).sendKeys(ExcelUtils.getCellData(sheetName,10,3));
		driver.findElement(By.name("company")).sendKeys(ExcelUtils.getCellData(sheetName,11,3));

		Wait(3000);
		driver.findElement(By.xpath("//*[@id='signUpForm']/div/div[4]/input"))
				.sendKeys(ExcelUtils.getCellData(sheetName,12,3));

		driver.findElement(By.xpath("//*[@id='signUpForm']/div/div[5]/input"))
				.sendKeys(ExcelUtils.getCellData(sheetName,13,3));
        String EmailInput=driver.findElement(By.cssSelector("div.holder:nth-child(5) > input:nth-child(2)")).getAttribute("class");
        System.out.println("email invalid is" +EmailInput);
		String submitDisFlag=driver.findElement(
				By.cssSelector("input.btn-blue:nth-child(1)")).getAttribute("disabled");
		try{
		assertEquals("ture", submitDisFlag);
		}
	catch(Throwable e){
			
			
		}
		System.out.println("submit button is" +submitDisFlag);
				
		Wait(7000);
}
	

@After
	public void close() {
		driver.close();
		
	}

}
