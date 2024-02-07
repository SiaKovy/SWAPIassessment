package steps;
import entities.CustomResponse;
import entities.CustomResponseListWrapper;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import static org.testng.Assert.*;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.APIRunner;
import utilities.Config;
import java.util.Arrays;
import java.util.List;
public class PeoplesTests {
    CustomResponse customResponse;
    String url;

    @Given("^I set SWAPI base URI$")
    public void iSetSWAPIBaseURI() {
        RestAssured.baseURI = Config.getValue("SWAPIurl");
        System.out.println("Set SWAPI Base URI to: " + RestAssured.baseURI);
    }

    @When("I request {string}")
    public void iRequest(String id) {
        System.out.println("Requesting /people/" + id + "/");
        APIRunner.runGET("/people/" + id + "/");
        this.customResponse = APIRunner.getCustomResponse();
        assertNotNull(customResponse, "CustomResponse should not be null for ID: " + id);
    }

    @Then("I receive valid HTTP response code {int}")
    public void i_receive_valid_http_response_code(Integer expectedStatusCode) {
        Assert.assertEquals(this.customResponse.getStatusCode(), expectedStatusCode, "HTTP status code should be " + expectedStatusCode);    }

    @And("the name in the response should be {string}")
    public void the_name_in_the_response_should_be(String expectedName) {
        if (!"Not Applicable".equals(expectedName)) {
            String actualName = this.customResponse.getName();
            System.out.println("Validating name. Expected: " + expectedName + ", Actual: " + actualName);
            assertEquals(actualName, expectedName, "Name mismatch.");
        }
    }

    @And("the height in the response should be {string}")
    public void the_height_in_the_response_should_be(String expectedHeight) {
        String actualHeight = this.customResponse.getHeight();
        System.out.println("Validating height. Expected: " + expectedHeight + ", Actual: " + actualHeight);
        assertEquals(actualHeight, expectedHeight, "Height mismatch.");
    }

    @And("the mass in the response should be {string}")
    public void the_mass_in_the_response_should_be(String expectedMass) {
        String actualMass = this.customResponse.getMass();
        System.out.println("Validating mass. Expected: " + expectedMass + ", Actual: " + actualMass);
        assertEquals(actualMass, expectedMass, "Mass mismatch.");
    }

    @And("the hair color in the response should be {string}")
    public void the_hair_color_in_the_response_should_be(String expectedHairColor) {
        String actualHairColor = this.customResponse.getHair_color();
        System.out.println("Validating hair color. Expected: " + expectedHairColor + ", Actual: " + actualHairColor);
        assertEquals(actualHairColor, expectedHairColor, "Hair color mismatch.");
    }

    @And("the skin color in the response should be {string}")
    public void the_skin_color_in_the_response_should_be(String expectedSkinColor) {
        String actualSkinColor = this.customResponse.getSkin_color(); // Ensure getSkin_color() matches your method name
        System.out.println("Validating skin color. Expected: " + expectedSkinColor + ", Actual: " + actualSkinColor);
        assertEquals(actualSkinColor, expectedSkinColor, "Skin color mismatch.");
    }

    @And("the eye color in the response should be {string}")
    public void the_eye_color_in_the_response_should_be(String expectedEyeColor) {
        String actualEyeColor = this.customResponse.getEye_color(); // Ensure getEye_color() matches your method name
        System.out.println("Validating eye color. Expected: " + expectedEyeColor + ", Actual: " + actualEyeColor);
        assertEquals(actualEyeColor, expectedEyeColor, "Eye color mismatch.");
    }

    @And("the birth year in the response should be {string}")
    public void the_birth_year_in_the_response_should_be(String expectedBirthYear) {
        String actualBirthYear = this.customResponse.getBirth_year(); // Ensure getBirth_year() matches your method name
        System.out.println("Validating birth year. Expected: " + expectedBirthYear + ", Actual: " + actualBirthYear);
        assertEquals(actualBirthYear, expectedBirthYear, "Birth year mismatch.");
    }

    @And("the gender in the response should be {string}")
    public void the_gender_in_the_response_should_be(String expectedGender) {
        String actualGender = this.customResponse.getGender(); // Make sure getGender() correctly matches your getter method name
        System.out.println("Validating gender. Expected: " + expectedGender + ", Actual: " + actualGender);
        assertEquals(actualGender, expectedGender, "Gender mismatch.");
    }


    @Then("the homeworld URL should be {string}")
    public void the_homeworld_URL_should_be(String expectedHomeworldUrl) {
        String actualHomeworldUrl = customResponse.getHomeworld();
        System.out.println("Validating homeworld URL. Expected: " + expectedHomeworldUrl + ", Actual: " + actualHomeworldUrl);
        assertEquals(expectedHomeworldUrl, actualHomeworldUrl, "Homeworld URL mismatch.");
    }

    @Then("the films list should contain the {list}")
    public void the_films_list_should_contain_the_expected_films(List<String> expectedFilms) {
        List<String> actualFilms = customResponse.getFilms();
        System.out.println("Expected films list: " + expectedFilms);
        System.out.println("Actual films list: " + actualFilms);
        boolean filmsMatch = actualFilms.containsAll(expectedFilms) && expectedFilms.containsAll(actualFilms);
        assertTrue(filmsMatch, "Films list does not match the expected values.");
    }

    @Then("the species list should contain the {list}")
    public void the_species_list_should_contain_the_expected_species(List<String> expectedSpecies) {
        List<String> actualSpecies = customResponse.getSpecies();
        System.out.println("Expected species list: " + expectedSpecies);
        System.out.println("Actual species list: " + actualSpecies);
        if (!expectedSpecies.isEmpty() && !actualSpecies.isEmpty()) {
            assertTrue(actualSpecies.containsAll(expectedSpecies) && expectedSpecies.containsAll(actualSpecies),
                    "Species list does not match the expected values.");
        }
    }

    @Then("the vehicles list should contain the {list}")
    public void the_vehicles_list_should_contain_the_expected_vehicles(List<String> expectedVehicles) {
        List<String> actualVehicles = customResponse.getVehicles();
        System.out.println("Expected vehicles list: " + expectedVehicles);
        System.out.println("Actual vehicles list: " + actualVehicles);
        if (!expectedVehicles.isEmpty() && !actualVehicles.isEmpty()) {
            assertTrue(actualVehicles.containsAll(expectedVehicles) && expectedVehicles.containsAll(actualVehicles),
                    "Vehicles list does not match the expected values.");
        }
    }

    @Then("the starships list should contain the {list}")
    public void the_starships_list_should_contain_the_expected_starships(List<String> expectedStarships) {
        List<String> actualStarships = customResponse.getStarships();
        System.out.println("Expected starships list: " + expectedStarships);
        System.out.println("Actual starships list: " + actualStarships);
        if (!expectedStarships.isEmpty() && !actualStarships.isEmpty()) {
            assertTrue(actualStarships.containsAll(expectedStarships) && expectedStarships.containsAll(actualStarships),
                    "Starships list does not match the expected values.");
        }
    }


    @Then("the URL should be {string}")
    public void the_URL_should_be(String expectedUrl) {
        String actualUrl = customResponse.getUrl();
        System.out.println("Validating URL. Expected: " + expectedUrl + ", Actual: " + actualUrl);
        assertEquals(expectedUrl, actualUrl, "URL mismatch.");
    }

    @When("I request an invalid person with ID {string}")
    public void i_request_an_invalid_person_with_id(String invalidId) {
        System.out.println("Requesting an invalid person with ID: " + invalidId);
        APIRunner.runGET("/people/" + invalidId + "/");
        this.customResponse = APIRunner.getCustomResponse();
    }

    @Then("I receive an error response")
    public void i_receive_an_error_response() {
        Assert.assertTrue(this.customResponse.getStatusCode() >= 404,
                "Expected an error response, but received status code: " + this.customResponse.getStatusCode());
    }

    @Then("I validate the people schema")
        public void i_validate_the_people_schema () {
        String schemaUrl = Config.getValue("SWAPIurl") + "people/schema/";
        Response response = RestAssured.given().get(schemaUrl.trim()); // Ensure no trailing spaces
        System.out.println("Validating schema. Status code: " + response.statusCode());
        assertEquals(response.statusCode(), 404, "Schema endpoint not accessible.");
        assertTrue(response.contentType().contains("application/json"), "Incorrect content type for schema.");

        String responseBody = APIRunner.getCustomResponse().getResponseBody();
        Assert.assertNotNull(responseBody, "Response body should not be null.");
        try {
            RestAssured.given()
                    .body(responseBody)
                    .when()
                    .then()
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/person_schema.json"));
        } catch (AssertionError e) {
            Assert.fail("JSON schema validation failed: " + e.getMessage());
        }
    }

    @Then("I validate the list of all people")
        public void i_validate_the_list_of_all_people () {
        APIRunner.runGET("people/");
        CustomResponseListWrapper response = APIRunner.getPeopleResponse();
        assertNotNull(response);
        assertEquals(response.getNext(), "https://swapi.dev/api/people/?page=2");
        assertNull(response.getPrevious());

        List<String> names = response.getResults().stream().map(CustomResponse::getName).toList();
        assertTrue(names.containsAll(Arrays.asList("Luke Skywalker", "C-3PO", "R2-D2")));

        System.out.println("Characters found: " + response.getResults().size());

        for (CustomResponse customResponse : response.getResults()) {
                assertNotNull(customResponse.getName());
                assertNotNull(customResponse.getHeight());
                assertNotNull(customResponse.getMass());
                assertNotNull(customResponse.getHair_color());
                assertNotNull(customResponse.getSkin_color());
                assertNotNull(customResponse.getEye_color());
                assertNotNull(customResponse.getBirth_year());
                assertNotNull(customResponse.getGender());

            }
        }
    @ParameterType("\\[(.*?)\\]")
    public List<String> list(String listAsString) {
        return Arrays.asList(listAsString.split(", "));
    }

    }










