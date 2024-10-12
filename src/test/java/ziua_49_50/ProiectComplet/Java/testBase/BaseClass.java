package ziua_49_50.ProiectComplet.Java.testBase;

//  Aceasta clasa a fost generata ca valoirile comune sa fie importata in fiecare TC si sa nu fie repetate in TC

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
// import java.util.logging.Logger;
import org.apache.logging.log4j.Logger;         // Log4j
import org.apache.logging.log4j.LogManager;     // Log4j
import org.testng.annotations.Parameters;


public class BaseClass {

//  -------------------------------  De aici se apelează in clasele TC valorile necesare  ------------------------------
//  Se face WebDriver STATIC pentru ca e continut in ambele clase, BaseClass si ExtentReportManager si asa eliminam conflictul
    public static WebDriver driver;

//  In BaseClass punem si dependintele de LOGGER
    public Logger logger;                           //Log4j2
    public Properties p;

//    @BeforeClass - astfel se scrie daca nu are definite grupuri sau se specifica cu grupuri ca mai jos
    @BeforeClass(groups = {"Sanity", "Regression", "Master", "DataDriven"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException {
//  Intai a fost FileNotFoundException si acum este IOException
//  Incarcam fisierul config.properties din directorul RESOURCES. O sa folosim o clasa speciala PROPERTIES

        FileReader file = new FileReader("src/test/java/ziua_49_50/ProiectComplet/resources/config.properties");
        Properties p = new Properties();
        p.load(file);


        logger = LogManager.getLogger(this.getClass()); // le inseram aici

        switch(br.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver();
                break;
            case "edge" : driver = new EdgeDriver();
                break;
            case "firefox" : driver = new FirefoxDriver();
                break;
            default : System.out.println("Invalid browser name ... ");
                return;
        }

        driver = new ChromeDriver();      // driver-ul este deja incarcat in clasa
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/
//  Avem mai multe idei de URL, le incercam pe toate sa vedem care merge:

        driver.get(p.getProperty("appURL2"));   // citim valoarea URL din config.property file

//        driver.get("https://tutorialsninja.com/demo/");
//        driver.get("https://demo.opencart.com/");
//        driver.get("http://localhost/opencart/upload/index.php");     // aceasta linie se decomenteaza cand lucram pe local cu LOCALHOST

        driver.manage().window().maximize();

//  Pt ca pagina nu se incarca bine din prima ii dam REFRESH astfel incat aceasta sa se reincarce corect.
        driver.navigate().refresh();
    }

    @AfterClass(groups = {"Sanity", "Regression", "Master", "DataDriven"})
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

//  Aici pune captura de ecran

    public static String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyy-MM-dd-hhmm-ss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

//        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        String targetFilePath=System.getProperty("user.dir")+".ziua_49_50.ProiectComplet.screenshots" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }


}
