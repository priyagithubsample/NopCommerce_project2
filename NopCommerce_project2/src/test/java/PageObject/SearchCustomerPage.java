package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;

public class SearchCustomerPage 
{
    public WebDriver ldriver;
    WaitHelper waithelper;
    
    public  SearchCustomerPage( WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(rdriver, this);
    	waithelper=new WaitHelper(ldriver); 
    }
    @FindBy(how=How.ID,using ="SearchEmail")
    @CacheLookup
    WebElement txtEmail;
    
    @FindBy(how=How.ID,using ="SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;
    
    @FindBy(how=How.ID,using ="SearchLastName")
    @CacheLookup
    WebElement txtLastName;
    
    @FindBy(how=How.ID,using ="search-customers")
    @CacheLookup
    WebElement btnSearch;
    
    @FindBy(how=How.XPATH,using ="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div")
    WebElement table;
    
    @FindBy(how=How.XPATH,using ="//*[@id=\"customers-grid\"]/tbody/tr[6]/td[1]")
    List<WebElement> tableRows;
    
    @FindBy(how=How.XPATH,using ="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/table/thead/tr/th[2]")
    List<WebElement> tableColumns;
    
     public void setEmail(String email) 
  {
	  waithelper.WaitForElement(txtEmail, 30);
	  txtEmail.clear();
	  txtEmail.sendKeys(email);
  }
     public void setFirstName(String fname) 
     {
   	  waithelper.WaitForElement( txtFirstName, 30);
   	  txtFirstName.clear();
   	  txtFirstName.sendKeys(fname);
     }  
     public void setLastName(String lname) 
     {
   	  waithelper.WaitForElement(txtLastName, 30);
   	  txtLastName.clear();
   	  txtLastName.sendKeys(lname);
     }   
     public void ClickSearch() 
     {
    	 btnSearch.click();
    	 waithelper.WaitForElement(txtLastName, 30);
     }
     public int getNoOfRows()
     {
    	 return(tableRows.size());
     }
     public int getNoOfColunms()
     {
    	 return(tableColumns.size());
     }
     public boolean searchcustomerbyemail(String email) 
     {
    	 boolean flag=false;
    	 for(int i=1;i<=getNoOfRows();i++)
    	 {
    		 String emailid=table.findElement(By.xpath("/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[2]/div/tbody/tr["+1+"]/td[2]")).getText();
    		 System.out.println(emailid);
    		 if(emailid.equals("victoria_victoria@nopCommerce.com"))
    		 {
    			 flag=true;
    		 }
     }
    	 return flag;
     }
     
     
}








