package ziua_51.pagObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class PagInregCont extends PaginaDrivere {

    public PagInregCont(WebDriver driver) {  super (driver); }

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

        public String getConfirmationMsg()
        {
            try {
                return (msgConfirmation.getText());
            } catch (Exception e) {
                return (e.getMessage());
            }
    }

}
