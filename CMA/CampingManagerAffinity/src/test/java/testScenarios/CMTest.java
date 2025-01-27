package testScenarios;

import org.testng.annotations.Test;

import Objects.CMPage;

public class CMTest extends HomeTest {
	String CampaignLabel = "CAMPAIGN";

	@Test
	public void verificarCampaignLabelSeMuestraEnCMPage() throws Exception {
		CMPage cmPage = new CMPage(driver);
		cmPage.goToAutomationExercise()
			.clickVamosButton()
			.clickLoginButton()
			.fillUsernameField()
			.fillPasswordField()
			.clickIniciarButton();
		cmPage.verificarCampaignManagerLabelInCMPage(CampaignLabel);
	}
}
