import automation.page.PageObjetManager;
import automation.page.SuiteListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.page.base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static automation.page.ExtentManager.test;
import static automation.page.ExtentManager.extent;

@Listeners(SuiteListener.class)
public class AutomatedTest extends Base {

    private WebDriver driver;
    
    ExtentSparkReporter spark;
    PageObjetManager manager;


    @BeforeClass
    public void SetUp() throws Exception {

        spark = new ExtentSparkReporter("Automated.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        Base base = new Base();
        driver = base.chromeConectionDriver();
        driver.manage().window().maximize();

        ITestContext context = Reporter.getCurrentTestResult().getTestContext();
        context.setAttribute("WebDriver", driver);

        manager = new PageObjetManager(driver);

    }

    @AfterClass
    public void tearDown() throws Exception {
        extent.flush();

    }

    /*@Test(priority = 1)
    public void Register()throws Exception{
        //Solicitamos la información a la base de datos

        String url = getProperty("url");
        String name = getProperty("name");
        String email = getProperty("email");
        String pass = getProperty("password");

        //llenar todo el formulario de registro

        String firstname = getProperty("firstname");
        String lastname = getProperty("lastname");
        String company = getProperty("company");
        String address = getProperty("address");
        String state = getProperty("state");
        String city = getProperty("city");
        String zipecode = getProperty("zipecode");
        String mobile = getProperty("mobile");


        driver.get(url);
        manager.getRegister().Register(name,email);

        manager.getRegister().completeRegister(pass,firstname,lastname,company,address,state,city,zipecode,mobile);

    }*/

    @Test(priority = 2)
    public void Login() throws Exception {
        try {
            test = extent.createTest("Login");
            String url = getProperty("url");
            String email = getProperty("email");
            String password = getProperty("password");

            driver.get(url);
            manager.getLoginPage();
            manager.getLoginPage().Login(email, password);
            test.pass("Ingreso de login exitosamente");
        } catch (Exception e) {
            test.fail("Error en el login");
            throw e;
        }
    }

    @Test(priority = 3)
    public void HomePage() throws Exception {
        try {
            test = extent.createTest("Home");
            manager.getHomePage().limpiarPantallaDeAnuncios();
            manager.getHomePage().categoryWomen();
            test.pass("Ingreso al home exitosamente");
        } catch (Exception e) {
            test.fail("Error en el home");
            throw e;
        }
    }

    @Test(priority = 4)
    public void Cart() throws Exception {
        try {
            test = extent.createTest("Carrito");
            manager.getCartPage().openCart();
            test.pass("Ingreso al carrito exitosamente");
        } catch (Exception e) {
            test.fail("Error en el carrito");
            throw e;
        }

    }

    @Test(priority = 5)
    public void CompleteOrder() throws Exception {
        try {
            test = extent.createTest("Completar la orden");
            manager.getCompleteOrderPage().limpiarPantallaDeAnuncios();
            String cardname = getProperty("cardname");
            String cardnumber = getProperty("cardnumber");
            String cvc = getProperty("cvc");
            String expiration = getProperty("expiration");
            String year = getProperty("year");

            manager.getCompleteOrderPage().checkout();
            manager.getCompleteOrderPage().placeOrder(cardname, cardnumber, cvc, expiration, year);

            test.pass("Ingreso a completar la orden exitosamente");
        } catch (Exception e) {
            test.fail("Error en completar la orden");
            throw e;
        }
    }

    @Test(priority = 6)
    public void Contact() throws Exception {
        try {
            test = extent.createTest("Página de contacto");
            String url = getProperty("url");
            driver.get(url);
            String namecontact = getProperty("namecontact");
            String emailcontact = getProperty("emailcontact");
            String subject = getProperty("subject");
            String menssage = getProperty("menssage");

            manager.getContactPage().Contact(namecontact, emailcontact, subject, menssage);

            test.pass("Se ingreso correctamente a la seccion de contacto");

        } catch (Exception e) {
            test.fail("No se pudo ingresar a la página de contacto");
            throw e;
        }

    }
}

