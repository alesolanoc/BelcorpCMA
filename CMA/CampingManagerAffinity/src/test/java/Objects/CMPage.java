package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CMPage extends HomePage{
    public CMPage(WebDriver driver) {
	super(driver);
	// TODO Auto-generated constructor stub
    }
    
    By campaignManagerLabelInCMPage = By.cssSelector("div[class='logo-cm-title ng-star-inserted'] strong");
    
    public CMPage verificarCampaignManagerLabelInCMPage(String ExpectedText) {
    	assertEquals(campaignManagerLabelInCMPage,ExpectedText);
        return this;
    }
}
