package constants;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "Login")
	public  Object[][] getLogin(){
		return new Object[][]
				{
						{ "humantesting69@gmail.com",
								"Avawomen69!"
						}
				};

	}

	@DataProvider(name = "LoginNegative")
	public  Object[][] getLoginNegative(){
		return new Object[][]
				{
						{ "humantesting69@gmail.com",
								"laksdjjd"
						},
						{ "humantestinasdasdg69@gmail.com",
								"Avawomen69!"
						},
						{ "humantestinasdasdg69@gmail.com",
								"Avawomen69!"
						},

				};

	}




}
