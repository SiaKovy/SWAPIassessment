Feature: API Testing for People Endpoint

  Background:
    Given I set SWAPI base URI

  @Test
  Scenario Outline: Retrieve information about a valid person
    When I request "<id>"
    Then I receive valid HTTP response code <status_code>
    And the name in the response should be "<name>"
    And the height in the response should be "<height>"
    And the mass in the response should be "<mass>"
    And the hair color in the response should be "<hair_color>"
    And the eye color in the response should be "<eye_color>"
    And the birth year in the response should be "<birth_year>"
    And the gender in the response should be "<gender>"
    Examples:
      | id  | status_code | name           | height | mass | hair_color | eye_color | birth_year | gender |
      | 1   | 200         | Luke Skywalker | 172    | 77   | blond      | blue      | 19BBY      | male   |
      | 2   | 200         | C-3PO          | 167    | 75   | n/a        | yellow    | 112BBY    | n/a    |
      | 3   | 200         | R2-D2          | 96     | 32   | n/a        | red       | 33BBY    | n/a    |

  @Test
  Scenario Outline: Validation of People Attributes and Pagination Links for Multiple Individuals
    When I request "<id>"
    Then I receive valid HTTP response code 200
    And the homeworld URL should be <expectedHomeworld>
    And the films list should contain the <expected_films>
    And the species list should contain the <expected_species>
    And the vehicles list should contain the <expected_vehicles>
    And the starships list should contain the <expected_starships>
    And the URL should be <expected_url>

    Examples:
      | id | expectedHomeworld                 | expected_url               | expected_films | expected_species | expected_vehicles | expected_starships |
      | 1  | "https://swapi.dev/api/planets/1/"  | "https://swapi.dev/api/people/1/" | [https://swapi.dev/api/films/1/, https://swapi.dev/api/films/2/, https://swapi.dev/api/films/3/, https://swapi.dev/api/films/6/] | [] | [https://swapi.dev/api/vehicles/14/, https://swapi.dev/api/vehicles/30/] | [https://swapi.dev/api/starships/12/, https://swapi.dev/api/starships/22/] |
      | 2  | "https://swapi.dev/api/planets/1/"  | "https://swapi.dev/api/people/2/" | [https://swapi.dev/api/films/1/, https://swapi.dev/api/films/2/, https://swapi.dev/api/films/3/, https://swapi.dev/api/films/4/, https://swapi.dev/api/films/5/, https://swapi.dev/api/films/6/] | [https://swapi.dev/api/species/2/] | [] | [] |
      | 3  | "https://swapi.dev/api/planets/8/"  | "https://swapi.dev/api/people/3/" | [https://swapi.dev/api/films/1/, https://swapi.dev/api/films/2/, https://swapi.dev/api/films/3/, https://swapi.dev/api/films/4/, https://swapi.dev/api/films/5/, https://swapi.dev/api/films/6/] | [https://swapi.dev/api/species/2/] | [] | [] |

  @Test
  Scenario: Attempt to retrieve information with an invalid person ID
    When I request an invalid person with ID "100"
    Then I receive an error response

  @Test
  Scenario: Verify behavior when SWAPI server is down
   # When the SWAPI server is down
   # And I send a request
   # Then I receive a server error response

  @Test
  Scenario: Verify behavior with maximum ID
    When I request "83"
    Then I receive valid HTTP response code 200
    And the URL should be "https://swapi.dev/api/people/83/"

  @Test
  Scenario: Verify behavior with a negative person ID
    When I request "-1"
    Then I receive an error response

  @Test
  Scenario: Verify behavior with a large person ID
    When I request "99999"
    Then I receive valid HTTP response code 404
    Then I receive an error response

  @Test
  Scenario: Verify behavior with a non-numeric person ID
    When I request "abc"
    Then I receive an error response

  @Test
  Scenario: Verify behavior with a special character person ID
    When I request "$%^"
    Then I receive an error response

  @Test
  Scenario: Validate People JSON Schema
    Then I validate the people schema

  @Test
  Scenario: List all people and validate response
    Then I validate the list of all people


