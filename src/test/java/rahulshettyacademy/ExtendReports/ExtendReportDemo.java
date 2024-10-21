package rahulshettyacademy.ExtendReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
	
	ExtentReports extent;
	
	@BeforeTest
	public void config() {
		
		// ExtentReport, ExtentSparkReporter
		String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + "index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Albina");
	}
	
	@Test
	public void initialDemo() {
		
		ExtentTest test = extent.createTest("Initial Demo");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();
		
		test.fail("Results do not match");
		
		//test.addScreenCaptureFromBase64String(null)
		
		extent.flush();
	}
}
