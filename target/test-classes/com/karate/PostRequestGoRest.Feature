Feature: To Send the details Of User By PostRequest

Background:
* def config = read('Token.json')
* header Authorization = 'Bearer ' + config.tokenID
* url 'https://gorest.co.in'
* def requestPayload =
 """
 {
    "name": "Testing211",
    "gender": "male",
    "email": "Testing211@gmail.com",
    "status": "active"
} 
"""

Scenario: To send details with given payload

Given path '/public/v2/users'
And request requestPayload
When method post
Then status 201
And match $.id == '#present'
And match $.name == 'Testing211'