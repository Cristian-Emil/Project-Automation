package ziua_49_50.ProiectComplet.Java.testCase;

//  ATENTIE - rularea se face din - master.xml  file. Se da run in acesta, click dreapta si RUN .....

import org.testng.Assert;
import org.testng.annotations.Test;
import ziua_49_50.ProiectComplet.Java.pageObjects.HomePage;
import ziua_49_50.ProiectComplet.Java.pageObjects.LoginPage;
import ziua_49_50.ProiectComplet.Java.pageObjects.MyAccPage;
import ziua_49_50.ProiectComplet.Java.testBase.BaseClass;


public class TC003_LoginTest extends BaseClass {

//  Facem sa fie parte a grupului de SANITY si MASTER

//    @Test(groups="Sanity")  - se ascrie astfel daca e un singur grup specificat sau cu mai multe ca mai jos.
    @Test(groups={"Sanity", "Master"})
    public void verif_login() throws InterruptedException {
        logger.info("*** Porneste TC003_LoginTest ***");

//  inainte sa apelam cele 2 metode o sa apelam/instantiem clasa HomePage
        HomePage hp = new HomePage(driver);
        Thread.sleep(1500);

        hp.clickMyAccount();
        Thread.sleep(1500);

        hp.clickLogin();
        Thread.sleep(5000);

//  inainte sa apelam cel 3 metodele o sa apelam/instantiem clasa LoginPage
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        Thread.sleep(1500);

        lp.setPassword(p.getProperty("password"));
        Thread.sleep(1500);

        lp.clickLogin();
        Thread.sleep(1500);

//  se creaza
        MyAccPage myacc = new MyAccPage(driver);
        boolean targetPage = myacc.isMyAccPage();
        Thread.sleep(1500);

//        Assert.assertEquals(targetPage, true, "Login failed");
//  sau avem
        Assert.assertTrue(targetPage);
        logger.info("***  ***");

        Thread.sleep(5000);
    }
}
