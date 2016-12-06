package AllPages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.Throwables;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;

import utility.ExcelUtils;


//public class TestHomePage extends MainFirefox{
public class TestHomePage extends Main_Fun {
	
	@Rule
	public ErrorCollector errcollector=new ErrorCollector();
	//private String baseUrl = "http://tendra.pp.pluto.vn.ua/";
	static String baseUrl = "http://tendra.cluster04.dev.playphone.cc/index.html";
	private static Main_Fun main = new Main_Fun();
	protected static String sheetName = "TestHomePage";

	/*
	 * Description: Test whether Some text like "COMPANY" is present on the
	 * homepage Testing:
	 */
	@Test
	public void TestHomeElement()  {
		/*
		 * Description: Declare test data import from excel using try catch
		 * block
		 */
		driver.get(baseUrl);
		Wait(2000);

		/*
		 * Testing: Check the element "company", "developer" is there. 
		 */
	try {
			assertTrue(main.IsTextPresent(ExcelUtils.getCellData(sheetName, 1,
					2)));
		} catch (Throwable e1) {errcollector.addError(e1);

		}
		try {
			assertTrue(main.IsTextPresent(ExcelUtils.getCellData(sheetName, 1,
					3)));
		} catch (Throwable e2) {errcollector.addError(e2);
		}
	
	}
		

	/*
	 * Description: Testing click button can go to correct Url, Testing:
	 */
	 @Test
	public void TestUrl() {
		driver.get(baseUrl);
		Wait(2000);
		String HomeUrl = driver.getCurrentUrl();
		System.out.println("home title:" + HomeUrl);
		assertEquals("http://tendra.cluster04.dev.playphone.cc/", HomeUrl);
	}

	/*
	 * Description: Testing click some button can navigate to sign up window
	 */
	@Test
	public void TestSignUpShow() {
		driver.get(baseUrl);
		Wait(2000);
		try {
			driver.findElement(By.xpath("//div[1]/section[2]/div/a[1]"))
					.click();

			assertTrue(TestHomePage.IsSignUpShow("Getting started"));
		} catch (Throwable e) {errcollector.addError(e);
		}

		driver.findElement(By.cssSelector(".small > a:nth-child(1)")).click();
		Wait(1000);
		try {
			driver.findElement(By.cssSelector(".blue")).click();

			assertTrue(TestHomePage
					.IsSignUpShow("Go Viral With Social Start Now"));
		} catch (Throwable e) {errcollector.addError(e);
		}
		driver.findElement(By.cssSelector(".small > a:nth-child(1)")).click();
		Wait(1000);
		try {
			driver.findElement(By.xpath("//div[1]/section[5]/div[1]/div[1]/a"))
					.click();
			assertTrue(TestHomePage
					.IsSignUpShow("//div[1]/section[5]/div[1]/div[1]/a"));
		} catch (Throwable e) {errcollector.addError(e);
		}
		driver.findElement(By.cssSelector(".small > a:nth-child(1)")).click();
		Wait(1000);
		try {
			driver.findElement(By.xpath("//div[1]/section[6]/div[2]/div/a"))
					.click();

			assertTrue(TestHomePage
					.IsSignUpShow("//div[1]/section[6]/div[2]/div/a"));
		} catch (Throwable e) {errcollector.addError(e);
		}
		driver.findElement(By.cssSelector(".small > a:nth-child(1)")).click();
		Wait(1000);
		try {
			driver.findElement(By.xpath("//div[1]/section[7]/div[1]/div[1]/a"))
					.click();
			assertTrue(TestHomePage
					.IsSignUpShow("//div[1]/section[7]/div[1]/div[1]/a"));
		} catch (Throwable e) {errcollector.addError(e);
		}

	}

	 @Test
	public void TestDrag() {
		driver.get(baseUrl);
		Wait(1000);
		// driver.findElement(By.cssSelector("marquee.value.firepath-matching-node")).sendKeys("/Users/michael/Downloads/Link Dots.apk");
		Wait(1000);
		driver.findElement(By.cssSelector(".browse")).sendKeys(
				"/Users/michael/Downloads/Link Dots.apk");
		Wait(1000);
		String status = driver.findElement(
				By.xpath("/html/body/div[1]/section[2]/form/div/i[2]"))
				.getAttribute("msg-progress");
		System.out.println("check status is" + status);
	}

	/*
	 * Function: test if click the button can show sign up dialog
	 */
	public static boolean IsSignUpShow(String locatorName) {
		boolean status = false;
		try {
			Wait(1000);

			if ((main.IsTextPresent("Sign up for your developer account")) == true) {
				status = true;
				System.out.println(locatorName + "can locate sign up");
			} else {
				status = false;
				System.out.println(locatorName + "cannot locate sign up");
			}

		} catch (Throwable e) {
		}
		return status;
	}

	/*
	 * Description: Click some buttons can go to correct url
	 */
	//@Test
	public void CheckButton() throws Exception {
		driver.get(baseUrl);
		Wait(1000);
		/*
		 * Testing: 
		 */
		try {
			driver.findElement(
					By.cssSelector(".site-header > nav:nth-child(5) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1)"))
					.click();
		} catch (Throwable e) {errcollector.addError(e);
		}

		Wait(1000);
		try {
			assertEquals(ExcelUtils.getCellData(sheetName, 3, 2),
					driver.getCurrentUrl());
		} catch (Throwable e) {errcollector.addError(e);
		}
		driver.navigate().back();
		Wait(1000);
		try {
			driver.findElement(By.xpath("//div[1]/header/nav/ul/li[1]/a"))
					.click();
		} catch (Throwable e) {errcollector.addError(e);
		}
		Wait(1000);
		try {
			assertEquals("http://playphone.com/", driver.getCurrentUrl());
		} catch (Throwable e) {errcollector.addError(e);
		}

		driver.navigate().back();
		Wait(1000);
		try {
			driver.findElement(By.xpath("//div[1]/header/nav/ul/li[4]/a"))
					.click();
		} catch (Throwable e) {errcollector.addError(e);
		}
		Wait(1000);
		try {
			assertEquals(ExcelUtils.getCellData(sheetName, 3, 4),
					driver.getCurrentUrl());
		} catch (Throwable e) {errcollector.addError(e);
		}

	}

	public static boolean ClickGoToCorrectUrl(String CorrectUrl) {
		boolean status = false;

		Wait(2000);
		String CheckUrl = driver.getCurrentUrl();
		System.out.println(CheckUrl);
		if (CheckUrl == CorrectUrl) {
			status = true;
			System.out.println("click can go to correct url");
		} else {
			status = false;
			System.out.println("click go to wrong url");
		}

		return status;

	}
	

	@After
	public void close() {
		driver.quit();
	}

	@AfterClass
	public static void teardown() {
		driver.quit();
	}
}