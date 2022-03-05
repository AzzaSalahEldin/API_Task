package Azza_Rest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.baseClass;
import org.junit.Assert;

import java.util.ArrayList;

public class NewTest {
	baseClass base;

	@BeforeMethod
	public void NewTestBeforeMethod() {
		base = new baseClass();
	}

	@Test
	public void getMethod() {
		System.out.println(base.printResponseField("https://jsonplaceholder.typicode.com/users?id=2", "email"));
		ArrayList<Integer> myList2 = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			myList2.add(i + 1);
		}
		try {
			Assert.assertTrue(myList2
					.containsAll(base.responseList("https://jsonplaceholder.typicode.com/posts?userId=2", "id")));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void postMethod() {
		String requestBody = " {\n" + "  \"userId\": 1,\n" + "  \"id\": 1,\n" + "  \"title\": \"test-title\",\n"
				+ "  \"body\": \"test-body\"\n" + "}";
		System.out.println(
				"Response :" + base.postRequest("https://jsonplaceholder.typicode.com", requestBody).asString());
		System.out.println("Status Code :"
				+ base.postRequest("https://jsonplaceholder.typicode.com", requestBody).getStatusCode());
		System.out.println("Does Reponse contains 'test-'? :"
				+ base.postRequest("https://jsonplaceholder.typicode.com", requestBody).asString().contains("test-"));
		Assert.assertTrue(
				base.postRequest("https://jsonplaceholder.typicode.com", requestBody).asString().contains("test-"));
	}
}
