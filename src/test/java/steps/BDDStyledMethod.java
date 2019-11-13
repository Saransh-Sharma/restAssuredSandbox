package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;

public class BDDStyledMethod {

    public static void SimpleGETPost(String postNumber) {

        given().contentType(ContentType.JSON).
                when().get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("saransh1337")).     //then().body("author", containsInAnyOrder("saransh1337", "saransh1337", null)).
                statusCode(200);
    }


}
