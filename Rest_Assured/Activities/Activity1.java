import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity1 {
    // Set base URL
    public static String ROOT_URI="https://petstore.swagger.io/v2/pet/petId";
    @Test(priority=1)
            public void addNewPet() {
        //create JSON Request
        String reqBody = "{"
                + "\"id\": 77232,"
                + "\"name\": \"Riley\","
                + "\"status\": \"alive\""
                + "}";

        Response response =
                given().contentType(ContentType.JSON)//set headers
                        .body(reqBody)//Add request body
                        .when().post(ROOT_URI);//Send POST request

        //Assertion
        response.then().body("id",equalTo(77232));
        response.then().body("name",equalTo("Railey"));
        response.then().body("status",equalTo("alive"));

    }
    @Test(priority=2)
    public void getPetInfo(){
        Response response=
                given().contentType(ContentType.JSON)//set Headers
                        .when().pathParam("petId","77232")//set path parameter
                        .delete(ROOT_URI+"/{petId}"); //send delete request
        //Assertion
        response.then().body("code",equalTo(200));
        response.then().body("message",equalTo("77232"));
    }
}