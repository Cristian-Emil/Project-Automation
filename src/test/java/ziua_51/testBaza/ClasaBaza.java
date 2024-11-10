package ziua_51.testBaza;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ziua_51.pagObj.PaginaDrivere;

import java.time.Duration;


public class ClasaBaza {

//-------------------------------  De aici se apelează in clasele TC valorile necesare  ------------------------------

    public WebDriver driver;

//    public ClasaBaza() { super(driver); }

    @BeforeClass
    public void setup() throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver",
//                "C:/Users/CRISTIAN ZIDARESCU/IdeaProjects/- driver Selenium-Maven/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//  Pagina utilizata este "https://demo.opencart.com/" sau "https://tutorialsninja.com/demo/"

        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        Thread.sleep(2500);
        driver.navigate().refresh();                        // se face refresh la pagina
        Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

//  -------------------------------  De aici se apeleaza in clasele TC valorile necesare  ------------------------------

    public String randomeString()
    {
        String generatedstring =  RandomStringUtils.randomAlphabetic(5);
        return generatedstring;
    }

    public String randomeNumber()
    {
        String generatednumber =  RandomStringUtils.randomNumeric(10);
        return generatednumber;
    }

    public String randomeAlphaNumberic()
    {
        String generatedstring =  RandomStringUtils.randomAlphabetic(3);
        String generatednumber =  RandomStringUtils.randomNumeric(3);
        return (generatedstring + "@" + generatednumber);
    }

}
