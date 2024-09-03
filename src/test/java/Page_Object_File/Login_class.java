package Page_Object_File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_class 
{
    WebDriver ldriver;
    
    public Login_class(WebDriver originaldriver)
    {
 	   ldriver=originaldriver;
 	  PageFactory.initElements(originaldriver,this);
    }
    
    @FindBy(id="username") WebElement username1;
    @FindBy (id="password") WebElement password1;
    @FindBy(id="submit") WebElement submit1;
    
    public void username(String user)
    {
 	   username1.sendKeys(user);
    }
    
    public void password(String pass)
    {
 	   password1.sendKeys(pass);
    }
    
    public void submit()
    {
 	   submit1.click();
    }

}
