@catFacts
Feature: Cat Facts API

  @getAListOfBreeds @getRandomFact @getAListOfFacts
  Scenario Outline: "<Scenario>"
    Given user goes to url
    When GET request is send with "<endpoint>" endpoint
    Then verifies that Status Code is <statusCode>
    And verifies content-type: "<contentType>"
    Examples:
      | Scenario  | endpoint | statusCode | contentType |
      | Returns a a list of breeds  | /breeds?limit=7 | 200 | application/json  |
      |Returns a random fact  | /fact?max_length=127 | 200 | application/json  |
      | Returns a a list of facts | /facts?max_length=27&limit=27 | 200 | application/json  |