package VikasKumar;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AndroidDriver  driver;
	
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws InterruptedException, MalformedURLException
	{
		       service = new  AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\vikas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(20)).build();
				
				service.start();
				
				UiAutomator2Options options = new UiAutomator2Options();
				options.setDeviceName("VikasEmulator");
				//to run on chrome  after moving from app to web 
				//options.setChromedriverExecutable("/Users/kmieshkov/Projects/IdeaProjects/appium-General-Store/src/test/resources/chromedriver");
				//options.setApp(System.getProperty("user.dir")+"\\Workspace\\automation\\AppiumFramework\\AppiumFramework\\src\\test\\java\\resources\\ApiDemos-debug.apk");
				
				//options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\appium-api-demos-3-3-1.apk");
				
				options.setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\General-Store.apk");
				Thread.sleep(10000);
				driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void longPressAction(WebElement ele)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",  ImmutableMap.of("elementId", ((RemoteWebElement)ele).getId(),"duration", 2000));
		
	}
	
	public void scrollToendAction()
	{
		//no prior idea
				boolean canScrollMore;
				do {
			        canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					    "left", 100, "top", 100, "width", 200, "height", 200,
					    "direction", "down",
					    "percent", 1.0
					));
				}while(canScrollMore);
				
	}
	
	public void swipeAction(WebElement ele, String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public void waitForElementAttributeToBeEqual(String elementId, String attribute, String value) {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.attributeContains(AppiumBy.id(elementId), attribute, value));
	}
	
	public double getFormattedAmount(String amount)
	{
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		//stop server
				service.stop();
				
	}
}
