//  Am comentat complet aceasta clasa ca sa nu mai apara dependintele de OS si BROWSER
package ziua_49_50.ProiectComplet.Java.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import ziua_49_50.ProiectComplet.Java.pageObjects.AccountRegisterPage;
import ziua_49_50.ProiectComplet.Java.pageObjects.HomePage;
import ziua_49_50.ProiectComplet.Java.testBase.BaseClass;

import java.awt.*;

public class TC001_AccRegistTest extends BaseClass {


/*
    Generam 3 conditii Before, After, Test

    ATENTIE: Pentru ca o sa le utilizam in diferite cazul putem sa mutam liniile 22 - 44 in BaseClass
    DECI PE ACESTEA LE COMENTAM SI LE UTILIZAM PRIN APEKAR PE CELE DIN CLASA - BaseClass
 */

//    public WebDriver driver;
//
//    @BeforeClass
//    public void setup()
//    {
//        driver = new ChromeDriver();
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
////  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/
//
////        driver.get(" https://tutorialsninja.com/demo/");
//        driver.get("https://demo.opencart.com/");
////        driver.get("http://localhost/opencart/upload/index.php");     // aceasta linie se decomenteaza vcand lucram pe local
//
//        driver.manage().window().maximize();
//    }
//
//    @AfterClass
//    public void tearDown()
//    {
//        driver.quit();
//    }

//-------------------------------------------- Aici incepe de fapt clasa noastra  --------------------------------------
//  Facem sa fie parte a grupului de REGRESSION si MASTER
//    @Test(groups = " Regression")
    @Test(groups = {" Regression", "Master"})
    public void verify_acc_regist() throws InterruptedException {

        logger.info("***** Starting TC001_AccRegistTest");

        try{

//----------- Aici avem o secventa de program care face ca pagina sa se afiseze pe ecranul 2 ---------------------------
// Obține toate monitoarele disponibile
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        Thread.sleep(1500);
// Se verifica câte monitoare sunt disponibile
        System.out.println("Numărul de monitoare detectate: " + screens.length);

// Se alege monitorul 2 (index 1, pentru că indexul 0 este primul ecran)
        int screenIndex = 1; // Indexul monitorului 2
        Thread.sleep(1500);
        if (screenIndex < screens.length) {
// Obține coordonatele ecranului 2
            Rectangle screenBounds = screens[screenIndex].getDefaultConfiguration().getBounds();
// Se setează poziția pe monitorul 2
            driver.manage().window().setPosition(new org.openqa.selenium.Point(screenBounds.x, screenBounds.y));

            System.out.println("Fereastra browserului a fost mutată pe monitorul 2.");
            } else {
                System.out.println("Monitorul 2 nu este disponibil.");
            }
        Thread.sleep(2500);

        driver.manage().window().maximize();
//----------------------------------------------------------------------------------------------------------------------
//  Dam REFRESH la pagina astfel incat aceasta sa se incarce corect.
//            driver.navigate().refresh();

//      Instantiem HomePage si accesam driver - astfel avem accesul la prima pagina
            HomePage hp = new HomePage(driver);     // accesam pagina de HomePage si activam driverul.

            Thread.sleep(7500);

//  Pt ca pagina nu se incarca bine din prima ii dam REFRESH astfel incat aceasta sa se reincarce corect.
//            driver.navigate().refresh();
//            Thread.sleep(5000);


        hp.clickMyAccount();                    // accesam si dam click pe My Account
        logger.info("Da click in REGISTER pt contul meu ");
        Thread.sleep(2500);


        hp.clickRegister();                     // accesam si dam click pe Register

//      Instantiem AccountRegisterPage si accesam driver - aici avem accesul la a doua pagina.
        AccountRegisterPage reg_page = new AccountRegisterPage(driver); // accesam pagina de HomePage si activam driverul.

//  Aici primim informatiile despre marimile utilizate. Acest lucru se face cu ajutorul comenzii LOGGER
        logger.info("Providing customer detailes .... ");

        reg_page.setFirstname(randomeString().toUpperCase());
//        reg_page.setFirstname("Cristian");

        reg_page.setLastname(randomeString().toUpperCase());
//        reg_page.setLastname("Teste");

        reg_page.setEmail(randomeString() + "@hotmail.com");      // random generate the
//        reg_page.setEmail("cristian_teste@outlook.com");

//      Partea cu numarul de telefon a disparut , deci linia se comenteaza
        reg_page.setTelephone(randomeNumber());
//        reg_page.setTelephone("0721212121");

//  Pentru a genera acel pass trebuie ca facem captura de valoare intr-o variabila si apoi sa generam pass-ul
        String password = randomeAlphaNumberic();
        reg_page.setPassword(password);
//        reg_page.setPassword("Cristian70");

        reg_page.setConfirmPswd(password);
//        reg_page.setConfirmPswd("Cristian70");
        Thread.sleep(1500);

//        reg_page.setSubscribe();
        Thread.sleep(1500);

        reg_page.setPrvPolicy();
            Thread.sleep(1500);

        reg_page.clickContinue1();
            Thread.sleep(1500);

        reg_page.clickContinue2();

        Thread.sleep(15000);

        logger.info("Valideaza mesajul de confirmare care apare");
        String conf_msg = reg_page.getConfirmationMsg();

//  Ca sa vedem daca functioneaza sau nu sistemul o sa punem o conditie IF-ELSE:
        if(conf_msg.equals("Your Account Has Been Created"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            logger.error("Testul a picat ...  ca nu e bine ce e acolo");
            logger.debug("Debug logs ...");
            Assert.assertTrue(false);
        }

//  Deci linia de assert de mai jos se poate comenta
//        Assert.assertEquals(conf_msg, "Your Account Has Been Created");
        }
        catch(Exception e)
        {
            Assert.fail();
        }
        logger.info("***** Aici se termina TC1 ...  cu toate bune si rele *****");
}


//------------------------------------ CITESTE CU ATENTIE CE E MAI JOS -------------------------------------------------
/*
    ATENTIE: dupa ce se face prima registration email-ul utilizat nu o sa mai poata fii folosit.
    Astfel trebuie sa generam un email RANDOM, o paroal ramdom, un utilizator random si restul random
    pt acesta se modifica liniile de la 51 la 81 din TC001_AccRegistTest
    Se comenteaza cele care sunt definite cu valori si se activeaza cele care au varianta RANDOM.
*/

/*
    ATENTIE: DECI DUPA PRIMA INREGISTRARE O SA COMENTAM PARTEA DE PRENUME, NUME , EMAIL, PASS ASTFEL INCAT SA PUTEM
    VERIFICA MEREU INREGISTRAREA CU DIFERENTE VALORI DAR NU O SA RETINEM ACESTE VALORI.
    Cand o sa verificam un anumit utilizator o sa folosim valorile comentate care au generat primul utilizator.
    Pentru verificarea modului de inregistrare si ca acesta functioneaza o sa folosim varianta random.

    Deci o sa folosim o clasle RANDOME generate si apleate mai jos
    randomeString   =>  RandomStringUtils.randomAlphabetic(5)
    randomeString   =>  RandomStringUtils.randomNumeric(10)
    RandomStringUtils.randomAlphabetic(3)
*/



/*
    ATENTIE: Pentru ca o sa le utilizam in diferite cazul putem sa mutam liniile 120 - 138 in BaseClass
    DECI PE ACESTEA LE COMENTAM SI LE UTILIZAM PRIN APELAR PE CELE DIN CLASA - BaseClass
 */
//---------------------------------------------------------------------------------------------------------------------
// Mai jos avem diverse variante de aplicat


//    public String randomeString()
//    {
//        String generatedstring =  RandomStringUtils.randomAlphabetic(5);
//        return generatedstring;
//    }
//
//    public String randomeNumber()
//    {
//        String generatednumber =  RandomStringUtils.randomNumeric(10);
//        return generatednumber;
//    }
//
//    public String randomeAlphaNumberic()
//    {
//        String generatedstring =  RandomStringUtils.randomAlphabetic(3);
//        String generatednumber =  RandomStringUtils.randomNumeric(3);
//        return (generatedstring + "@" + generatednumber);
//    }

//https://demo.opencart.com/


}
