package VikasKumar;
import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;



public class ScrollDemo extends BaseTest{
	
	@Test
	public void ScrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		//it is used for scrolling and where to scroll is known prior
		//google engine 
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		Thread.sleep(10000);
		
		//no prior idea
		scrollToendAction();
		
		
	}

}
