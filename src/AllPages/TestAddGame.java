package AllPages;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.thoughtworks.selenium.*;

public class TestAddGame extends Main_Fun {
	static TestUser_Game Game = new TestUser_Game();
	Main_Fun home=new Main_Fun();
	@Rule
	public ErrorCollector errcollector=new ErrorCollector();	
	/*
	 * Step: To the games page by clicking the side menu games button //*[@id='myGames']
	 */
	public static void GoAddNewGame() throws Exception {
		Game.goGame();
		Wait(1000);
		driver.findElement(By.cssSelector(".ui-item-a-add"))
				.click();
		Wait(2000);
	}

	//@Test
	public void testUrl() throws Exception {
		TestAddGame.GoAddNewGame();
	 System.out.println("add new game url is" +driver.getCurrentUrl());
	try{
	 assertEquals("http://tendra.pp.pluto.vn.ua/games/new",
				driver.getCurrentUrl());}
	catch(Throwable e){
		errcollector.addError(e);
		home.Snapshot((TakesScreenshot)driver, "addGameError.png");
	}
	
	}
	/*
	 * Testing: test general process to create game app name, source, set division and price
	 */
	@Test
	public void GeneralProcess() throws Exception {
		TestAddGame.GoAddNewGame();
		
		try{
		driver.findElement(By.cssSelector(".ui-item-a-add")).click();}
		catch(Exception e){
			errcollector.addError(e);
			Wait(3000);
			home.Snapshot((TakesScreenshot)driver, "error.png");
			}
		//driver.findElement(By.xpath("//*[@id='android']")).click();
Wait(2000);
driver.findElement(By.cssSelector(".active")).click();
Wait(1000);
driver.findElement(By.cssSelector("#html5")).click();	
Wait(1000);
driver.findElement(
		By.cssSelector(".form > div:nth-child(2) > input:nth-child(2)"))
		.sendKeys("www.abc.com");
Wait(1000);

		
driver.findElement(By.cssSelector("#android")).click();	
Wait(1000);
driver.findElement(
		By.cssSelector("input.ng-invalid"))
		.sendKeys("game12 name !@ $%");
		
		
		Wait(1000);
		driver.findElement(By.cssSelector("input.image-input-field")).sendKeys(
				"/Users/michael/Desktop/Screen.png");
		// WebElement element =
		// driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div[2]/div/div[1]"));
		// Actions actions = new Actions(driver);
		// actions.moveToElement(element).click().perform();
		/*
		 * driver.findElement(By.xpath(
		 * "//div[3]/div/div[2]/div/div[1]/div/div[2]/form/div[5]/div[2]/div/div[1]"
		 * )).click(); Wait(2000);
		 * driver.findElement(By.xpath("//div[@value='CH']")).click();
		 * Wait(2000);
		 */
	try{
		driver.findElement(By.cssSelector("textarea.ng-pristine")).sendKeys("ABC@#%$&^*(0986dfkie");
	}
catch(Throwable e){errcollector.addError(e);
System.out.println("cannot type");}
	
		
		
		//Select Primary option
	try{	
		/*
		 * Step: Select classic & Arcade option under primary
		 */
		Actions PrimaryAction  = new Actions(driver);
		WebElement PrimaryKey = driver.findElement(By.cssSelector("div.form-row:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1)"));
		PrimaryAction.moveToElement(PrimaryKey).moveToElement(driver.findElement(By.cssSelector("html.ng-scope body div#container.ng-scope div.ng-scope div#holder.ng-scope div#wrapper div#content.ng-scope div#contentInner.main-content div.row.gameGeneralPage.ng-scope div.col.col-xl-6.col-lg-6.col-md-6 div.section div.section div.content form.ng-pristine.ng-valid-url.ng-valid.ng-valid-required div.form-group.segmented div.form-row div.form-col.right div.form-control.combo-box.ng-isolate-scope.ng-valid.ng-valid-required div.options.ng-scope div.scrollbar.content div.option.ng-binding.ng-scope"))).click().build().perform();

		Wait(1000);
		//driver.findElement(
			//	By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/div[2]"))
			//	.click();
		Wait(1000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/div[3]"))
				.click();
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[2]/div[2]/div[1]/div/div[2]/div/div[4]"))
				.click();
		Wait(1000);
		    //Select secondary
		/*driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[2]/div/div[4]"))
				.click();
		//Select Secondary option
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[2]/div/div[5]"))
				.click();
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[1]/div[3]/div[2]/div/div/div[2]/div/div[6]"))
				.click();
		Wait(1000);*/

		// Select US Content Rating 
		driver.findElement(
				By.cssSelector("div.form-control:nth-child(2) > div:nth-child(1)"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/div[2]/div/div[2]"))
				.click();
		Wait(1000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/div[2]/div/div[3]"))
				.click();
		Wait(1000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/div[1]"))
				.click();
		Wait(2000);
		driver.findElement(
				By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[2]/div[2]/div/div[2]/div/div[4]"))
				.click();
		Wait(1000);}
	catch(Throwable e){errcollector.addError(e);}
		
		
			//cannot locate Privacy Policy
	//	String a = driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[3]/input")).getText();
		
	/*driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[3]/input")).clear();
		driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[1]/div/div[3]/div[2]/form/div[3]/input")).sendKeys("abc");
		Wait(2000);*/
	//	System.out.println(a);
		
		/*
		 * uncheck DISTRIBUTION PREFERENCES on SouthEast Asia
		 */
		
	//	WebElement element =
		//		driver.findElement(By.cssSelector("span.drop-down"));
			//	 Actions actions = new Actions(driver);
				// actions.moveToElement(element).click().perform();
		//driver.findElement(By.cssSelector("div.top-row > span.drop-down")).click();
		Wait(1000);
		
		//uncheck Verzon store
		//driver.findElement(By.cssSelector("span.show-carriers-toggler")).click();
		Wait(1000);
		//driver.findElement(By.cssSelector("span.carrier-check-box")).click();
		//Wait(1000);
		try{
		WebElement element =
					driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/span[1]"));
						 Actions actions = new Actions(driver);
						 actions.moveToElement(element).click().perform();
						 Wait(1000);
		
		//driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/span[1]")).click();
		String b=driver.findElement(By.xpath("//div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div[3]/div/div[1]/span[2]/div/div")).getAttribute("data-carriers-count");
		System.out.println(b);}
		catch (Throwable e) {errcollector.addError(e);}
	/*
	 * check priceing model
	 */
		driver.findElement(By.cssSelector("#price-model-option-premium")).click();
		Wait(1000);
		driver.findElement(By.cssSelector("#base-price")).sendKeys("40");
		Wait(1000);
		String s=driver.findElement(By.cssSelector("#platform_1001_price")).getAttribute("value");
		System.out.println("price list is"+s);
		assertEquals("40", s);
		
		WebElement element1 =
				driver.findElement(By.cssSelector("button.ng-scope:nth-child(4)"));
					 Actions actions1 = new Actions(driver);
					 actions1.moveToElement(element1).click().perform();
					 Wait(1000);
		
		//driver.findElement(By.xpath("//div[3]/div/div[1]/span[2]/button[2]")).click();
		String GEcheck = driver.findElement(
				By.xpath("//div[3]/div/ul/li[1]/span"))
				.getAttribute("class");
		System.out.println("color is" + GEcheck);
		assertEquals("icon right check-green", GEcheck);
		}
	/*
	 * Testing: check Images&Mutimedia process 
	 */
	@Test
	public void ImagesMuti() throws Exception{
		Game.goGame();
		Wait(1000);
		/*
		 * choose the existing game " game12 name !@ $% " to add images
		 */
		driver.findElement(By.cssSelector("div.ng-scope:nth-child(5) > div:nth-child(1) > div:nth-child(2)")).click();
		//driver.findElement(By.xpath("//div[1]/div/ul/li[3]/a")).click();
		Wait(2000);
		driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(4)")).click();
		Wait(1000);
		driver.findElement(By.cssSelector("#contentInner > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > input:nth-child(3)")).sendKeys(
				"/Users/michael/Documents/GameSource/image/homescreen.png");
		Wait(1000);
		WebElement element1 =
				driver.findElement(By.cssSelector("#contentInner > div:nth-child(2) > div:nth-child(1) > div > div.content > form > div > div.game-assets-container.clearfix > div > input"));
					 Actions actions1 = new Actions(driver);
					 actions1.moveToElement(element1).click().sendKeys("/Users/michael/Documents/GameSource/image/GamePage.png").perform();
					 Wait(1000);
		
		//driver.findElement(By.cssSelector("#contentInner > div:nth-child(2) > div:nth-child(1) > div > div.content > form > div > div.game-assets-container.clearfix > div > input")).sendKeys(
			//	"/Users/michael/Documents/GameSource/image/GameScreenShot.png");
		Wait(1000);
		driver.findElement(By.cssSelector("div.row:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > form:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1)")).sendKeys(
				"/Users/michael/Documents/GameSource/image/GamePage.png");
		
		assertTrue(home.VerifyElementPresent("//div[3]/div/div[2]/div[1]/div[1]/div/div[2]/form/div/div[3]/div[4]/img"));		
		Wait(1000);
		
		driver.findElement(By.xpath("//div[3]/div/div[2]/div[3]/div/div/div[2]/form/div/div[3]/div/input")).sendKeys(
				"/Users/michael/Documents/GameSource/image/GamePage.png");
		Wait(2000);
			assertTrue(home.VerifyElementPresent("//div[3]/div/div[2]/div[3]/div/div/div[2]/form/div/div[3]/div[2]/img"));
			
			Wait(1000);
			
			
			
			driver.findElement(By.xpath("//div[3]/div/div[2]/div[1]/div[2]/div/div[2]/form/div/div[3]/div/input")).sendKeys(
					"/Users/michael/Documents/GameSource/image/GamePage.png");
			Wait(2000);
			assertTrue(home.VerifyElementPresent("//div[3]/div/div[2]/div[1]/div[2]/div/div[2]/form/div/div[3]/div[2]/img"));
		
			
			Wait(1000);
			
			driver.findElement(By.xpath("//div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[3]/div/input")).sendKeys(
					"/Users/michael/Documents/GameSource/image/GamePage.png");
			Wait(2000);
			
			assertTrue(home.VerifyElementPresent("//div[3]/div/div[2]/div[2]/div[2]/div/div[2]/form/div/div[3]/div[2]/img"));
			
			/*
			 * Step: click next button
			 */
			WebElement element =
					driver.findElement(By.xpath("//div[3]/div/div[1]/span[2]/button[2]"));
						 Actions actions = new Actions(driver);
						 actions.moveToElement(element).click().perform();
						 Wait(1000);
			}
	@Test
	public void InAppProduct() throws Exception{
		Game.goGame();
		Wait(1000);
		/*
		 * choose the existing game " game12 name !@ $% " to add in-app product option
		 */
		driver.findElement(By.cssSelector("#myGames")).click();
		Wait(1000);
		driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(5)")).click();
		Wait(2000);
		/*
		 * Testing: mouse over "Filter" button and check if all characters are there and clickable
		 */
		home.VerifyElementClickablemouseover("//div[3]/div/div[2]/div[2]/span[1]/span[2]", "//div[3]/div/div[2]/div[2]/span[1]/span[2]/div/ul/li[2]/span[2]/input");
		home.VerifyElementClickablemouseover("//div[3]/div/div[2]/div[2]/span[1]/span[2]", "//div[3]/div/div[2]/div[2]/span[1]/span[2]/div/ul/li[1]/span[2]/input");
		
	 driver.findElement(By.cssSelector("div.has-tooltip.ui-item-a-add")).click();
	 Wait(2000);
	  String WindowTitleCurrent=driver.getTitle();
		System.out.println(WindowTitleCurrent);
		//driver.findElement(By.cssSelector("li.selected:nth-child(1) > span:nth-child(1)")).click();
		driver.findElement(By.cssSelector("div.segmented:nth-child(1) > label:nth-child(5) > span:nth-child(2)")).click();
		Wait(1000);
		driver.findElement(By.cssSelector(".image-input-field")).sendKeys("/Users/michael/Documents/GameSource/image/Screen.png");
		Wait(1000);
		driver.findElement(By.cssSelector("input.ng-invalid:nth-child(2)")).sendKeys("!@#123Asdf");
		Wait(1000);
		driver.findElement(By.cssSelector("#virtual_item_quantity")).sendKeys("100");
		Wait(1000);
		driver.findElement(By.cssSelector(".google-product > input:nth-child(2)")).sendKeys("ABC#$A%12");
		Wait(1000);
		//driver.findElement(By.cssSelector(".customized-input")).click();
		//Wait(1000);
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.cssSelector(".customized-input"));
		action.moveToElement(we).moveToElement(driver.findElement(By.cssSelector(".disabled-status"))).click().build().perform(); // Select "Disabled" under status menu
		Wait(1000);
		driver.findElement(By.cssSelector(".last > span:nth-child(1)")).click(); // Go to pricing option
		Wait(1000);
		/*
		 * Check add in-app product general & pricing is completed (will have right icon green) or not.
		 */
		
		String GeneralColor = driver.findElement(
				By.xpath("/html/body/div[5]/div[2]/div/div/ul/li[1]"))
				.getAttribute("class");
		System.out.println("general is" + GeneralColor);
		assertEquals("tab completed",GeneralColor );
		
		String PriceColor=driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div/ul/li[2]")).getAttribute("class");
		System.out.println("pricing is" + PriceColor);
		assertEquals("tab last selected",PriceColor );
		driver.findElement(By.cssSelector("#base-price")).sendKeys("40");
	    Wait(1000);
		
		driver.findElement(By.cssSelector(".pull-right")).click();
		Wait(2000);
		
		/*
		 * Check add in-app product name to see whether it is been created
		 */
		String InAppNew=driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div[3]/div[2]/div/div/i[2]")).getText();
		System.out.println("New in app product name is"+InAppNew);
		assertEquals("!@#123Asdf",InAppNew );
		/*
		 * Check  in-app product icon is green or not
		 */
		String InAppProFlag=driver.findElement(By.cssSelector("li.tab:nth-child(5) > span:nth-child(2)")).getAttribute("class");
		System.out.println(InAppProFlag);
		assertEquals("icon right check-green",InAppProFlag);
		/*
		 * delete the new In App product to clear data for next time use
		 * There is gerinic dialog so cannot click "confirm" button to delete
		 */
		Actions action1 = new Actions(driver);
		WebElement Edit1 = driver.findElement(By.cssSelector(".gear"));
		action1.moveToElement(Edit1).moveToElement(driver.findElement(By.cssSelector("div.align-right:nth-child(2) > ul:nth-child(1) > li:nth-child(2) > span:nth-child(2) > span:nth-child(1)"))).click().build().perform(); // Select "Disabled" under status menu
		Wait(1000);
	 
	}
	@Test
	public void CheckLeaderboards() throws Exception{
		Game.goGame();
		Wait(1000);
		/*
		 * choose the existing game " game12 name !@ $% " to  Leaderboards option
		 */
		driver.findElement(By.cssSelector("#myGames")).click();
		Wait(1000);
		driver.findElement(By.cssSelector("div.ng-scope:nth-child(5) > div:nth-child(1) > div:nth-child(2)")).click();
		Wait(2000);
		
		/*
		 *  click Leaderboards tag
		 */
		driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(6)")).click(); 
		Wait(1000);
		/*
		 *   click "add Leaderboard" button
		 */
		driver.findElement(By.cssSelector(".add-item-button")).click(); 
		Wait(1000);
		/*
		 *   Fill the info of Leaderboard, input name, choose Desending, current scroe
		 */
		driver.findElement(By.cssSelector("input.value:nth-child(2)")).sendKeys("ASD!@#123zxc()");
		Wait(1000);
		Actions Orderaction = new Actions(driver);
		WebElement OrderEdit = driver.findElement(By.cssSelector("div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"));
		Orderaction.moveToElement(OrderEdit).moveToElement(driver.findElement(By.cssSelector("div.form-group:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)"))).click().build().perform(); 
		Wait(1000);
		Actions Methodaction = new Actions(driver);
		WebElement MethodEdit = driver.findElement(By.cssSelector("div.form-group:nth-child(3) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)"));
		Methodaction.moveToElement(OrderEdit).moveToElement(driver.findElement(By.cssSelector("div.form-group:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2)"))).click().build().perform(); 
		Wait(1000);
		/*
		 *   Click save and continue
		 */
		driver.findElement(By.cssSelector(".pull-right")).click();
		Wait(1000);
		/*
		 *   Notice: need to implement changing status when developping is done
		 */
		
		String LeaderboardName= driver.findElement(By.cssSelector("td.name-col")).getText();
		System.out.println("name is"+LeaderboardName);
		String AggregationName=driver.findElement(By.cssSelector("td.aggregation-col")).getText();
		System.out.println("name is"+AggregationName);
		/*
		 *   Verify: Check if LeaderboardsFlag icon is turn to green or not
		 */
		String LeaderboardsFlag=driver.findElement(By.cssSelector("li.tab:nth-child(6) > span:nth-child(2)")).getAttribute("class");
		System.out.println(LeaderboardsFlag);
		assertEquals("icon right check-green",LeaderboardsFlag);
	}
	@Test
		public void CheckAchievement() throws Exception{
			Game.goGame();
			Wait(1000);
			/*
			 * choose the existing game " game12 name !@ $% " to add in-app product option
			 */
			driver.findElement(By.cssSelector("#myGames")).click();
			Wait(1000);
			driver.findElement(By.cssSelector("a.ui-checkbox-after:nth-child(7)")).click();
			Wait(1000);
			/*
			 * Step: Go to Achievements tag 
			 * Verify: If "Achievements" text is present on the page
			 */
			driver.findElement(By.cssSelector("li.tab:nth-child(7) > a:nth-child(1)")).click();
			Wait(1000);
			assertTrue(home.IsTextPresent("Achievements"));
			/*
			 * Step: Click "Add Achievement" button 
			 */
			driver.findElement(By.cssSelector(".has-tooltip")).click();
			Wait(1000);
			/*
			 * Step: Fill the Achievement with Points, name, Icon image, Description, Visibility* is "Visible" 
			 */
			driver.findElement(By.cssSelector("input.ng-dirty:nth-child(2)")).sendKeys("250");
			Wait(1000);
			driver.findElement(By.cssSelector("input.ng-pristine")).sendKeys("ABC!@#123");
			Wait(1000);
			driver.findElement(By.cssSelector(".image-input-field")).sendKeys("/Users/michael/Documents/GameSource/image/Screen.png");
			Wait(1000);
			driver.findElement(By.cssSelector("textarea.value")).sendKeys("!@#$%();sdfjiet<>?");
		    Wait(1000);
		    /*
			 * Step: Click "Save and continue" button
			 */
            driver.findElement(By.cssSelector(".pull-right")).click();
            Wait(1000);
	}
	//@After
	public void close() {
		driver.quit();
	}
	public static boolean switchToWindow(String windowTitle){
		
			    boolean flag = false;
		
			    try {
		
			        String currentHandle = driver.getWindowHandle();
		
			        Set<String> handles = driver.getWindowHandles();
		
			        for (String s : handles) {
		
			            if (s.equals(currentHandle))
		
			                continue;
		
			            else {
		
			                driver.switchTo().window(s);
		
			                if (driver.getTitle().contains(windowTitle)) {
		
			                    flag = true;
		
			                    System.out.println("Switch to window: "
		
			                            + windowTitle + " successfully!");
		
			                    break;
		
			                } else
		
			                    continue;
		
			            }
		
			        }
		
			    } catch (NoSuchWindowException e) {
		
			        System.out.println("Window: " + windowTitle
		
			                + " cound not found!");
		
			        flag = false;
		
			    }
		
			    return flag;
		
			}
	
}
