package ziua_49_50.ProiectComplet.Java.testBase;

//  Aceasta clasa a fost generata ca valoirile comune sa fie importata in fiecare TC si sa nu fie repetate in TC

import drivers.BasePage;
import lombok.Builder;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
// import java.util.logging.Logger;
import org.apache.logging.log4j.Logger;         // Log4j
import org.apache.logging.log4j.LogManager;     // Log4j
import org.testng.annotations.Parameters;

import javax.xml.bind.annotation.XmlType;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


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

        p = new Properties();

        FileReader file = new FileReader("src/test/java/ziua_49_50/ProiectComplet/resources/config.properties");
//        Properties p = new Properties();
        p.load(file);


        logger = LogManager.getLogger(this.getClass()); // le inseram aici

//  ---------------------- TOATE ACESTE LINII SE COMENTEAZA PENTRU CA SA PUTEM RULA TESTNG  ----------------------------

////  aici spunem daca din config.properties folosin LOCAL sau REMOTE. Partea cu SWTCH este pt LOCAL.
//
////  Daca vrem REMOTE trebuie sa adugam conditiile de mai jos, astea inainte de SWITCH :
//
//        if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
//        {
//            DesiredCapabilities capabilities = new DesiredCapabilities();
////  deci trebuie sa lansam OS
//            if(os.equalsIgnoreCase("windows"))
//            {
//                capabilities.setPlatform(Platform.WIN10);
//            }
//            else if (os.equalsIgnoreCase("mac"))
//            {
//                capabilities.setPlatform(Platform.MAC);
//            }
//            else
//            {
//                System.out.println(" No matching os");
//            }
//
////  deci trebuie sa lansam BROWSWER-ul
//
//            switch(br.toLowerCase())
//            {
//                case "chrome" :  capabilities.setBrowserName("Chrome"); break;
//                case "edge" :  capabilities.setBrowserName("MicrosoftEdge"); break;
//                case "firefox" :  capabilities.setBrowserName("FireFox"); break;
//                default: System.out.println("No matching browser"); return;
//            }
//
////  aici cdefinium driver-ul pentru ca nu este definit ca mai jos la urmatorul SWITCH
//            driver = new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"), capabilities);
//
//        }
//
////  deci mai trebuie sa punem o conditie IF ca sa lucreze depe LOCAL in loc de REMOTE, dupa cum am selectat in config.properties
//
//        if (p.getProperty("execution_env").equalsIgnoreCase("local"))
//        {
//            switch(br.toLowerCase())
//            {
//                case "chrome" : driver = new ChromeDriver();
//                    break;
//                case "edge" : driver = new EdgeDriver();
//                    break;
//                case "firefox" : driver = new FirefoxDriver();
//                    break;
//                default : System.out.println("Invalid browser name ... ");
//                    return;
//            }
//        }

//----------------------------------------------------------------------------------------------------------------------

        driver = new ChromeDriver();      // driver-ul este deja incarcat in clasa

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/
//  Avem mai multe idei de URL, le incercam pe toate sa vedem care merge:

        driver.get(p.getProperty("appURL2"));   // citim valoarea URL din config.property file

//        driver.get("https://tutorialsninja.com/demo/");
//        driver.get("https://demo.opencart.com/");
//        driver.get("http://localhost/opencart/upload/index.php");     // aceasta linie se decomenteaza cand lucram pe local cu LOCALHOST

//  Pt ca pagina nu se incarca bine din prima ii dam REFRESH astfel incat aceasta sa se reincarce corect.
//        driver.navigate().refresh();

        System.out.println("URL din config: " + p.getProperty("appURL2"));
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
