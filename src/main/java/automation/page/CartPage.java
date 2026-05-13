package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends Base {
    By Cartlocator = By.xpath("//a[@href='/view_cart']");


    private WebDriverWait wait;
    public CartPage(WebDriver driver){
        super(driver);
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openCart(){
        wait.until(ExpectedConditions.elementToBeClickable(Cartlocator)).click();

    }
}
