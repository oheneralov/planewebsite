Feature: Theory Page of the web site

Scenario: Verify theory page links
Given I have open the browser
When I open home page and click on the theory link
Then Then theory page current URL, menu and title must be similar to ones from config

Scenario: Verify theory page content
Given I have open the browser
When I open theory page
Then Content of the theory page should coincide with the one from Config