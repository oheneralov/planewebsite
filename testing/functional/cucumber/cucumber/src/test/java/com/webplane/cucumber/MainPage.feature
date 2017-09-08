Feature: Main Page of the web site

Scenario: Verify home page links
Given I have open the browser
When I open home page
Then Home page current URL, menu and title must be similar to ones from config

Scenario: Verify home page content
Given I have open the browser
When I open home page
Then Content of the page should coincide with the one from Config