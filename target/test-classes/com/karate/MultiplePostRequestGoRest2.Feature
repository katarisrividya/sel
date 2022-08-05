Feature: To Send the details Of User By PostRequest

Background:
* def config = read('Token.json')
* header Authorization = 'Bearer ' + config.tokenID
* url 'https://gorest.co.in'
* def requestPayload1 =
 """
 {
    "name": "Testing121",
    "gender": "male",
    "email": "Testing121@gmail.com",
    "status": "active"
} 
"""
* def requestPayload2 =
 """
 {
    "name": "Testing241",
    "gender": "Female",
    "email": "Testing241@gmail.com",
    "status": "active"
} 
"""

Scenario: To send details with given payload

Given path '/public/v2/users'
And request requestPayload1
And request requestPayload2
When method post
Then status 201

Then print response.id