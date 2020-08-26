package stepDefinations;

import Resources.Payloads;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;

public class stepDefinations extends Utils {
    static final Logger logger = LogManager.getLogger(stepDefinations.class.getName());
    Payloads payload = new Payloads();
    RequestSpecification Request;
    Response response;
    String UID;
    String RequestName;
    String ResponseName;

    @Given("{string} collection {string} payload with collection name {string} with {string}")
    public void collection_payload_with_collection_name_with(String Collection, String Payload, String ColName, String APIKey) throws IOException {
           if (Collection.equalsIgnoreCase("Create")){
               RequestName = ColName;
               if(Payload.equalsIgnoreCase("Valid")){
                    Request = given().spec(RequestSpec(APIKey)).body(payload.CreateCollectionPayload(ColName));
               }else{
                    Request = given().spec(RequestSpec(APIKey)).body(payload.CreateCollectionInValidPayload(ColName));
               }
           }else{
               if(Payload.equalsIgnoreCase("Valid")){
                   Request = given().spec(RequestSpec(APIKey)).body(payload.UpdateCollectionPayload(ColName));
               }else{
                   Request = given().spec(RequestSpec(APIKey)).body(payload.UpdateCollectionInValidPayload(ColName));
               }
           }
    }

    @Given("Endpoint URL with uid with {string}")
    public void endpoint_url_with_uid_with_something(String APIKey) throws IOException {
        Request = given().spec(RequestSpec(APIKey));
    }

    @When("user hits {string} with {string} https request")
    public void user_hits_with_https_request(String Path, String RequestMethod) throws IOException {
        QueryableRequestSpecification query = SpecificationQuerier.query(Request);
        if(RequestMethod.equalsIgnoreCase("POST")){
             response = Request.when().post(Path).then().extract().response();
             if(response.getStatusCode() == 200) {
                 ResponseName = GetJSONValue(response, "collection.name");
                 UID = GetJSONValue(response, "collection.uid");
             }
        }else if(RequestMethod.equalsIgnoreCase("PUT")){
            response = Request.pathParam("collection_uid",getUID()).when().put(Path).then().extract().response();
        }else if(RequestMethod.equalsIgnoreCase("GET")){
            response = Request.pathParam("collection_uid",getUID()).when().get(Path).then().extract().response();
        }else if (RequestMethod.equalsIgnoreCase("DELETE")){
            response = Request.pathParam("collection_uid",getUID()).when().delete(Path).then().extract().response();
        }else{
            response = Request.pathParam("collection_uid",getUID()).when().patch(Path).then().extract().response();
        }
        logger.info("The Request Details are "+ query.getBaseUri()+" "+ Path +" "+ query.getMethod() +" "+ query.getBody());
        logger.info("The Response is "+ response.asString());
    }
    @When("user hits {string} with {string} https request with invalid UID")
    public void user_hits_something_with_something_https_request_with_invalid_uid(String Path, String RequestMethod)  {
        QueryableRequestSpecification query = SpecificationQuerier.query(Request);
        String InValidUID = "123"; // local string uid hardcoded
        if(RequestMethod.equalsIgnoreCase("PUT")){
            response = Request.pathParam("collection_uid",InValidUID).when().put(Path).then().extract().response();
        }else if(RequestMethod.equalsIgnoreCase("GET")){
            response = Request.pathParam("collection_uid",InValidUID).when().get(Path).then().extract().response();
        }else {
            response = Request.pathParam("collection_uid",InValidUID).when().delete(Path).then().extract().response();
        }
        logger.info("The Request Details are "+ query.getBaseUri()+" "+ Path +" "+ query.getMethod() +" "+ query.getBody());
        logger.info("The Response is "+ response.asString());
    }

    @Then("the status code is {int}")
    public void the_status_code_is(int RespStatusCode) {
        assertEquals(RespStatusCode,response.getStatusCode());
    }

    @And("Response should contain {string} and {string}")
    public void response_should_contain_and(String ResponseKey, String Value) {
        assertEquals(GetJSONValue(response,ResponseKey),Value);
    }

    @And("Returned json schema is {string}")
    public void returned_json_schema_is_something(String Filename) {
        String basePath = System.getProperty("user.dir");
        File file = new File(basePath+"\\src\\test\\java\\Resources\\Schema\\"+Filename);
        response.then().body(matchesJsonSchema(file));
    }

    @And("Assert RequestName and ResponseName")
    public void assert_requestname_and_responsename() {
        assertEquals(RequestName,ResponseName);
    }

    public  String getUID() throws IOException {
        RequestSpecification Req = given().spec(RequestSpec("ValidAPIkey")).body(payload.CreateCollectionPayload("Test UID"));
        Response Res = Req.when().post("/collections").then().extract().response();
        return GetJSONValue(Res,"collection.uid");
    }


}

