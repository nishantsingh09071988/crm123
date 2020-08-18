package crm123test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mytestdemo 
{
	ExtentHtmlReporter htmlReporter;

	ExtentReports extr;
	 WebDriver driver;


	@BeforeSuite
	public void startupclass()
	{
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extr = new ExtentReports();
		extr.attachReporter(htmlReporter);




	}
	@BeforeTest
	public void start() throws Exception
	{
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	}




	@Test
	public void nicktest() throws Exception 
	{

		ExtentTest test=extr.createTest("myfirsttest", "nishant demo");
		
		driver.get("https://rms.koenig-solutions.com/");
		test.pass("nav to rms ");
		test.log(Status.INFO, "This step shows usage of log(status, details)");


		test.info("This step shows usage of info(details)");


		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());


		test.addScreenCaptureFromPath("screenshot.png");

	}
	@Test
	public void nicktest1() throws Exception 
	{

		ExtentTest test=extr.createTest("myfirsttest", "nishant demo");
		test.log(Status.INFO, "This step shows usage of log(status, details)");


		test.info("This step shows usage of info(details)");


		test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());


		test.addScreenCaptureFromPath("screenshot.png");

	}
	@AfterTest
	
	public void teardown()
	{
		
		driver.close();
		driver.quit();
		System.out.println("closed");
	}
	
	
	
	@AfterSuite

	public void closetest() 
	{

		extr.flush();

	}


}
