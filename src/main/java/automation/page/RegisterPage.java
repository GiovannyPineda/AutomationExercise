package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage extends Base {
    private WebDriverWait wait;
    By registerlocator = By.xpath("//a[contains(text(),'Signup')]");
    By namelocator= By.cssSelector("input[data-qa='signup-name']");
    By emaillocator= By.cssSelector("input[data-qa='signup-email']");
    By singuplocator= By.cssSelector("button[data-qa='signup-button']");
    By radiobuttonlocator = By.cssSelector("input[id='id_gender1']");
    By passwordlocator = By.cssSelector("input[data-qa='password']");
    By dayslocator = By.id("days");
    By monthslocator = By.id("months");
    By yearlocator = By.id("years");
    By firstnamelocator = By.cssSelector("input[name='first_name']");
    By lastnamelocator = By.cssSelector("input[name='last_name']");
    By companylocator =By.cssSelector("input[data-qa='company']");
    By addresslocator =By.cssSelector("input[data-qa='address']");
    By countrylocator=By.cssSelector("select[data-qa='country']");
    By statelocator=By.cssSelector("input[data-qa='state']");
    By citylocator=By.cssSelector("input[data-qa='city']");
    By zipcodelocator=By.cssSelector("input[data-qa='zipcode']");
    By mobilenumberlocator=By.cssSelector("input[data-qa='mobile_number']");
    By btoncratedlocator = By.cssSelector("button[data-qa='create-account']");


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.wait= new WebDriverWait(driver,Duration.ofSeconds(5));

    }
    public void Register(String name,String email){

        //Click en el botón de registrar
        wait.until(ExpectedConditions.elementToBeClickable(registerlocator)).click();

        //wait.until(ExpectedConditions.elementToBeClickable(namelocator)).sendKeys(name);

        type(name,namelocator);
        type(email,emaillocator);
        click(singuplocator);
    }

    public void completeRegister(String password,String firstname,String lastaname,String company,String address,String state,String city,String zipecode,String mobile) {

        //Radio button
        click(radiobuttonlocator);

        //Password
        type(password, passwordlocator);

        //Date off Birth
        SelectDropdown(dayslocator,"28");
        SelectDropdown(monthslocator,"July");
        SelectDropdown(yearlocator,"1998");

        //First name
        type(firstname,firstnamelocator);
        //Lastname
        type(lastaname,lastnamelocator);
        //company
        type(company, companylocator);
        //address
        type(address,addresslocator);
        //country
        SelectDropdown(countrylocator,"Singapore");
        //state
        type(state,statelocator);
        //city
        type(city,citylocator);
        //zipecode
        type(zipecode,zipcodelocator);
        //mobile
        type(mobile,mobilenumberlocator);

        click(btoncratedlocator);
    }
}
