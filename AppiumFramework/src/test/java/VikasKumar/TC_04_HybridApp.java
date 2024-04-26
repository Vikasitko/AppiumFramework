package VikasKumar;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC_04_HybridApp extends BaseTest{
	
	// positive test
		// review Term and Conditions
	@Test
	public void HybridAppTest() throws InterruptedException
	{
		//precondition - fill form, add items to cart
				addItemsToCart();
				
				//go to web page
				driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnProceed")).click();
				Thread.sleep(5000);
				
			//switch to Web Model
			//transfer from app to web view
			Set<String> contexts = driver.getContextHandles();
			
			for(String contextName:contexts)
			{
				System.out.println(contextName);
			}
			
			Thread.sleep(5000);
			
			// need to know the exact name of the context
			driver.context("WEBVIEW_com.androidsample.generalstore");
			
			//driver.context("WebView"); //context name might be different so check once with dev
			Thread.sleep(50000);
			// Hybrid -> Google webpage
			driver.findElement(By.name("q")).sendKeys("Hybrid app");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

			// close browser by pressing Android Back key
			driver.pressKey(new KeyEvent(AndroidKey.BACK));

			// switch to native app context
			driver.context("NATIVE_APP");
	   
		
	}
	
	private void addItemsToCart() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Vikas Kumar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		String country = "Argentina";
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"));
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + country + "']")).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		// wait for the title to be equal Products
				waitForElementAttributeToBeEqual("com.androidsample.generalstore:id/toolbar_title", "text", "Products");
				
				//add item to the cart
		
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		//to add 2nd item since first one is added so only one will be there and so use get(0)
		
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		

		// go to cart
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	   Thread.sleep(5000);
	// wait for the title to be equal Cart
			waitForElementAttributeToBeEqual("com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
			
	
			Thread.sleep(5000);
			System.out.println("the cart name is " +driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")).getText());
			
			
			driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
			
			
	}



	
}
