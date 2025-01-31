package testScenarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    
    @BeforeClass
    public void setup () throws Exception {
	/*	ChromeOptions handlingSSL = new ChromeOptions();
		handlingSSL.setAcceptInsecureCerts(true);
    	driver = new ChromeDriver(handlingSSL);*/
    	driver = new ChromeDriver();

        driver.manage().window().maximize();
    }
    
    @AfterClass
    public void teardown () {
        driver.quit();
    }
    
    @AfterMethod
    public void failureSetup(ITestResult result) throws IOException {
        Reporter.setCurrentTestResult(result);
        File img = new File(System.getProperty("user.dir")+"/test-output/screen_"+result.getMethod().getMethodName()+".png");
        if(result.getStatus() == 2){ 
            Reporter.log("This is screenshot from failed scenario", true);
            FileOutputStream screenshotStream = new FileOutputStream(img);
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
            Reporter.log(" <a href='"+img.getAbsolutePath()+"'> <img src='"+ img.getAbsolutePath()+"' height='200' width='200'/> </a>  ");
        }
    }

}
