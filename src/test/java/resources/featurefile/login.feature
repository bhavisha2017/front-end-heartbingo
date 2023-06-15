
Feature: Login Test

  As a user I should be on the 'heartbingo' homework
  Background: I am on homepage


@smoke @regression
  Scenario Outline: I should be able to log in with valid credentials
    When I accept cookies
    And I click on the Log In Button
    And I log in using username "<username>" and password "<password>"
    Then I get an error message "The username or password you entered is incorrect. Please try again."

    Examples:
      | username       | password  |
      | RedSunshine    | abc1123   |
      | xyz@gmail.com  | 1224444   |
