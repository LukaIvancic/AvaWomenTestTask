package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class GmailLoginPage extends BasePage{

	@FindBy(xpath = "//input[@type='email']")
	WebElement loginInputField;

	@FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
	WebElement nextButton;

	@FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[2]")
	WebElement nextNextButton;


	@FindBy(xpath = "//input[@type='text']")
	WebElement passwordInputField;

	public GmailLoginPage() {
		super(driver);
	}

	public void provideEmail(String email) {
		typeIntoFiled(loginInputField, email);
	}

	public void clickOnNextButton() {
		clickOnElement(nextButton);
	}

	public void providePassword(String password){
		typeIntoFiled(passwordInputField, password);
	}

	public void clickOnNextNextButton() {
		clickOnElement(nextNextButton);
	}





}
