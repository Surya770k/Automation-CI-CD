	Feature: API
		
  @Sanity
	Scenario Outline: API
	Given I hit the Reqres API with a GET request
	Then I verify the status code as "200"
	Then I Validate the User ID in the Response
	#Then I get the All User ID and Associated Emails


			
			

	