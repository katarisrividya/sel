Feature: Update User Details Using PUT

Background:
* def config = read('Token.json')
* header Authorization = 'Bearer ' + config.tokenID
* url 'https://gorest.co.in'
* def requestPayload =
 """
 {

    "name": "Testing23",
    "email": "Testing23@gmail.com",
    "status": "inactive"
}  
"""

Scenario: To update details with given payload

Given path '/public/v2/users/3844'
And request requestPayload
When method PUT
Then status 200
And match $.id == '#present'
And match $.status == 'inactive'