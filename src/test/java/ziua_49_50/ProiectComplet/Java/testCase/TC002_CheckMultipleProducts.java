package ziua_49_50.ProiectComplet.Java.testCase;

import org.testng.Assert;

import org.testng.annotations.Test;
import ziua_49_50.ProiectComplet.Java.pageObjects.AccountRegisterPage;
import ziua_49_50.ProiectComplet.Java.pageObjects.HomePage;
import ziua_49_50.ProiectComplet.Java.testBase.BaseClass;

public class TC002_CheckMultipleProducts extends BaseClass {


    @Test
    public void main(String[] args) throws InterruptedException {

        System.out.println("Acest test este generat ca sa vedem in ce fel sunt folosite datele din clasa BaseClass prin " +
                "extindere a pachetului testBase");


        HomePage hp = new HomePage(driver);     // accesam pagina de HomePage si activam driverul.

        Thread.sleep(7500);
        driver.navigate().refresh();
        Thread.sleep(5000);


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
//        reg_page.setTelephone(randomeNumber());
//        reg_page.setTelephone("0721212121");


//  Pentru a genera acel pass trebuie ca facem captura de valoare intr-o variabila si apoi sa generam pass-ul

        String password = randomeAlphaNumberic();
        reg_page.setPassword(password);
//        reg_page.setPassword("Cristian70");

        reg_page.setConfirmPswd(password);
//        reg_page.setConfirmPswd("Cristian70");
        Thread.sleep(5000);

//        reg_page.setSubscribe();
        Thread.sleep(5000);
        reg_page.setPrvPolicy();
        Thread.sleep(1500);

        reg_page.clickContinue1();
        Thread.sleep(1500);

        reg_page.clickContinue2();
        Thread.sleep(1500);

        logger.info("Valideaza mesajul de confirmare care apare");
        String conf_msg = reg_page.getConfirmationMsg();
        Assert.assertEquals(conf_msg, "Your Account Has Been Created");
    }

}
