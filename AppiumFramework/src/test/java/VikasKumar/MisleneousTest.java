package VikasKumar;
import java.net.MalformedURLException;

import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class MisleneousTest extends BaseTest{
	
	@Test
	public void MislenousTest() throws MalformedURLException, URISyntaxException, InterruptedException
	{
		//App Package and app activity
		//adb devices ---run in cmd and run below command to check where is your control  for window
		//adb shell dumpsys window | find "mCurrentFocus"
		
		//result is -- mCurrentFocus=Window{ebfdcbe u0 io.appium.android.apis/io.appium.android.apis.preference.FragmentPreferences
		
		Activity activity = new Activity("io.appium.android.apis","io.appium.android.apis.preference.FragmentPreferences");
		//driver.startActivity(activity);
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of(
				"intent","io.appium.android.apis/io.appium.android.apis.preference.FragmentPreferences"
			   
			));
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		//rotate by 90 degree
		
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		//copy paste
		//copy to clipboard- paste it clipboard
		
		driver.setClipboardText("Vikas Wi Fi");
		
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		
		//set wifi name
		driver.findElement(By.id("android:id/edit")).sendKeys("Vikas Wi Fi");
		
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	

	
		
		
	}

}
