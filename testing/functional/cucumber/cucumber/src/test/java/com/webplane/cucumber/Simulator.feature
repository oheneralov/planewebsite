Feature: Simulator Page of the web site

Scenario: Verify simulator page links
Given I have open the browser
When I open home page and click on the simulator link
Then Simulator page current URL, menu and title must be similar to ones from config

Scenario: Verify simulator page content
Given I have open the browser
When I open simulator page
Then Content of the simulator page should coincide with the one from Config