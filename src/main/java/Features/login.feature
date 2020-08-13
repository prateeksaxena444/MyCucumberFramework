@CRM
Feature: Free CRM Login Feature

Scenario Outline: Free CRM Login Test Scenario

Given user is already on Login Page
When title of login page is Free CRM
Then user clicks on login button
Then user enters "<username>" and "<password>"
Then user is on home page
Then Close the browser


Examples:
	| username | password |
	| Prateek  | test@123 |
	| abcdefg  | test@123 |	
		