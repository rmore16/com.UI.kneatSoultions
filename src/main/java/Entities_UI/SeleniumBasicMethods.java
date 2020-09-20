package Entities_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumBasicMethods extends DriverInitialization {
    public final WebDriver driver = driver("chrome");
    public void launchUrl(String URL) {
        driver.get(URL);
        driver.manage().window().maximize();
    }
    public void Explicitwait(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
    public void clickonElement(By element){
       Explicitwait(element);
       driver.findElement(element).click();
    }
    public void sendtext(By element,String text){
        Explicitwait(element);
        driver.findElement(element).sendKeys(text);
    }
    public void gettext(By element){
        driver.findElement(element).getText();
    };
    public void quitDriver(){
        driver.close();
        driver.quit();
    }
}
