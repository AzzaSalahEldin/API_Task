package base;

import java.util.List;

import core.coreClass;
import io.restassured.response.Response;

public class baseClass {
	coreClass core = new coreClass();

	public void baseClass() {
		
	}

	public String printResponseField(String api, String field) {
		return core.printResponseField(api, field);
	}

	public List<Integer> responseList(String api, String field) {
		return core.responseList(api, field);
	}
	public Response postRequest(String url,String requestBody) {
		return core.postRequest(url, requestBody);
	}
}
