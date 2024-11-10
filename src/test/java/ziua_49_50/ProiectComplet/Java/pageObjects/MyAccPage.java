package ziua_49_50.ProiectComplet.Java.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccPage extends BasePage {

//  Pagina utilizata este "https://demo.opencart.com/" sau https://tutorialsninja.com/demo/

    public MyAccPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")
//  //h2[text()= 'My Account']
    WebElement mesajHeading;

//  aici inseram si valorile de logout - adaugat in pasul 6
    @FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
//  //div[@class='lis-group']//a[text()='Logout']
        WebElement lnkLogout;


    public boolean isMyAccPage()
    {
        try
        {
         return (mesajHeading.isDisplayed());
        }
        catch(Exception e)
        {
         return false;
        }
    }

        public void clickLogout()
        {
            lnkLogout.click();
        }


}
