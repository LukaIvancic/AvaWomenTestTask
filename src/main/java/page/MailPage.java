package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.PageFactory;


public class MailPage {


	protected static WebDriver driver = getDriver();

	public MailPage() {
		PageFactory.initElements(driver, this);
	}

	protected static WebDriver getDriver(){
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;
	}

	public void goToUrl(String url){
		driver.get(url);
	}
	public String getText(){
		String message = "";
		String xpath = "//div[@class='ava-title-no-padding']";
		WebElement validationText = driver.findElement(By.xpath(xpath));

		if (validationText.isDisplayed()){
			message = validationText.getText();
		}
		return message;
	}
}
