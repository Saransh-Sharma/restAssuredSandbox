package plainRestAssuredTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


public class HelloRestAssured {


    @Test
    public void helloRestAssured_GET_Simple() {

        given()
                .contentType(ContentType.JSON)
        .when()
                .get("http://localhost:3000/posts/")
        .then()
                .body("author", containsInAnyOrder("saransh1337","Carl Sagan", "Richard Feynman", "Sam Harris", "Joe Rogan"))
                .statusCode(200);

    }

}
