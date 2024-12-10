package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));    
        }
    
    public boolean waitVisibility(By elementBy) {
        List<WebElement> present=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        if (present==null) 
        	return false;
        	else 
        		return true;
    }
    
    public boolean click (By elementBy) {
        if (waitVisibility(elementBy)==true) {
        	driver.findElement(elementBy).click();
        	return true;}
        else
        	return false;
    }
    
    public boolean writeText (By elementBy, String text) {
        if (waitVisibility(elementBy)==true) {
        	driver.findElement(elementBy).sendKeys(text);
        	return true;}
        else
        	return false;
    }
    
    public String readText (By elementBy) {
    	if (waitVisibility(elementBy)==true) {
    		return driver.findElement(elementBy).getText();
    	}
    	else
    		return "No encontrado";
    }
    
    public boolean assertEquals (By elementBy, String expectedText) {
    	if (waitVisibility(elementBy)==true) {
    		Assert.assertEquals(readText(elementBy), expectedText);
    		return true;
    	}
    	else
    		return false;
    }
}
