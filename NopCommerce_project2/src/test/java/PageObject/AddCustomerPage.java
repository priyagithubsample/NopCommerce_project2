package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
public WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomer_menue=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By lnkCustomer_menueitem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By btnAddnew=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By txtEmail=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[1]/div[2]/input");
	By txtPassword=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[2]/div[2]/div/input");
	
	By lstitemAdministrator=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By lstitemforum_modrators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[1]");
	By lstitemGuests=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[1]");
	By lstitemRegistered=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[1]");
	By lstitemVendors=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div/ul/li/span[1]");
	
	By dropManagerofvendor=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[11]/div[2]/select");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	By txtCustomerroles=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By txtFirstname=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[3]/div[2]/input");
	By txtLastname=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[4]/div[2]/input");
	By txtDateofbirth=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[6]/div[2]/span[1]/span/input");
	By txtCompanyname=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[7]/div[2]/input");
	By txtAdmincomment=By.xpath("/html/body/div[3]/div[1]/form/section/div/div/nop-cards/nop-card/div/div[2]/div[13]/div[2]/textarea");	
	By btnSave=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	
	//Actions method
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	
	
	public void ClickOnCustomersMenu()
	{
		 ldriver.findElement(lnkCustomer_menue).click();
	}
	public void ClickOnCustomersMenuItem()
	{
		ldriver.findElement(lnkCustomer_menueitem).click();
	}
	public void ClickOnAddNew()
	{
		ldriver.findElement(btnAddnew).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}
	public void setPassword(String pwd)
	{
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}
	public void setCustomerRoles(String role) throws InterruptedException
	{
		if(!role.equals("Vendors"))
	{
		ldriver.findElement(By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div"));
	}	
		ldriver.findElement(txtCustomerroles).click();
	WebElement listitem;
	Thread.sleep(3000);
	if(role.equals("Administrators"))
	{
		listitem=ldriver.findElement(lstitemAdministrator);
	}
	else if(role.equals("Forum Moderator"))
	{
		listitem=ldriver.findElement(lstitemforum_modrators);
	}
	else if(role.equals("Guests"))
	{
		listitem=ldriver.findElement(lstitemGuests);
	}
	else if(role.equals("Registered"))
	{
		listitem=ldriver.findElement(lstitemRegistered);
	}
	else if(role.equals("Vendors"))
	{
		listitem=ldriver.findElement(lstitemVendors);
	}
	else 
	{
		listitem=ldriver.findElement(lstitemGuests);
	}
	listitem.click();// if it not work then use then use javascript executor
		
	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	js.executeScript("arguments[0]. click();",listitem);	
		
	}
	
public void setManagerofVendor(String value)
{
	Select drp=new Select(ldriver.findElement(dropManagerofvendor));
	       drp.selectByVisibleText(value);
}
public void setGender(String gender)	
{
	if(gender.equals("Male"))
	{
		ldriver.findElement(rdMaleGender).click();
	}
	else if(gender.equals("Female"))
	{
		ldriver.findElement(rdFeMaleGender).click();
	}
	else
	{
		ldriver.findElement(rdMaleGender).click();//default
	}
}	
public void setFirstName(String fname)
{
	ldriver.findElement(txtFirstname).sendKeys(fname);
}
public void setLastName(String lname)
{
	ldriver.findElement(txtLastname).sendKeys(lname);
}
public void setDob(String dob)
{
	ldriver.findElement(txtDateofbirth).sendKeys(dob);
}
public void setCompanyName(String cname)
{
	ldriver.findElement(txtCompanyname).sendKeys(cname);
}
public void setAdmincomment(String acomment)
{
	ldriver.findElement(txtAdmincomment).sendKeys(acomment);
}
public void ClickOnSave()
{
	ldriver.findElement(btnSave).click();
}
						
	
	
	

	
	
	
	
	
	
	
	
	
	
	
}
