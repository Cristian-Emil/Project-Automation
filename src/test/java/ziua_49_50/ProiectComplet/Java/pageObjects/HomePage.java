package ziua_49_50.ProiectComplet.Java.pageObjects;

//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/

// import drivers.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


//    WebDriver driver = new ChromeDriver();  // definim un driver in afara testelor astfel incat el sa fie apelat mereu

/*
    Pentru ca am generat un constructor in Clasa BasePage din Driver
    Din HomePage cum putem sa invocam clasa parinte pe baza mostenirii? Noi in clasa parinte avem "THIS D|RIVER - acest driver.
    Acest lucru se face cu apelarea prin comanda SUPER KEYT

 */
    public HomePage (WebDriver driver)
    {
        super(driver);
    }

//    @FindBy(xpath="//span[normalize-space()='My Account']" )
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a")
//
//  xpath = //*[@id="top"]/div/div[2]/ul/li[2]/div/a/i[2]
//  //*[@id="top"]/div/div[2]/ul/li[2]/div/a/span
//  css = "#top > div > div.nav.float-end > ul > li:nth-child(2) > div > a > span"
    WebElement linkMyAccount;

//    @FindBy(xpath="//span[normalize-space()='Register']" )
    @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]" )
//  //*[@id="top"]/div/div[2]/ul/li[2]/div/ul/li[1]/a
//  css = "#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a"
    WebElement linkRegister;

    public void clickMyAccount(){ linkMyAccount.click(); }

    public void clickRegister()
    {
        linkRegister.click();
    }

//-- Daca dorim sa folosim si Login utilizam partea de text de mai jos --------------------------------------------------

    @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]" )
//  //span[normalize-space()='Login']
    WebElement linkLogin;

    public void clickLogin()
    {
        linkLogin.click();
    }
}
