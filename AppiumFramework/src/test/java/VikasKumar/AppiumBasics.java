package VikasKumar;
import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;



public class AppiumBasics extends BaseTest{
	
	@Test
	public void wifiSettingName() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		//androidDriver
		//Appium code->Appium server- >Mobile device
		//appium server start programmatically 
	
		//options.setApp(System.getProperty("C:\\Users\\vikas\\OneDrive\\Desktop\\Appium\\apkfiles\\appium-api-demos-3-3-1.apk"));
		
		
		//if java 20 is there then use URI
		//AndroidDriver  driver =  new AndroidDriver(new URI("http://192.168.29.112:4723").toURL(),options);
		//ConfigureAppium(); now it is not required because we have given tag as @BeforeClass to run this method before running this test method
		
		//xpath , id, accessibility, classname, androidUIAutomator 
		 //user AppiumBy with  accessibility, classname, androidUIAutomator 
		//we can write locator value with //tagName
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");
		//set wifi name
		driver.findElement(By.id("android:id/edit")).sendKeys("Vikas Wi Fi");
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	

	
		
		
	}

}
