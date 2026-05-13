package automation.page;

import com.page.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class HomePage extends Base {
    By bluetoplocator = By.cssSelector("a[data-product-id='1']");
    By btncontinuelocator = By.cssSelector("button[class='btn btn-success close-modal btn-block']");
    By madametoplocator = By.cssSelector("a[data-product-id='7']");
    By catwomenlocator = By.xpath("//a[@href='#Women']");
    By topslocator = By.xpath("//a[@href='/category_products/2']");



    private WebDriverWait wait;
    public HomePage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void categoryWomen(){
        limpiarPantallaDeAnuncios();
        wait.until(ExpectedConditions.elementToBeClickable(catwomenlocator)).click();
        scroll(topslocator);
        click(topslocator);

        //Seleccionamos el producto y lo dejamos en el carrito
        agregarAlCarrito(madametoplocator);
        agregarAlCarrito(bluetoplocator);
    }

    public void agregarAlCarrito(By productolocator){
        limpiarPantallaDeAnuncios();
        //Realizar scroll para encontrar el producto
        scroll(productolocator);
        //Darle click al botón del carrito
        click(productolocator);
        wait.until(ExpectedConditions.elementToBeClickable(btncontinuelocator)).click();

    }



}
