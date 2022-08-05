Feature: To Get the details Of User from Reqres

Scenario: Get details Of Specific User

Given url "https://reqres.in/api/users/5"
When method GET
Then status 200

Then print response
* def expectedresult = read('GetUser5Reqres.json')
And match response == expectedresult
And match response.data.id == 5
And match response.data.first_name == "Charles"
And match response.data.last_name != null