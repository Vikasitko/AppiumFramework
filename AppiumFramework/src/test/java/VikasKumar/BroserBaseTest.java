package VikasKumar;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BroserBaseTest {

	public AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException, InterruptedException {
		 service = new  AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\vikas\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(20)).build();
					
		service.start();


		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("VikasEmulator");
		
		options.setChromedriverExecutable(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\chromeDriver.exe");
	
		options.setCapability("browserName", "Chrome");
		
		Thread.sleep(10000);
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}



	@AfterClass
	public void TearDown() {
		driver.quit();
		service.stop();
	}
}