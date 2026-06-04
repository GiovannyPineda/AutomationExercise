package automation.page;

import org.openqa.selenium.WebDriver;

public class PageObjetManager {
    private WebDriver driver;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CompleteOrderPage completeOrderPage;
    private ContactPage contactPage;


    public PageObjetManager(WebDriver driver){

        this.driver=driver;
    }

    public RegisterPage getRegister(){
        if (registerPage == null){
            registerPage = new RegisterPage(driver);
        }
        return registerPage;
    }

    public LoginPage getLoginPage(){
        if (loginPage == null){
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public HomePage getHomePage(){
        if (homePage == null){
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public CartPage getCartPage() {
        if(cartPage == null){
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CompleteOrderPage getCompleteOrderPage() {
        if (completeOrderPage == null){
            completeOrderPage = new CompleteOrderPage(driver);
        }
        return completeOrderPage;
    }

    public ContactPage getContactPage() {
        if (contactPage == null){
            contactPage = new ContactPage(driver);
        }
        return contactPage;
    }
}
