Feature: Testing Login functionality of Orange HRM application

Scenario: Testing login functionality with valid credentials
	Given User is on Login screen
	When User enters "Admin" in UserName field
	And User enters "admin123" in Password field
	And User clicks on Login button
	Then User should enter into an application
 
Scenario Outline: Testing login functionality with Invalid credentials

	Given User is on Login screen
	When User enters <UserName> in UserName field
	And User enters <Password> in Password field
	And User clicks on Login button
	Then Login Error:<Error> should appear
	Examples:
	|UserName|Password|Error|
	|Rahul|Sajekar|Invalid credentials|
	||admin123|Username cannot be empty|
	|Admin||Password cannot be empty|