#Description : This feature file includes test cases for get and delete postman collections api for postman with validations
  Feature: All the Test cases for get and delete postman collections
    @positive @P1 @GetCollection
    Scenario: Get Postman collection name from Get Request
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "GET" https request
      Then the status code is 200
      And Response should contain "collection.info.name" and "Test UID"

    @negative @P2 @GetCollection
    Scenario: Get Collection with Get Request invalid path
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/ollections/{collection_uid}" with "GET" https request
      Then the status code is 404
      And Response should contain "error.message" and "Requested resource not found"

    @negative @P2 @GetCollection
    Scenario: Get Collection with Get Request invalid APIKEY
      Given Endpoint URL with uid with "InValidAPIkey"
      When user hits "/collections/{collection_uid}" with "GET" https request
      Then the status code is 401
      And Response should contain "error.message" and "Invalid API Key. Every request requires a valid API Key to be sent."

    @negative @P2 @GetCollection
    Scenario: Get Collection with Get Request invalid method
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PATCH" https request
      Then the status code is 404
      And Response should contain "error.message" and "Requested resource not found"

    @negative @P2 @GetCollection
     Scenario: Get Collection with Get Request invalid UID
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "GET" https request with invalid UID
      Then the status code is 404
      And Response should contain "error.name" and "instanceNotFoundError"

   @positive @P1 @DeleteCollection
    Scenario:  Delete the Postman Collection from Delete Request
       Given Endpoint URL with uid with "ValidAPIkey"
       When user hits "/collections/{collection_uid}" with "DELETE" https request
       Then the status code is 200

    @negative @P2 @DeleteCollection
    Scenario: Delete Collection with Delete Request invalid path
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/ollections/{collection_uid}" with "DELETE" https request
      Then the status code is 404
      And Response should contain "error.message" and "Requested resource not found"

    @negative @P2 @DeleteCollection
    Scenario: Delete Collection with Delete Request invalid APIKEY
      Given Endpoint URL with uid with "InValidAPIkey"
      When user hits "/collections/{collection_uid}" with "DELETE" https request
      Then the status code is 401
      And Response should contain "error.message" and "Invalid API Key. Every request requires a valid API Key to be sent."

    @negative @P2 @DeleteCollection
    Scenario: Delete Collection with Delete Request invalid method
      Given Endpoint URL with uid with "InValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PATCH" https request
      Then the status code is 404
      And Response should contain "error.message" and "Requested resource not found"

    @negative @P2 @DeleteCollection
    Scenario: Delete Collection with Delete Request invalid UID
      Given Endpoint URL with uid with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "DELETE" https request with invalid UID
      Then the status code is 404
      And Response should contain "error.name" and "instanceNotFoundError"

