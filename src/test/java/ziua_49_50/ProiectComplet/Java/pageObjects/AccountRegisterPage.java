package ziua_49_50.ProiectComplet.Java.pageObjects;

//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/

import drivers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

//    WebDriver driver; acesta se poate comenta pentru ca in pagina constructorului am creat un constructor

    public AccountRegisterPage (WebDriver driver) { super(driver); } // il apelam din clasa parinte

    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement txtFirstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement txtLastname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement txtEmail;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement txtTelephone;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txtPassword;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement txtConfirmPass;

    @FindBy(xpath="//*[@id=\"input-newsletter\"]")
    WebElement chkdSubscribe;

    @FindBy(xpath="//*[@id=\"form-register\"]/div/div/input")
//    //input[@name='agree']
    WebElement chkdPolicy;

    @FindBy(xpath="//*[@id=\"form-register\"]/div/button")
//    //input[@Value='Continue']
    WebElement btnContinue;


//  Aici avem partea de confirmare

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;


    public void setFirstname(String firstname)
    {
        txtFirstname.sendKeys(firstname);
    }

    public void setLastname(String lastname)
    {
        txtLastname.sendKeys(lastname);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String telephone)
    {
        txtTelephone.sendKeys(telephone);
    }

    public void setPassword(String pswd)
    {
        txtPassword.sendKeys(pswd);
    }

    public void setConfirmPswd(String conf_pswd)
    {
        txtConfirmPass.sendKeys(conf_pswd);
    }

    public void setSubscribe()
    {
        chkdSubscribe.click();
    }

    public void setPrvPolicy()
    {
        chkdPolicy.click();
    }

    public void clickContinue()

    {
        btnContinue.submit();           // apasa butonul de "Continue"
    }

 /*
 In cazul in care varianta de apasare pe continue nu functioneaza avem variantele:
    1)
    btnContinue.click();

    2)
    Actions act = new Action(driver);
    act.moveToElement(btnContinue).click().perform();

    3)
    btnContinue.sendKeys(Keys.RETURN);

    4)
    WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    myWait .until(ExpectedConditions.elementToBeClick(btnContinue)).click();

    5)
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", btnConitnue);
 */

    public String getConfirmationMsg()
    {
        try {
            return (msgConfirmation.getText());
        } catch (Exception e) {
            return (e.getMessage());
        }

    //  In PageObjectClass nu se face nici o validare
    //  Validation o sa fie mereu parte de TC, deci o sa fie continuta mereu de pagina de TC si nu de ObjectClass

/*
    Dar in PageObjectClass putem sa scriem pentru elemente la care sa facem confirmare de genul celui de mai sus unde
    avem confirmarea mesajului de exceptie

    BasePage nu este un PageObjectClass dar este necesar pentru apelare si rularea fiecarui PageObjectClass
    Vezi punctul 1.1 din lista de obiecte de facut.
*/

/*
    ATENTIE: dupa ce se face prima registration email-ul utilizat nu o sa mai poata fii folosit.
    Astfel trebuie sa generam un email RANDOM, o paroal ramdom, un utilizator random si restul random
    pt acesta se modifica liniile de la 51 la 81 din TC001_AccRegistTest
    Se comenteaza cele care sunt definite cu valori si se activeaza cele care au varianta RANDOM.
*/



    }

}
