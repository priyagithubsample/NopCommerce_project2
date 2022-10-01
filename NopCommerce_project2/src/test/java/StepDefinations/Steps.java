package StepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class Steps extends BaseClass
{
@Before
public void setup() throws IOException
{
	configprop=new Properties();
	FileInputStream configpropfile=new FileInputStream("config.properties");
	configprop.load(configpropfile);
	String brow=configprop.getProperty("browser");
	if(brow.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", configprop.getProperty("chromepath"));
		driver=new ChromeDriver();
	}
	
	else
	{
		System.out.println("chrome driver is not set");
	}
	
	
	
	
}
	
	@Given("user launch chrome browser")
	public void user_launch_chrome_browser() {
	  // System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe"); 
	  // driver=new ChromeDriver();
	   driver.manage().window().maximize();
		  lp= new LoginPage(driver);
	}
    @When("user opens URL")
	public void user_opens_URL() throws IOException {
    	FileInputStream configpropfile=new FileInputStream("config.properties");
    	configprop.load(configpropfile);
    	String URL=configprop.getProperty("url");
	    driver.get(URL);
	}

	@When("user enters email and password")
	public void user_enters_email_as_and_password_as() throws IOException {
	   lp.setUserName();
	   lp.setPassword();
	}

	@When("click on login button")
	public void click_on_login_button() {
	   lp.ClickLogin();
	}

	@Then("page tittle should be {string}")
	public void page_tittle_should_be(String title) {
	  if(driver.getPageSource().contains("Login was unsuccessful"))
	  {
		  driver.close();
		  Assert.assertTrue(false);
	  }
	  else
	  {
		  Assert.assertEquals(title,driver.getTitle());
	  }
	}
    @When("user click on log out button")
	public void user_click_on_log_out_button() throws InterruptedException {
		
	    lp.ClickLogout();
	    Thread.sleep(4000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	    }
//customer feature step definations.............................................
	@Then("user can view Dashboard")
	public void user_can_view_Dashboard() {
		addcust=new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration",addcust.getPageTitle());
	}
    @When("user click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
	    addcust.ClickOnCustomersMenu();
	    }
    @When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	    addcust.ClickOnCustomersMenuItem();
	    }
    @When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
	    addcust.ClickOnAddNew();
	    Thread.sleep(3000);
	}
    @Then("user can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration",addcust.getPageTitle());
	}
    @When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    String email=randomstring()+"snehalatasapkal12@gmail.com";
	    addcust.setEmail(email);
	    addcust.setPassword("test123");
	    addcust.setCustomerRoles("Guest");
	    Thread.sleep(3000);
	    addcust.setManagerofVendor("Vendor 2");
	    addcust.setGender("Female");
	    addcust.setFirstName("Snehalata");
	    addcust.setLastName("Sapkal");
	    addcust.setDob("10/05/1990");
	    addcust.setCompanyName("popcorn");
	    addcust.setAdmincomment("This is only for learning atomation testing....");
	    }
      @When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addcust.ClickOnSave();
	    Thread.sleep(3000);
	}
   @Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
			   .contains(msg));
	}
//search customer feature.....................
   @When("Enter customer Email")
   public void enter_customer_Email() {
	   searchcust=new SearchCustomerPage(driver);
	   searchcust.setEmail("victoria_victoria@nopCommerce.com");
   }

   @When("click on search button")
   public void click_on_search_button() throws InterruptedException {
	   searchcust.ClickSearch();
	   Thread.sleep(3000);
   }

   @Then("user should found Email in the search table")
   public void user_should_found_Email_in_the_search_table() throws InterruptedException {
	boolean status= searchcust.searchcustomerbyemail("victoria_victoria@nopCommerce.com");
	Assert.assertEquals(false,status);
	Thread.sleep(4000);
	   
   }


}
