package aws.twitter.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import aws.twitter.Application;



@WebAppConfiguration
@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { Application.class })
public class ApplicationITTest {

 @Test
 public void testAnotherTwitterDataa() {
  io.restassured.RestAssured.with().when().get("/twitterData").then().statusCode(HttpStatus.OK.value());

 }

 // TEST IT TEST DONNE REEL
 // TEST MOCKITO :
 @Test
 public void testAnotherTwitterDataMap() {
  io.restassured.RestAssured.with().when().get("/twitterDataMap").then().statusCode(HttpStatus.OK.value());

  // assertThat(entity.getBody()).hasSize(7234);
 }

 @Test
 public void testAnotherTwitterDataHashTag() {
  io.restassured.RestAssured.with().when().get("/twitterDataHashtag").then().statusCode(HttpStatus.OK.value());

  // assertThat(entity.getBody()).hasSize(6174);
 }

 @Test
 public void testAnotherTwitterData() {
  io.restassured.RestAssured.with().when().get("/twitterDataAll").then().statusCode(HttpStatus.OK.value());

  // assertThat(entity.getBody()).hasSize(25924);
 }


}