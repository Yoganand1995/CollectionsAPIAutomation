package stepDefinations;

import Resources.Utils;
import io.cucumber.java.After;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Hooks extends Utils {
    RequestSpecification Req;
    RequestSpecification DelReq;
    Response GetCollections;
    Response DelResponse;

    @After
    public void cleanup() throws IOException {
        Req = given().spec(RequestSpec("ValidAPIKEY"));
        GetCollections = Req.when().get("/collections").then().extract().response();
        JsonPath js = new JsonPath(GetCollections.asString());
        int Size = js.get("collections.size()");
        for (int i = 0; i < Size; i++) {
            String ColName = js.get("collections[" + i + "].name").toString();
            if (ColName.contains("Test") || ColName.contains("Update")) {
                String Uid = js.get("collections[" + i + "].uid");
                DelReq = given().spec(RequestSpec("ValidAPIKEY"));
                DelResponse = DelReq.pathParam("collection_uid", Uid).when()
                        .delete("/collections/{collection_uid}").then().extract().response();
                assertEquals(200, DelResponse.getStatusCode());
            }
        }


    }

}
