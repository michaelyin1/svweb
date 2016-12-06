package AllPages;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;

import utility.ExcelUtils;

public class Main_Fun {
	public static WebDriver driver;
	public WebDriverWait wait;
	@Rule
	public ErrorCollector errcollector = new ErrorCollector();

	/*
	 * @Before annotation will set and run chrome driver path and manage web
	 * window to maximum size
	 */

	@Before
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"/Users/michael/Documents/automation tool/plugin/chromedriver");
		driver = new ChromeDriver();
		Point targetPosition = new Point(0, 0);
		driver.manage().window().setPosition(targetPosition);

		// Dimension targetSize = new Dimension(1920, 1080); // your screen
		Dimension targetSize = new Dimension(1280, 720); // resolution here
		driver.manage().window().setSize(targetSize);

	}

	/*
	 * @IsTestPresent function will check if Text is present on the page
	 */
	public static boolean IsTextPresent(String content) {
		boolean status = false;
		if (driver.getPageSource().contains(content)) {
			status = true;
			System.out.println(content + "is Present");
		} else {
			status = false;
			System.out.println(content + "is Absent");
		}
		return status;
	}

	public static boolean IsTextNotPresent(String content) {
		boolean status = true;
		if (driver.getPageSource().contains(content)) {
			status = false;
			System.out.println(content + "is Present");
		} else {
			status = true;
			System.out.println(content + "is Absent");
		}
		return status;
	}

	public static boolean VerifyElementPresent(String xpathlocator) {
		boolean present = false;
		try {
			driver.findElement(By.xpath(xpathlocator));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		return present;
	}

	public static boolean VerifyElementTextNotPresent(String searchWord,
			String csslocator) {
		boolean flag = true;

		if (driver.findElement(By.cssSelector(csslocator))
				.getAttribute("class").contains(searchWord)) {
			flag = false;
		} else {
			flag = true;
		}

		return flag;
	}

	/*
	 * Function:verify Element contains some keyword in class attribute can
	 * active. For example: manage profile after fill in info can active the
	 * section with checked box green color
	 */
	public static boolean VerifyElementTextPresent(String searchWord,
			String csslocator) {
		boolean flag = false;

		if (driver.findElement(By.cssSelector(csslocator))
				.getAttribute("class").contains(searchWord)) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public static void VerifyElementClickablemouseover(String MouseOverXpath,
			String ElementXpath) {

		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(MouseOverXpath));
		action.moveToElement(we)
				.moveToElement(driver.findElement(By.xpath(ElementXpath)))
				.click().build().perform();
	}

	public void switchTowindow(String windowTitile) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handler : windowHandles) {
			driver.switchTo().window(handler);
			String title = driver.getTitle();
			if (windowTitile.equals(title)) {
				break;
			}
		}
	}

	/*
	 * Function: This function will take screen shot ,require two parameters
	 * ,one is driver name, another is file name
	 */
	public static void Snapshot(TakesScreenshot drivername, String filename) {

		String currentPath = "/Users/michael/Documents"; // Screenshot path
		System.out.println(currentPath);
		// Call screenshot funtion
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			// copy to directory, print error message
			Wait(3000);
			System.out.println("save snapshot path is:" + currentPath + "/"
					+ filename);
			FileUtils.copyFile(scrFile, new File(currentPath + "/" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}

	public static void Wait(int t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}
