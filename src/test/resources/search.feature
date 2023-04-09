Feature: Github search
  Scenario Outline: User will search in github and go to about page
    Given user visits the github website
    When user search with "<repositoryKeyword>"
    Then user verify with "<repositoryName>"
    And user click on about page
    Then user verify the about page
    Examples:
      | repositoryKeyword | repositoryName |
      | create-react-app | facebook/create-react-app |
