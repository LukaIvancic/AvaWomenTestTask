package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage extends BasePage{

	@FindBy(xpath = "(//div[@id='gs_lc50']/input)[1]")
	WebElement searchField;


	public GmailInboxPage() {
		super(driver);
		navigateToInbox();
	}

	public void navigateToInbox(){
		navigateToUrl("https://mail.google.com/mail/u/0/");
	}

	public void searchByEmail(String email){
		clickOnElement(searchField);
		typeIntoFiled(searchField, email);
		searchField.sendKeys(Keys.ENTER);
	}
}
