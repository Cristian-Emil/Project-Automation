package ziua_51.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ziua_51.pagObj.PagInregCont;
import ziua_51.pagObj.PagPrincipala;
import ziua_51.testBaza.ClasaBaza;

public class TestCase1 extends ClasaBaza {

    @Test
    public void verificare_inreg() throws InterruptedException {

        PagPrincipala Pag1 = new PagPrincipala(driver);
        Thread.sleep(7500);

        Pag1.clickMyAccount();
        Thread.sleep(2500);

        Pag1.clickRegister();
        Thread.sleep(2500);

        PagInregCont inreg_pag = new PagInregCont(driver);

        inreg_pag.setFirstname(randomeString().toUpperCase());

        inreg_pag.setLastname(randomeString().toUpperCase());

        inreg_pag.setEmail(randomeString() + "hotmail");

        String password = randomeAlphaNumberic();
        inreg_pag.setPassword(password);
        inreg_pag.setConfirmPswd(password);
        Thread.sleep(2500);

        inreg_pag.setPrvPolicy();
        Thread.sleep(2500);
        inreg_pag.clickContinue();

        String confirm = inreg_pag.getConfirmationMsg();

        Assert.assertEquals(confirm, "Contul tau a fost creat", "Contul tau nu a fost creat" );

//        if(confirm.equals("Your Account Has Been Created"))
//        {
//            Assert.assertTrue(true);
//        }
//        else
//        {
//            Assert.assertTrue(false);
//        }

    }

}
