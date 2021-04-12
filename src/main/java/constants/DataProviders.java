package constants;
import org.testng.annotations.DataProvider;

public class DataProviders {

	//LOGIN

	@DataProvider(name = "Login")
	public Object[][] getLogin() {

		return new Object[][]
				{
						{ "humantesting69@gmail.com",
								"Avawomen69!"
						}
				};

	}

	@DataProvider(name = "LoginNegative")
	public Object[][] getLoginNegative() {

		return new Object[][]
				{
						{ "humantesting69@gmail.com",
								"IncorrectPassword!!"
						},
						{ "invalidemail@gmail.com",
								"Avawomen69!"
						},
						{ "invalidemail@gmail.com",
								"InvalidPassword!"
						}


				};

	}

	//REGISTER

	@DataProvider(name = "InvalidEmail")
	public Object[][] getInvalidEmail() {

		return new Object[][]
				{
						{ "humantesting69gmail.com"

						},
						{ "hum@ntestinasd@sdg69@gmail.com"

						},
						{ "<>sda@@d>@gmail.com"

						},

				};

	}

	@DataProvider(name = "InvalidFirstnameCharacterCount")
	public Object[][] getFirstnameInvalidCharacterCount() {

		return new Object[][]
				{
						{ "a"

						},
						{ "morethansixtyvharactersinthefirstnamefieldnegativetestavawomen"

						}
				};

	}

	@DataProvider(name = "InvalidFirstname")
	public Object[][] getInvalidFirstname() {

		return new Object[][]
				{
						{
								" namestartingwithspace"
						},
						{
								"firstnameendingwithspace "
						},
						{
								"inV@liDf!r$tName"
						}
				};

	}

	@DataProvider(name = "InvalidLastname")
	public Object[][] getInvalidLastname() {

		return new Object[][]
				{
						{
								" lastnamestartingwithspace"
						},
						{
								"lastnameendingwithspace "
						},
						{
								"inV@liDl@$tName"
						}
				};

	}

	@DataProvider(name = "InvalidPassword")
	public Object[][] getInvalidPassword() {

		return new Object[][]
				{
						{
								"Ulc1@!qw"
						},
						{
								"password"
						},
						{
								"asdfghsjklm"
						},
						{
								"ALSKDJAJSDKSAS"
						},
						{
								" PASSWORD!23"
						},
						{
								"PASSWORD!23 "
						}

				};

	}

}
