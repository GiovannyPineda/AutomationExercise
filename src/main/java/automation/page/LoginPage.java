package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends Base {
    private WebDriverWait wait;

    By Loginlocator = By.xpath("//a[contains(text(),'Signup')]");
    By emaiaddressllocator = By.cssSelector("input[data-qa='login-email']");
    By passwordlocator = By.cssSelector("input[data-qa='login-password']");
    By btonloginlocator =By.xpath("//button[contains(text(),'Login2')]");
    //By btonloginlocator =By.xpath("//button[contains(text(),'Login')]");

    public LoginPage(WebDriver driver){
        super(driver);

        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void Login(String emailaddress,String password){
        wait.until(ExpectedConditions.elementToBeClickable(Loginlocator)).click();
        type(emailaddress,emaiaddressllocator);
        type(password,passwordlocator);
        click(btonloginlocator);

    }

}
