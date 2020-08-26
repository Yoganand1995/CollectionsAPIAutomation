package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Utils {

    private static RequestSpecification ValidReq;
    private static RequestSpecification InValidReq;

    public static String GetGlobalValue(String RequiredVariable) throws IOException {
        Properties GlobalProperty = new Properties();
        String LocalUserPath = System.getProperty("user.dir");
        FileInputStream File = new FileInputStream(LocalUserPath + "\\src\\test\\java\\Resources\\GlobalValue.properties");
        GlobalProperty.load(File);
        return GlobalProperty.getProperty(RequiredVariable);
    }

    public String GetJSONValue(Response response, String Key) {
        JsonPath js = new JsonPath(response.asString());
        return js.get(Key).toString();
    }

    public int GetJSONArraySize(Response response, String ArrayPath) {
        JsonPath js = new JsonPath(response.asString());
        List<Object> ObjectArray = js.get(ArrayPath);
        return ObjectArray.size();
    }

    public List GetJSONArray(Response response, String ArrayPath) {
        JsonPath js = new JsonPath(response.asString());
        return js.<List<Object>>get(ArrayPath);
    }


    public RequestSpecification RequestSpec(String KeyType) throws IOException {
        if (KeyType.equalsIgnoreCase("ValidAPIkey")) {
            ValidReq = new RequestSpecBuilder().setBaseUri(GetGlobalValue("baseURI"))
                    .addHeader("X-Api-Key", GetGlobalValue("ValidAPI-Key"))
                    .setContentType(ContentType.JSON).build();
            return ValidReq;
        } else {
            InValidReq = new RequestSpecBuilder().setBaseUri(GetGlobalValue("baseURI"))
                    .addHeader("X-Api-Key", GetGlobalValue("InvalidAPI-Key"))
                    .setContentType(ContentType.JSON).build();
            return InValidReq;
        }
    }


}
