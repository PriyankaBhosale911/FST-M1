package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.oauth2;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class GitHubProject {

    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    int keyId;
    String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIHb7+WtqHiXOyrDH1mRTzioIOyuURDe4NvuGUppwU2OB";

    @BeforeClass
    public void setup(){
        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.github.com/user/keys").
                addHeader("Content-Type", "application/json").
                        setAuth(oauth2("ghp_YNiEr0NUE2zttbNH2JzR7hs1riwYOf8rOe4N")).
                build();

        responseSpec = new ResponseSpecBuilder().
                expectResponseTime(lessThanOrEqualTo(3000L)).
                build();
    }

    @Test(priority =1)
    public void postRequest(){
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("title","TestKey");
        reqBody.put("key",sshKey);

        Response response = given().spec(requestSpec).body(reqBody).log().all().when().post();
        System.out.println(response.getBody().asPrettyString());

        keyId = response.then().extract().path("id");
        response.then().spec(responseSpec).statusCode(201).body("key",equalTo(sshKey));
    }

    @Test(priority =2)
    public void getRequest(){
        given().spec(requestSpec).pathParams("keyId",keyId).log().all().
                when().get("/{keyId}").
                then().spec(responseSpec).statusCode(200).log().all();
    }
    @Test(priority =3)
    public void deleteRequest(){
        given().spec(requestSpec).pathParams("keyId",keyId).
                when().delete("/{keyId}").
                then().statusCode(204).log().all();
    }
}
