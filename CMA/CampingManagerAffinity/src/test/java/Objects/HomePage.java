package Objects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.tools.ant.util.FileUtils;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

public class HomePage extends BasePage {
  
	    public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		String baseURL = "";
		JSONObject obj = null;

	    By campaignManagerLavel = By.cssSelector("form[class='ng-untouched ng-pristine ng-valid'] h2 strong");
		By vamosButton = By.cssSelector(".login-form-field.mat-raised-button.mat-primary");
		By loginButton = By.xpath("//span[normalize-space()='Active Directory']");
		
		By userNameField = By.cssSelector("#userNameInput");
		By passwordField = By.cssSelector("#passwordInput");
		By iniciarSesionButton = By.cssSelector("#submitButton");
	     
	    public static String getJSONFromFile(String fileName) {
	    	String jsonText = "";
	    	try {
	    		BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
	    		String line;
	    		while ((line = bufferedReader.readLine()) != null) {
	    			jsonText += line + "\n";
	    		}
	    		bufferedReader.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return jsonText;
	    }
	    	    
	    public HomePage goToAutomationExercise () throws Exception{
	    	String strnJson = getJSONFromFile(System.getProperty("user.dir")+"/src/test/java/Resources/GlobalData.json");
	    	obj = new JSONObject(strnJson);
	        driver.get(obj.getString("URLToTest"));
	        Thread.sleep(20000);
	        return this;
	    }
	    
	    public HomePage verificarCampaignLabel(String ExpectedText) {
	    	assertEquals(campaignManagerLavel,ExpectedText);
	        return this;
	    }

	    public HomePage verificarVamosButton(String ExpectedText) {
	    	assertEquals(vamosButton,ExpectedText);
	        return this;
	    }

	    public HomePage clickVamosButton() {
	    	click(vamosButton);
	        return this;
	    }
	    
	    public HomePage clickLoginButton() {
	    	click(loginButton);
	    	return this;
	    }
	    
	    public HomePage fillUsernameField() {
	    	writeText(userNameField,obj.getString("usuario"));
	    	return this;
	    }

	    public HomePage fillPasswordField() {
	    	writeText(passwordField,obj.getString("password"));
	    	return this;
	    }
	    
	    public HomePage clickIniciarButton() {
	    	click(iniciarSesionButton);
	    	return this;
	    }	    
}
