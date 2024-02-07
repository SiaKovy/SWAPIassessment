package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.CustomResponse;
import entities.CustomResponseListWrapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import org.testng.Assert;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class APIRunner {
    @Getter
    private static CustomResponse customResponse;
    @Getter
    private static CustomResponse[] myResponse;
    @Getter
    private static CustomResponseListWrapper customResponseListWrapper; // For list responses

    public static Response runGET(String path) {
        String url = Config.getValue("SWAPIurl") + path;
        Response response = RestAssured.given().get(url);
        System.out.println("Status code: " + response.statusCode());
        //Assert.assertEquals(response.statusCode(),200);
        Assert.assertTrue(response.contentType().contains("application/json"));
        ObjectMapper mapper = new ObjectMapper();

        try {
            if (path.endsWith("/people/") || path.contains("/people/?page=")) {
                customResponseListWrapper = mapper.readValue(response.asString(), CustomResponseListWrapper.class);
                customResponse = null;
            } else {
                customResponse = mapper.readValue(response.asString(), CustomResponse.class);
                customResponse.setResponseBody(response.asString());
                customResponseListWrapper = null;
                customResponse.setStatusCode(response.statusCode());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error processing API response", e);
        }
        return response;
    }


    public static CustomResponseListWrapper getPeopleResponse() {
        String baseUrl = "https://swapi.dev/api/people/";
        try {
            URL url = new URL(baseUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                StringBuilder inline = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                // Writing all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline.append(scanner.nextLine());
                }
                scanner.close();

                // Using Jackson's ObjectMapper to convert JSON string to CustomResponseListWrapper object
                ObjectMapper mapper = new ObjectMapper();

                return mapper.readValue(inline.toString(), CustomResponseListWrapper.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}