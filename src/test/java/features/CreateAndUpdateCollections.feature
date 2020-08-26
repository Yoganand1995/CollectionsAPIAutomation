# Description : This feature file includes test cases for create and update postman collections api for postman with validations
  Feature: This feature includes the create and update of the collections in postman
    @positive @P1 @CreateCollection
    Scenario: Create the Collection with Post Request
      Given "Create" collection "Valid" payload with collection name "Test Collection" with "ValidAPIkey"
      When user hits "/collections" with "POST" https request
      Then the status code is 200
      And Response should contain "collection.name" and "Test Collection"
      And Returned json schema is "Create-Collection-schema.json"
      And Assert RequestName and ResponseName

    @negative @P2 @CreateCollection
    Scenario: Create the Collection with Post Request invalid path
      Given "Create" collection "Valid" payload with collection name "Test Collection" with "ValidAPIkey"
      When user hits "/ollections" with "POST" https request
      Then the status code is 404
      And Response should contain "error.message" and "Requested resource not found"

    @negative @P2 @CreateCollection
    Scenario: Create the Collection with Post Request invalid APIKEY
      Given "Create" collection "Valid" payload with collection name "Test Collection" with "InValidAPIkey"
      When user hits "/collections" with "POST" https request
      Then the status code is 401
      And Response should contain "error.message" and "Invalid API Key. Every request requires a valid API Key to be sent."


    @negative @P2 @CreateCollection
    Scenario: Create the Collection with Post Request invalid payload
      Given "Create" collection "InValid" payload with collection name "Test Collection" with "ValidAPIkey"
      When user hits "/collections" with "POST" https request
      Then the status code is 400
      And Response should contain "error.name" and "malformedRequestError"

    @positive @P1 @UpdateCollection
    Scenario: Update the collection with Put Request
      #update the collection
      Given "Update" collection "Valid" payload with collection name "Update Collection" with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PUT" https request
      Then the status code is 200
      And Response should contain "collection.name" and "Update Collection"
      And Returned json schema is "Update-Collection-schema.json"

    @negative @P2 @UpdateCollection
    Scenario: Update the collection with Put Request invalid uid
      Given "Update" collection "Valid" payload with collection name "Update Collection" with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PUT" https request with invalid UID
      Then the status code is 404
      And Response should contain "error.name" and "instanceNotFoundError"

    @negative @P2 @UpdateCollection
    Scenario: Update the Collection with Put Request invalid APIKEY
      Given "Update" collection "Valid" payload with collection name "Update Collection" with "InValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PUT" https request
      Then the status code is 401
      And Response should contain "error.message" and "Invalid API Key. Every request requires a valid API Key to be sent."


    @negative @P2 @UpdateCollection
    Scenario: Update the Collection with Put Request invalid payload
      Given "Update" collection "InValid" payload with collection name "Update Collection" with "ValidAPIkey"
      When user hits "/collections/{collection_uid}" with "PUT" https request
      Then the status code is 400
      And Response should contain "error.name" and "malformedRequestError"