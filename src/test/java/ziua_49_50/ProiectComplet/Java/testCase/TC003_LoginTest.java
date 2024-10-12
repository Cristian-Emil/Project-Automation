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
    public void verif_login() {
        logger.info("*** Porneste TC003_LoginTest ***");

//  inainte sa apelam cele 2 metode o sa apelam/instantiem clasa HomePage
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        hp.clickLogin();

//  inainte sa apelam cel 3 metodele o sa apelam/instantiem clasa LoginPage
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(p.getProperty("email"));
        lp.setPassword(p.getProperty("password"));
        lp.clickLogin();

//  se creaza
        MyAccPage myacc = new MyAccPage(driver);
        boolean targetPage = myacc.isMyAccPage();

//        Assert.assertEquals(targetPage, true, "Login failed");
//  sau avem
        Assert.assertTrue(targetPage);
        logger.info("***  ***");
    }
}
