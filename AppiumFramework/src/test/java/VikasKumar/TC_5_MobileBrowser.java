package VikasKumar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_5_MobileBrowser extends BroserBaseTest{
	

	// mobile Chrome browser test
	// here is no Appium since it's browser
	// selenium only
	@Test
	public void browserTest() {
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Selenium Webdriver");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	// scrolling in mobile browser
	@Test(enabled = false)
	public void scrollTest() {
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
		driver.findElement(By.xpath("//a[@routerlink='/products']")).click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
		String text = driver.findElement(By.xpath("//a[@href='/angularAppdemo/products/3']")).getText();
		Assert.assertEquals(text, "Devops");
	}

}
