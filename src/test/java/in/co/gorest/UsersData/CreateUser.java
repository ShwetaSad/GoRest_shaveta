package in.co.gorest.UsersData;

import in.co.gorest.model.UserPojo;
import in.co.gorest.testbase.TestBase;
import in.co.gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUser extends TestBase {

    @Test
    public void createNewUser() {

        UserPojo userPojo = new UserPojo();
        userPojo.seName("shaveta");
        userPojo.setEmail(TestUtils.getRandomValue() +"shaveta@gmail.com");
        userPojo.setGender("female");
        userPojo.setStatus("active");

        Response response = given()
                .header("Authorization","Bearer 89e7c6fd5a2d0e89b678066fe15dbc7ec6f563c4fc7b65e1464bbb7b56483f0d")
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post("/users");
           response.prettyPrint();
           response.then().statusCode(201);}
}