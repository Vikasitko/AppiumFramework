package VikasKumar;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_01_FillForm extends BaseTest{
	
	@Test(enabled = false)
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vikas Kumar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		String country = "Argentina";
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + country + "']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(50000);
		}

	// error message verification
		@Test
		
		public void toastErrorMessage()
		{
			//android.widget.Toast  -- if toast message is there , this will be the tag name
			
			//for toast, attribute will be "name"
			
			driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
			String error = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getText();
			String toastMessage = driver.findElement(AppiumBy.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
			System.out.println(error);
			System.out.println(toastMessage);
			Assert.assertEquals(toastMessage, "Please enter your name");
		}
}
