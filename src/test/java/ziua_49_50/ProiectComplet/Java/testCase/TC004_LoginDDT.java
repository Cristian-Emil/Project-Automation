package ziua_49_50.ProiectComplet.Java.testCase;

/*  Avem variantele pentru LOGARE
    - date valida , parola corecta - pass login
    - date valide, parola incorecta - fail login
    - date nevalide , parola corecta - fail login
    - date nevalide, parola incorecta - fail login ( acesta este un negativ TC)

    interpretarea lor este urmatoarea:
    DATA is valid       - login success     - test pass     - logout
    DATA is invalid     - login fail        - test fail
    DATA is invalid     - login success     - test fail     - logout
    DATA is invalid     - login fail        - test pass     - negativ test
*/


//  ATENTIE - rularea se face din fisierul =   master.xml   ; aici se da click dreapta si se apasa RUN .....

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ziua_49_50.ProiectComplet.Java.pageObjects.HomePage;
import ziua_49_50.ProiectComplet.Java.pageObjects.LoginPage;
import ziua_49_50.ProiectComplet.Java.pageObjects.MyAccPage;
import ziua_49_50.ProiectComplet.Java.testBase.BaseClass;


public class TC004_LoginDDT extends BaseClass {

//  Facem sa fie parte a grupului de Datadriven

    @Test (dataProvider = "LoginData", dataProviderClass = DataProvider.class, groups ="DataDriven")  // definim unde este clasa DataProvider

    public void verify_loginDDT(String email, String pwd, String exp) throws InterruptedException {
//  scriem si logger-ul aici ca sa primim informatii
//        logger.info("*** Starting TC_004 _LogginDDT ***" );

//  ca sa verificam totul o sa punem un try-catch

        try {

//  HomePage - apelarea din aceasta pagina
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            hp.clickLogin();
//  Login - apelare din aceasta pagina
            LoginPage lp = new LoginPage(driver);
//        lp.setEmail(p.getProperty("email"));
            lp.setEmail(email);
//        lp.setPassword(p.getProperty("password"));
            lp.setPassword(pwd);
            lp.clickLogin();
//  MyAccount - apelare din aceasta pagina
            MyAccPage my_acc = new MyAccPage(driver);
            boolean targetPage = my_acc.isMyAccPage();
            Thread.sleep(3000);

            if (exp.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    my_acc.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (exp.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    my_acc.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }catch(Exception e)
            {
                Assert.fail();
            }
        Thread.sleep(3000);
//            logger.info("*** Finish TC_004 _LogginDDT***" );
    }
}
