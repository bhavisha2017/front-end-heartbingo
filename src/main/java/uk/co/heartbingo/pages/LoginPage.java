package uk.co.heartbingo.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import uk.co.heartbingo.utility.Utility;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    @CacheLookup
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement acceptCookiesLink;

    @CacheLookup
    @FindBy (xpath = "//iframe[@class='oneauth-iframe']")
    WebElement iFrame;

    @CacheLookup
    @FindBy (xpath = "//a[normalize-space()='Log In']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(id = "username")
    WebElement userName;

    @CacheLookup
    @FindBy(id = "password")
    WebElement password;

    @CacheLookup
    @FindBy(name = "login_submit")
    WebElement logIn;

    @CacheLookup
    @FindBy(className = "login_errorMessageWrapper__2ZcGx")
    WebElement loginError;

    public void clickOnAcceptCookiesLink()
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", acceptCookiesLink);
    }
    public void clickOnLogInButton(){
        clickOnElement(loginButton);
        log.info("Clicking on Login button : " + loginButton.toString());
    }
    public void logIn(String user, String pw){
        switchToIframe(iFrame);
        log.info("Switching to the iframe : " + iFrame.toString());
        sendTextToElement(userName,user );
        log.info("Entering Username " + userName.toString());
        sendTextToElement(password, pw);
        log.info("Entering Password " + password.toString());
        clickOnElement(logIn);
        log.info("Clicking on Login button : " + logIn.toString());
    }
    public void verifyLoginErrorMessage(String message){
        Assert.assertTrue(loginError.getText().contains(message));
        log.info("Verifying error message : " + loginError.toString());
        System.out.println("The verified login error message is : " + loginError.getText());
    }


}
