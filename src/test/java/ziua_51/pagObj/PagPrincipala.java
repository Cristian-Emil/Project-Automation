package ziua_51.pagObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PagPrincipala extends PaginaDrivere {

//    WebDriver driver = new ChromeDriver();
    public PagPrincipala(WebDriver driver){ super(driver);
//        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "///*[@id=\"top\"]/div/div[2]/ul/li[2]/div/a/span") // aceasta e pentru pagina https://demo.opencart.com/
//  //*[@id="top-links"]/ul/li[2]/a/span[1] // aceasta e pt pagina de ttps://tutorialsninja.com/demo/
//  xpath = //*[@id="top"]/div/div[2]/ul/li[2]/div/a/i[2]
//  css = "#top > div > div.nav.float-end > ul > li:nth-child(2) > div > a > span"
    WebElement MyAccount;


    @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a" )
//  css = "#top > div > div.nav.float-end > ul > li:nth-child(2) > div > ul > li:nth-child(1) > a"
//    @FindBy(xpath="//span[normalize-space()='Register']" )
    WebElement Register;


    public void clickMyAccount(){ MyAccount.click(); }

    public void clickRegister()
    {
        Register.click();
    }

//-- Daca dorim sa folosim si Login utlizam partea de text de mai jos --------------------------------------------------

    @FindBy(xpath="//span[normalize-space()='Login']" )
    WebElement linkLogin;

    public void Login()
    {
        linkLogin.click();
    }
}
