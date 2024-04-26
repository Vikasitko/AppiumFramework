package VikasKumar;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_03_VerifyCartAmount extends BaseTest{
	
	// positive test
		// review Term and Conditions
	@Test
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
		
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
		//to add 2nd item since first one is added so only one will be there and so use get(0)
		
		driver.findElements(AppiumBy.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	   
	// wait for the title to be equal Cart
			waitForElementAttributeToBeEqual("com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
			List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
			int productCount = productPrices.size();
			double totalSum = 0;
			for(int i = 0; i <productCount; i++)
			{
				String amountString= productPrices.get(i).getText();
				//$1345.98 so it will give data from position 1
				Double price= getFormattedAmount(amountString);
				
				totalSum = totalSum +price;
			}
			
			
			String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
			Double displayeFormattedSum= getFormattedAmount(displaySum);
			
			Assert.assertEquals(totalSum, displayeFormattedSum);
			
			WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			
			longPressAction(ele);
			String alertTitle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/alertTitle")).getText();
			Assert.assertEquals(alertTitle, "Terms Of Conditions");
			Thread.sleep(3000);
			//to close pop up
			driver.findElement(By.id("android:id/button1")).click();
			
			driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
			
			driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			
			Thread.sleep(2000);
			
			//Handle objects when rendered in Web view
			//Hybrid-Google Page->
			//need to context switch
	   
	   
	}



	
}
