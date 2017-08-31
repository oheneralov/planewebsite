Feature: CucumberJava

Scenario: Main page loaded
Given I have open the browser
When I open main page
Then baseURL should be http://localhost:8080/simulator