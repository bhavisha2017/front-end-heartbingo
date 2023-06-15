package uk.co.heartbingo.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import uk.co.heartbingo.pages.LoginPage;

public class LoginPageSteps {
    @Given("^I am on homepage$")
    public void iAmOnHomepage() {
    }
    @When("^I accept cookies$")
    public void iAcceptCookies() {
        new LoginPage().clickOnAcceptCookiesLink();
    }

    @And("^I click on the Log In Button$")
    public void iClickOnTheLogInButton() {
        new LoginPage().clickOnLogInButton();
    }

    @And("^I log in using username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void iLogInUsingUsernameAndPassword(String username, String password) {
        new LoginPage().logIn(username,password);
    }

    @Then("^I get an error message \"([^\"]*)\"$")
    public void iGetAnErrorMessage(String errorMessage)  {
        new LoginPage().verifyLoginErrorMessage(errorMessage);
    }



}
