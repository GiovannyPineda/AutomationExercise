package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.time.Duration;

public class ContactPage extends Base {
    private WebDriverWait wait;
    By contactlocator = By.xpath("//a[@href='/contact_us']");
    By namecontactlocator =By.cssSelector("input[name='name']");
    By emailcontactlocator =By.cssSelector("input[data-qa='email']");
    By subjectcontactlocator =By.cssSelector("input[data-qa='subject']");
    By menssagecontactlocator =By.cssSelector("textarea[data-qa='message']");
    By submitlocator = By.cssSelector("input[type='submit']");
    //By submitlocator = By.cssSelector("input[type='submit2']");

    public ContactPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(6));

    }

    public void Contact(String namecontact, String emailcontact, String subject,String menssage){

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactlocator)).click();

        type(namecontact,namecontactlocator);
        type(emailcontact,emailcontactlocator);
        type(subject,subjectcontactlocator);
        type(menssage,menssagecontactlocator);
        click(submitlocator);

        wait.until(ExpectedConditions.alertIsPresent());

        acceptAlert();

    }
}
