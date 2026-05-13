package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CompleteOrderPage extends Base {
    By checkoutlocator=By.cssSelector("a[class='btn btn-default check_out']");
    By placeorderlocator = By.cssSelector("a[class='btn btn-default check_out']");
    By namecardlocator = By.cssSelector("input[class='form-control']");
    By cardnumberlocator = By.cssSelector("input[name='card_number']");
    By cvclocator = By.cssSelector("input[data-qa='cvc']");
    By expirationlocator = By.cssSelector("input[name='expiry_month']");
    By yearlocator = By.cssSelector("input[name='expiry_year']");
    By confirmlocator= By.cssSelector("button[data-qa='pay-button']");


    private WebDriverWait wait;
    public CompleteOrderPage(WebDriver driver){

        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public void checkout(){
        limpiarPantallaDeAnuncios();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutlocator)).click();

    }
    public void placeOrder(String cardname,String cardnumber, String cvc, String expiration, String year ){
    limpiarPantallaDeAnuncios();

    scroll(placeorderlocator);
    wait.until(ExpectedConditions.elementToBeClickable(placeorderlocator)).click();
    type(cardname,namecardlocator);
    type(cardnumber,cardnumberlocator);
    type(cvc,cvclocator);
    type(expiration,expirationlocator);
    type(year,yearlocator);

    scroll(confirmlocator);
    click(confirmlocator);

    }
}
