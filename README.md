
SWAPI Testing Automation Framework

Overview

This comprehensive testing automation framework is tailored for the Star Wars API (SWAPI). Built using Java, it incorporates Cucumber for Behavior-Driven Development (BDD), TestNG for structured testing, and RestAssured for seamless API interactions. Designed with best practices in mind, this framework emphasizes maintainability, reusability, extensibility, and parameterization, making it highly adaptable for future enhancements. It excels in testing multiple endpoints, emphasizing correctness, edge case handling, and exceptional code quality.

Key Features

Rich Reporting
Cucumber Reports: Generates cucumber-report.html, providing a user-friendly UI report from Cucumber for an intuitive overview of test results, including passed and failed scenarios.
TestNG Reports: Offers comprehensive TestNG reporting capabilities, detailing test execution results, which is crucial for in-depth analysis and continuous integration processes.
Maintainability, Extensibility & Reusability
Utilizes modular coding practices, allowing for easy updates and the integration of new tests without altering existing code significantly.

Edge Cases and Exception Handling
Implements sophisticated error handling to manage and log unexpected API responses or failures gracefully.

Code Readability and Organization
Adheres to best coding practices, with a clear structure and well-commented code that explains logic and assumptions, facilitating easy understanding and maintenance.

Parameterization
Demonstrates flexibility by parameterizing requests, such as character and film names, facilitating the testing of various scenarios without hard-coding values.

Schema Validation
Incorporates JSON schema validation for the people endpoint, ensuring response integrity and adherence to expected structures.

Getting Started

Prerequisites
Java JDK 11 or higher.
Maven for dependency management and test execution.
Any IDE like IntelliJ IDEA or Eclipse to access and run the code.
Git for cloning the repository.
Installation & Setup
Clone the Repository: git clone https://github.com/SiaKovy/SWAPIassessment.git
Ensure Configuration: Verify that the configurations.properties file includes the correct SWAPI base URL and other configurations essential for running the tests.
Running the Tests

The CukesRunner class is a central component of our framework, designed to initiate Cucumber tests based on specific tags. This allows for the execution of a targeted subset of tests, ensuring a more focused testing approach and efficient use of resources. By specifying the tags you desire, you can tailor the test runs to your current testing priorities, whether it's a particular feature, regression tests, or smoke tests.

Framework Structure

CustomResponse.java, CustomResponseListWrapper.java, RequestBody.java: Utility classes for handling API responses.
CukesRunner.java: Test runner for Cucumber BDD scenarios.
APIRunner.java: Utility class for handling different http requests.
PeoplesTests.java: Sample test class demonstrating API tests using TestNG.
Config.java: Configuration class for reading properties.
PeopleEndpoint.feature: Cucumber feature file containing BDD scenarios.
configurations.properties: Properties file for API base URL and other configurations.
person_schema.json: JSON schema for validating the people's endpoint response.
Project Extensibility

Adding new tests or endpoints is streamlined to support future API expansions or requirements:

For Cucumber: Add new .feature files for BDD scenarios.
For TestNG: Extend existing classes or add new ones, ensuring to annotate them properly with @Test.
Future Enhancements

The framework is designed for scalability and can accommodate additional APIs, more complex test scenarios, and integration with CI/CD pipelines for automated testing cycles.
