Feature: Google Test Scenarios


  Scenario Outline: TC01 Allow user to capture google search number on search result
    # following use case cover google test scenarios

    Given I navigate to google home
    When I enter a keyword <cars> on search field
    When i click on search icon
    When I capture search result
    Then I can extract the search number and print it


    Examples:
      | cars |
      | Lexus|
      |BMW   |

    # each scenario/ scenario outline are individual test cases. no relationship between
    #them
    Scenario: TC02 : Allow user to go to google sign in page




