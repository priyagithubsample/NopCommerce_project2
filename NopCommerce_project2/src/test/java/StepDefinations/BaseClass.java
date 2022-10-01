package StepDefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObject.AddCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addcust;
	public SearchCustomerPage searchcust ;
	public Properties configprop;
	
//created for generating random string for unique email	
	public static String randomstring() {
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return(generatedString1);
	}
	
	

	
	
	
	
}
