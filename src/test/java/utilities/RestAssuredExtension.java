package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


public class  RestAssuredExtension{

    public static RequestSpecification Request;

    // ARRANGE
    public RestAssuredExtension() {

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBaseUri("http://localhost:3000/");
        builder.setContentType(ContentType.JSON);
        var requestSpec = builder.build();

        Request = RestAssured.given().spec(requestSpec);
    }

    // ACT
    public static ResponseOptions<Response> GetOpsWithPathParameter(String url, Map<String, String> pathParams) {

        Request.pathParams(pathParams);
        return Request.get((url));
    }

    //ACT
    public static ResponseOptions<Response> GetOps(String url) {


        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    //ACT
    public static ResponseOptions<Response> PostOpsWithPathAndBodyParams(String url, Map<String, String> pathParams, Map<String, String> bodyParams) {

        Request.pathParams(pathParams);
        Request.body(bodyParams);
        return Request.post((url));
    }

    //ACT
    public static ResponseOptions<Response> PostOpsWithBodyParams(String url, Map<String, String> bodyParams) {

        Request.body(bodyParams);
        return Request.post((url));
    }

    //ACT
    public static ResponseOptions<Response> DeleteOpsWithParams(String url, Map<String, String> pathParams) {

        Request.pathParams((pathParams));
        return Request.delete(url);
    }

    //ACT
    public static ResponseOptions<Response> PUTOpsWithBody(String url, Map<String, String> bodyParams) {

        Request.body(bodyParams);
        return Request.put(url);
    }

    //ACT
    public static ResponseOptions<Response> PUTOpsWithBodyAndPathParams(String url, Map<String, String> bodyParams, Map<String, String> pathParams) {

        Request.pathParams(pathParams);
        Request.body(bodyParams);
        return Request.put(url);
    }
}
