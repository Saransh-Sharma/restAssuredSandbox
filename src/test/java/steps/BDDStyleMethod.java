package steps;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class BDDStyleMethod {

    //solution 1 type 1: simple get
    public static void SimpleGETPost(String postNumber) {

                given().contentType(ContentType.JSON).
                when().
                    get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().body("author", is("saransh1337")).     //then().body("author", containsInAnyOrder("saransh1337", "saransh1337", null)).
                statusCode(200);
    }

    //solution 1 type 2: simple get collection
    public static void PerformContainsCollection() {
                given()
                    .contentType(ContentType.JSON)
                .when()
                    .get("http://localhost:3000/posts/").
                then()
      //              .body("author", containsInAnyOrder("saransh1337", "Carl Sagan", "Richard Feynman", "Sam Harris", "Joe Rogan"));
                    .body("author",
                            containsInAnyOrder( "Carl Sagan", "saransh1337", "Richard Feynman", "Sam Harris", "Joe Rogan"))
                        .statusCode(200);
    }

    //solution 2 type 1: get with custom query params
    public static void performWithPathParams(String postNum) {

        given().
                    contentType(ContentType.JSON).
                with().
                    pathParams("postNumber",postNum).
                when().
                    get(("http://localhost:3000/posts/{postNumber}")).
                then().body("author", is("saransh1337")).     //then().body("author", containsInAnyOrder("saransh1337", "saransh1337", null)).
                    statusCode(200);
    }

}
