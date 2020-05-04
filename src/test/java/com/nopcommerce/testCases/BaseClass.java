package com.nopcommerce.testCases;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.nopcommerce.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUseremail();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	@Parameters("browser")
	public void setup(String br)
	{
		logger=Logger.getLogger("nopEcommerce");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			
			//download files in required location using chrome
			
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();

			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.prompt_for_download", "false");
			chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "//DownloadFiles"); //configure path

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", chromePrefs);

			DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			cap.setCapability(ChromeOptions.CAPABILITY, options);  // end of code
						
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver=new ChromeDriver(cap);	
		}
		else if (br.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver=new FirefoxDriver();
			
		}
		else if (br.equals("ie")) {
			
			System.setProperty("webdriver.chrome.driver", readconfig.getIEpath());
			driver=new InternetExplorerDriver();
						
		}
				
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
		
	}
	
	public static String randomestring() {
		
		String generatedString1= RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}
	
	public static String randomeNum() {
		
		String generatedString2= RandomStringUtils.randomNumeric(4);
		return (generatedString2);
		
	}
	
	
}
