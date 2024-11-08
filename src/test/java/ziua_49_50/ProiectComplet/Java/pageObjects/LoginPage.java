package ziua_49_50.ProiectComplet.Java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"input-email\"]")
    WebElement textEmailAddress;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
    WebElement textPassword;

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input")
    WebElement buttonLogin;

    public void setEmail(String email){
        textEmailAddress.sendKeys(email);
    }

    public void setPassword(String pass){
        textPassword.sendKeys(pass);
    }

    public void clickLogin() {
        buttonLogin.click();
    }

}
