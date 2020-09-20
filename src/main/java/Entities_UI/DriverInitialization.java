package Entities_UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverInitialization {

    public WebDriver driver(String browsername) {
        if (browsername.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            return driver;
        } else {
            return new EdgeDriver();
        }
    }
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();
        return cap;
    }
}
