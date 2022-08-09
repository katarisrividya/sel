package com.RestAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.utility.LibraryFunctions2;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class PUTRequestUpdateUserGoRest {
	@Test
	public void GetRequest() throws FileNotFoundException {
		FileInputStream objFileInput = new FileInputStream(new String(System.getProperty("user.dir") + "//src//test//java//com//RestAssured//UpdateUserGoRest.json"));
		Response res=RestAssured
				     .given()
				     .header("Content-type", "application/json")
					 .and()
					 .body(objFileInput)
					 .auth().oauth2(LibraryFunctions2.ObjProperties.getProperty("TokenOfGoRest"))
				     .when()
				     .put(LibraryFunctions2.ObjProperties.getProperty("PUTRequestURIOfGOREST"));
		Assert.assertEquals(res.getStatusCode(),Integer.parseInt(LibraryFunctions2.ObjProperties.getProperty("StatusCode200")));
		ResponseBody resBody=res.getBody();
		System.out.println("Response for GET API Call of ReqRes"+resBody.asString());
		
		JsonPath jsnPath = res.jsonPath();
		String Name = jsnPath.get("name");
		String Email = jsnPath.get("email");
		String Status=jsnPath.get("status");
		System.out.println("Name:"+Name);
		Assert.assertEquals("Vicky@gmail.com",Email,"User Update is Unsuccessful via mail");
		Assert.assertEquals("inactive",Status,"User Update is Unsuccessful via Status");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			LibraryFunctions2.ReadPropertiesFile(); //To read from config.Properties
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
}
