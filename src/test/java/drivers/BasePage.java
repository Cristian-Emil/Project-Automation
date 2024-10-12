package drivers;

//  Aici este CONSTRUCTORUL, driverul pentru ProiectComplet din ziua_49 care este clasa PARINTE CONSTRUCTOR
//  Astfel se apeleaza "WebDriver driver" din orice clasa (il folosim in loc de DriverManager care este la fel)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver)
    {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/CRISTIAN ZIDARESCU/IdeaProjects/- driver Selenium-Maven/ChromeDriver/chromedriver.exe");
        this.driver = driver;
        PageFactory.initElements(driver, this);
//  Constructor de mai sus initializeaza driverul - deci este un constructor care initializeaza driver-ul

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

}
