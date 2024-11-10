package ziua_51.pagObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PaginaDrivere {


    WebDriver driver;

    public PaginaDrivere(WebDriver driver)
    {
        System.setProperty("webdriver.chrome.driver",
                "C:/Users/CRISTIAN ZIDARESCU/IdeaProjects/- driver Selenium-Maven/ChromeDriver/chromedriver.exe");
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
//  Constructor de mai sus initializeaza driverul - deci este un constructor care initializeaza driver-ul

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }



}

