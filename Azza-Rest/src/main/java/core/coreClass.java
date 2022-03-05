package core;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class coreClass {
	Response response;

	public void coreClass() {
		response = null;
	}

	public String printResponseField(String api, String field) {
		response = given().relaxedHTTPSValidation().when().get(api);
		String responseInString = response.asString();
		JsonPath jsonPath = new JsonPath(responseInString);
		String emailAddress = jsonPath.getString(field);
		return emailAddress;
	}

	public List<Integer> responseList(String api, String field) {
		response = given().when().get(api).then().assertThat().statusCode(200).extract().response();
		String responseInString = response.asString();
		JsonPath jsonPath1 = new JsonPath(responseInString);
		List<Integer> myList = new ArrayList<Integer>();
		myList = jsonPath1.getList(field);
		return myList;
	}

	public Response postRequest(String url, String requestBody) {
		RestAssured.baseURI = url;
		response = RestAssured.given().contentType(ContentType.JSON).body(requestBody).post("posts?userId=2");
		return response;
	}

}
