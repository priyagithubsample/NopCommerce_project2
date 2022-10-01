package PageObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	Properties configprop=new Properties();
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement lnkLogout;
	
public void setUserName() throws IOException	
{
	FileInputStream configpropfile=new FileInputStream("config.properties");
	configprop.load(configpropfile);
	String UNAME=configprop.getProperty("username");
	txtEmail.clear();
	txtEmail.sendKeys(UNAME);
}
	
public void setPassword() throws IOException
{
	FileInputStream configpropfile=new FileInputStream("config.properties");
	configprop.load(configpropfile);
	String PASS=configprop.getProperty("password");
	txtPassword.clear();
	txtPassword.sendKeys(PASS);
}
public void ClickLogin()
{
	btnLogin.click();
}
public void ClickLogout()	
{
	//JavascriptExecutor exe=(JavascriptExecutor) ldriver;
	//exe.executeScript("arguments[0].click();",lnkLogout);
	lnkLogout.click();
}
	
	
	
	
	
	
	
	
	
}
