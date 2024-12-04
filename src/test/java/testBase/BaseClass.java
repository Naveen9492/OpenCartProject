package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"os","browser"})
	public void startSetup(String os , String br) throws IOException {
		
		logger = LogManager.getLogger(this.getClass());
		//loading values from config.properties file
		FileReader f = new FileReader("./src/test/resources/config.properties");
		p= new Properties();
		p.load(f);
		
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capab =  new DesiredCapabilities();
			if (os.equalsIgnoreCase("windows")) {
				capab.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capab.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("invalid os platform");
				return;
			}
			
			switch (br.toLowerCase()) {
			case "chrome" : capab.setBrowserName("chrome"); break;
			case "firefox" : capab.setBrowserName("firefox"); break;
			case "edge" : capab.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No macthing browser"); return;
			}
			driver = new RemoteWebDriver(new URL("http://192.168.123.102:4444/wd/hub") , capab);
			
		}
		if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(br.toLowerCase()) 
			{
			case "chrome":  driver = new ChromeDriver(); break;
			case "edge" : driver = new EdgeDriver(); break;
			case "firefox" : driver = new FirefoxDriver(); break;
			default : System.out.println("Invalid browser"); return;
			}
		}
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
	}
	
	@AfterClass(alwaysRun = true)
	public void tearSetup() {
		driver.quit();
	}
	
	public String randomString() {
		String randomString = RandomStringUtils.randomAlphabetic(6);
		return randomString;
	}
	
	public String randomNumers() {
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomNumber;
	}
	
	public String randomPassword() {
		String randomString = RandomStringUtils.randomAlphabetic(6);
		String randomNumber = RandomStringUtils.randomNumeric(10);
		return randomString+"@"+randomNumber;
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

	
}
