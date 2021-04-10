package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecoveryPage extends BasePage {

	@FindBy(xpath = "(//span[@class='RveJvd snByac'])[2]")
	WebElement confirmButton;

	public RecoveryPage() {
		super(driver);
	}

	public void clickOnConfirmButton(){
		if (driver.getCurrentUrl().contains("recovery-options")){
			clickOnElement(confirmButton);
		}
	}

}
