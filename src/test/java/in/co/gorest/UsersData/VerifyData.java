package in.co.gorest.UsersData;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import in.co.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.codehaus.groovy.ast.expr.UnaryMinusExpression;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyData extends TestBase {


    @Test
    public void verifyData() {

        Response response = given()
                .when()
                .get("/users");

        //Verify Total records are 10
        Assert.assertEquals(response.jsonPath().getList("data").size(), 10);

        // Verify 2.id 2492 has name = "Fr. Gatik Ahluwalia"
        Assert.assertEquals(response.jsonPath().getString("data[5].name"), "Fr. Gatik Ahluwalia");

        //  Verify All ID has status = "active"
        Assert.assertEquals(response.jsonPath().getString("data.status"), "active");

        // Verify id 2472 has gender = "female"
        Assert.assertEquals(response.jsonPath().getString("data[5].gender"), "female");


    }
}