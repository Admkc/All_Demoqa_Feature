package com.kraft.services;

import com.github.javafaker.Faker;
import com.kraft.utilities.ConfigurationReader;
import io.cucumber.java.it.Ma;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import jdk.jfr.consumer.RecordedStackTrace;

import java.util.HashMap;
import java.util.Map;

public class Register {

    Response response;

    Faker faker=new Faker();

    public static String userID;

    public static String userName;

    public static String token;

    public static String isbn;

    public static String password=ConfigurationReader.get("commonPassword");

    public void registerNewUser(){


        userName=faker.name().fullName();


        Map<String ,Object> body=new HashMap<>();

        body.put("userName",userName);
        body.put("password",password);

        response= RestAssured.given().contentType(ContentType.JSON)
                .and().log().all()
                .body(body)
                .post("/Account/v1/User").prettyPeek();

        userID=response.path("userID");
        System.out.println("userID = " + userID);

    }

    public void verifyRegister(){
        response.then().statusCode(201);
    }
    public void generateToken(){

        userName=ConfigurationReader.get("username");

        Map<String ,Object> body=new HashMap<>();
        body.put("userName",userName);
        body.put("password",password);

        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .body(body)
                .post("/Account/v1/GenerateToken")
                .prettyPeek();

        token=response.path("token");
        System.out.println("token = " + token);


    }
    public void verifyToken(){
        response.then().statusCode(200);


    }
    public void authorized(){

        userName=ConfigurationReader.get("username");

        Map<String ,Object> body=new HashMap<>();

        body.put("userName",userName);
        body.put("password",password);


        Map<String,Object>token=new HashMap<>();
        token.put("Authorization", "Bearer "+ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .body(body)
                .headers(token)
                .post("/Account/v1/Authorized").prettyPeek();


    }
    public void verifyAuthorizedStatusCode(){
        response.then().statusCode(200);
    }

    public void getUserById(){

        Map<String,Object> tokenbody=new HashMap<>();
        tokenbody.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("id", ConfigurationReader.get("userID"))
                .headers(tokenbody)
                .when().log().all()
                .get("/Account/v1/User/{id}").prettyPeek();
    }

    public void verifyUser(){

        response.then().statusCode(200);
    }

    public void allbook(){

        response=RestAssured.given().contentType(ContentType.JSON)
                .when().log().all()
                .get("/BookStore/v1/Books").prettyPeek();
    }

    public void verifyAllBooks(){
        response.then().statusCode(200);
    }

    public void addNewBook(){

        String body="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"collectionOfIsbns\": [\n" +
                "    {\n" +
                "      \"isbn\": \""+ConfigurationReader.get("isbn5")+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        Map<String,Object> tokenbody=new HashMap<>();
        tokenbody.put("Authorization", "Bearer " + ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(tokenbody)
                .body(body)
                .when().log().all()
                .post("/BookStore/v1/Books").prettyPeek();
    }
    public void verifyNewBook(){
        response.then().statusCode(201);
    }

    public void updateBook(){

        String body="{\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\",\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn5")+"\"\n" +
                "}";


        Map<String,Object> token=new HashMap<>();
        token.put("Authorization", "Bearer " +ConfigurationReader.get("token"));

        response= RestAssured.given().contentType(ContentType.JSON)
                .pathParam("isbn", ConfigurationReader.get("isbn4"))
                .headers(token)
                .body(body)
                .when().log().all()
                .put("/BookStore/v1/Books/{isbn}").prettyPeek();
    }

    public void verifyUpdate(){
        response.then().statusCode(200);
    }

    public void deletebook(){


        String body="{\n" +
                "  \"isbn\": \""+ConfigurationReader.get("isbn5")+"\",\n" +
                "  \"userId\": \""+ConfigurationReader.get("userID")+"\"\n" +
                "}";


        Map<String,Object> token=new HashMap<>();
        token.put("Authorization", "Bearer " +ConfigurationReader.get("token"));

        response=RestAssured.given().contentType(ContentType.JSON)
                .body(body)
                .headers(token)
                .when().delete("/BookStore/v1/Book").prettyPeek();

    }

    public void verifyDelete(){
        response.then().statusCode(204);
    }
    public void deleteAccount(){

        Map<String,Object> token=new HashMap<>();
        token.put("Authorization", "Bearer " +ConfigurationReader.get("token"));


        response=RestAssured.given().contentType(ContentType.JSON)
                .headers(token)
                .pathParam("id",ConfigurationReader.get("userID"))
                .when().log().all()
                .delete("/Account/v1/User/{id}").prettyPeek();
    }

    public void verifyAccount(){
        response.then().statusCode(200);
    }
}















