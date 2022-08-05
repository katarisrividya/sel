Feature: Delete A User using Delete API in GoRest

Background:
* def config = read('Token.json')
* header Authorization = 'Bearer ' + config.tokenID
* url 'https://gorest.co.in'


Scenario: Delete specified user details in go rest
Given path '/public/v2/users/3913'
When method DELETE
Then status 204