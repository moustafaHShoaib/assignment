@appium
Feature:  MoviesApp

  Scenario: Verify user see movie details via clicking on movie title
    Given i launch the app
    When  i click on movie name
    Then  i can validate movie details on details screen
    Then  i can navigate back to the main movies list screen



  Scenario: Verify user see movie details via clicking on movie Poster
    Given i launch the app
    When  i click on movie Poster
    Then  i can validate movie details on details screen
    Then  i can navigate back to the main movies list screen