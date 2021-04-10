package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	protected static WebDriver driver;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver,this);
	}

	protected static void openBrowser() {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver(); //Initilize here
		driver.manage().window().maximize();
	}

	protected void navigateToUrl(String url){
		driver.get(url);
	}

	protected void clickOnElement(WebElement element){
		if (element.isDisplayed()) {
			element.click();
		}
	}

	protected void typeIntoFiled(WebElement element, String text){
		if (element.isDisplayed()) {
			element.click();
			element.sendKeys(text);
		}
	}
}
