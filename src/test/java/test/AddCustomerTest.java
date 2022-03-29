package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.BasePage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddCustomerTest {

	
	WebDriver driver;
		
	
	ExcelReader exlRead= new ExcelReader("testData\\TF_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String fullName= exlRead.getCellData("AddContactinfo", "FullName", 2);
	String companyName = exlRead.getCellData("AddContactinfo", "CompanyName", 2);
	String email= exlRead.getCellData("AddContactinfo", "Email", 2);
	String phone= exlRead.getCellData("AddContactinfo", "Phone", 2);
	String city = exlRead.getCellData("AddContactinfo", "City", 2);
	String country= exlRead.getCellData("AddContactinfo", "Country", 2);
	String address= exlRead.getCellData("AddContactinfo", "Address", 2);
	String state= exlRead.getCellData("AddContactinfo", "State", 2);
	String zip= exlRead.getCellData("AddContactinfo", "Zip", 2);

	
	@Test
	public void validUserShouldBeAbleToCreateAccount() throws InterruptedException {
		
		
		driver=BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertUserName(userName);
		loginpage.insertPassword(password);
		loginpage.clickSingnIn();;
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.varifyDashbardHeader();
		dashboardpage.clickCustomerButton();
		dashboardpage.clickAddCustomerButton();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		 addcustomerpage.insertFullName(fullName);
		 addcustomerpage.insertCompany(companyName);
		 addcustomerpage.insertEmail(email);		
		 addcustomerpage.insertPhone(phone);
		 addcustomerpage.insertCity(city);
		 addcustomerpage.insertCountry(country);
		 addcustomerpage.insertAddress(address);
		 addcustomerpage.insertState(state);		
		 addcustomerpage.insertZip(zip);
		 addcustomerpage.insertSubmitButton();
		 dashboardpage.clickListCustomerButton();
		
		 
		 
		 
		 
		BrowserFactory.tearDown();	
	
	}	
	
}
//HERE IN TEST PAGE WE HAVE ALL THE ELEMENTS WITH THE METHODS WE CALL FROM DIFFERENT PAGES TO USE 
//FOR OUR TESTING (LIKE HERE WE MAKE OBJECT OF DIFFERENT CLASS PAGES LIKE LOGINPAGE, DASHBOARDPAGE,ADDCUSTOMERPAGE)
//LASTLY WE CALL TEARDOWN FROM BROWSERFACTORY TO CLOSE ALL THE TABS AND QUIT TEST PAGE)