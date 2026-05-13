package com.page.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Base {
    public WebDriver driver;

    public Base(WebDriver driver){
        this.driver=driver;

    }
    public Base(){

    }

    public WebDriver chromeConectionDriver(){
        ChromeOptions options = new ChromeOptions();
        //File Extensionpatch = new File("src/main/resources/Adblock.crx");
        //options.addExtensions(Extensionpatch);

        // Bloquea pop-ups y notificaciones que suelen ser publicidad
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        // Desactiva el mensaje de "Software automatizado" que a veces mueve los elementos
        //options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        driver = new ChromeDriver(options);
        return driver;
    }

    public WebElement findelement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findelements(By locator){
        return  driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        try {
            driver.findElement(locator).click();
        } catch (Exception e) {
            // Clic forzado por JS si algo lo bloquea
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(locator));
        }
    }

    public void click(WebElement element){
        element.click();
    }

    public boolean idDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void visit(String url){
        driver.get(url);
    }

    public String getProperty(String key) throws Exception{

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/config.properties");

        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public void SelectDropdown(By locator, String textToSelect){

        WebElement dropdonwElement = findelement(locator);

        Select dropdown = new Select(dropdonwElement);
        dropdown.selectByVisibleText(textToSelect);

    }
    public void scroll(By locator) {
        try {
            WebElement scroll = driver.findElement(locator);
            // El parámetro 'true' alinea el elemento con el tope de la ventana
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);
        } catch (Exception e) {
            System.out.println("No se pudo hacer scroll al elemento: " + locator);
        }
    }
    public void limpiarPantallaDeAnuncios() {
        // Si la URL contiene 'vignette', significa que el anuncio está bloqueando todo
        if (driver.getCurrentUrl().contains("#google_vignette")) {
            // Opción A: Refrescar la página quita el anuncio de pantalla completa
            driver.navigate().refresh();
            System.out.println("LOG: Anuncio de pantalla completa detectado y removido con Refresh.");
        }

        // Opción B: Borrar banners pequeños que puedan estorbar el scroll
        try {
            ((JavascriptExecutor) driver).executeScript(
                    "var ads = document.querySelectorAll('iframe, ins, .adsbygoogle');" +
                            "for (var i = 0; i < ads.length; i++) { ads[i].remove(); }"
            );
        } catch (Exception e) {
            // No hay anuncios pequeños
        }
    }
    public static String getScreenshot(String Screenshotname, WebDriver driver)throws IOException {

        String dataName = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        //ruta
        String destination = System.getProperty("user.dir") +"/TestScreenshots/"+ Screenshotname + dataName +".png";
        File finaldestination = new File(destination);

        //Se copia el archivo a la carpeta
        FileUtils.copyFile(source, finaldestination);
        return  destination;
    }
}
