package VikasKumar;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class TC_02_VerifyItemInCart extends BaseTest{
	
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
		Thread.sleep(1000);
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
	   int productCount= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	   
	   for(int i = 0; i<productCount; i++)
	   {
		   String productName =driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		   if(productName.equalsIgnoreCase("Jordan 6 Rings"))
		   {
			   driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		   }
	   }
	   
	   driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	   
	// wait for the title to be equal Cart
			waitForElementAttributeToBeEqual("com.androidsample.generalstore:id/toolbar_title", "text", "Cart");
	   
	  
	   String lastpageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();	
		Assert.assertEquals(lastpageProduct, "Jordan 6 Rings");	   
	}

	
}
