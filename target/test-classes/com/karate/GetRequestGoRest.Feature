Feature: To Get the details Of User from GoRest

Background:
* def config = read('Token.json')
* header Authorization = 'Bearer ' + config.tokenID

Scenario: Get details Of All Users

Given url 'https://gorest.co.in'
When method GET
Then status 200

Then print response