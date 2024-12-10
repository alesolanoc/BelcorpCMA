package testScenarios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Objects.HomePage;

public class HomeTest extends BaseTest{
	String CampaignLabel = "CAMPAIGN";
	String VamosButtonLabel = "VAMOS";
	
	@Test
	public void goToHomePage() throws Exception {
		HomePage homePage=new HomePage(driver);
		homePage.goToAutomationExercise();
	}
	
	@Test
	public void verificarCampaignLabelIsPresent() throws Exception {
		HomePage homePage=new HomePage(driver);
		homePage.goToAutomationExercise()
			.verificarCampaignLabel(CampaignLabel);
	}

	@Test
	public void verificarVamosButtonIsPresent() throws Exception {
		HomePage homePage=new HomePage(driver);
		homePage.goToAutomationExercise()
			.verificarVamosButton(VamosButtonLabel);
	}
	
	@Test
	public void loginIntoCampaignPage() throws Exception {
		HomePage homePage=new HomePage(driver);
		homePage.goToAutomationExercise()
			.clickVamosButton()
			.clickLoginButton()
			.fillUsernameField()
			.fillPasswordField();
	}
}
