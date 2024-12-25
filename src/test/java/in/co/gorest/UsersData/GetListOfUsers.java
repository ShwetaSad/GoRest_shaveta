package in.co.gorest.UsersData;

import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetListOfUsers extends TestBase {

     @Test
    public void getListOfUsers(){

        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .get("/users");
        response.prettyPrint();
        response.then().statusCode(200);


    }
}
