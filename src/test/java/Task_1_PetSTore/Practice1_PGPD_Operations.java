package Task_1_PetSTore;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Practice1_PGPD_Operations {

	@Test
	public void post1()
	{
	    baseURI="https://petstore.swagger.io/v2";
	    
	    JSONObject obj=new JSONObject();
	     obj.put("id", 19);
	    obj.put("username", "sneha11") ;
	    obj.put("firstName", "Sneha");
	    obj.put("lastName", "Parushetty");
	    obj.put("email","sneha@gmail.com");
	    obj.put("password", "ss@123");
	    obj.put("phone", "9876543245");
	    obj.put("userStatus", 10);
	    
	    given().body(obj).contentType(ContentType.JSON)
	    .when().post("/user")
	    .then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void getUsername()
	{
		baseURI="https://petstore.swagger.io/v2";
		when().get("/user/sneha11").then().assertThat().log().all();
	}
	
	@Test
	public void PutUserNAme()
	{
		baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj=new JSONObject();
	     obj.put("id", 10);
	    obj.put("username", "sneha10") ;
	    obj.put("firstName", "Snehaa");
	    obj.put("lastName", "Parushetti");
	    obj.put("email","sneha586@gmail.com");
	    obj.put("password", "ss@1234");
	    obj.put("phone", "9876543249");
	    obj.put("userStatus", 19);
		
	    given().body(obj).contentType(ContentType.JSON)
	    .when().put("/user/sneha11")
	    .then().assertThat().statusCode(200).log().all();	
	}
	
	@Test
	public void putWithWrongStatusCode()
	{
   baseURI="https://petstore.swagger.io/v2";
		
		JSONObject obj=new JSONObject();
	     obj.put("id", 10);
	    obj.put("username", "sneha10") ;
	    obj.put("firstName", "Snehaa");
	    obj.put("lastName", "Parushetti");
	    obj.put("email","sneha586@gmail.com");
	    obj.put("password", "ss@1234");
	    obj.put("phone", "9876543249");
	    obj.put("userStatus", 19);
		
	    given().body(obj).contentType(ContentType.JSON)
	    .when().put("/user/sneha11")
	    .then().assertThat().statusCode(400).log().all();	
	}
	
	@Test
	public void Deletemethod()
	{
     baseURI="https://petstore.swagger.io/v2";
     when().delete("/user/sneha11").then().assertThat().statusCode(404).log().all();
     
	}
	
	//3rd task
	@Test
	public void requestChainy()
	{
		  baseURI="https://petstore.swagger.io/v2";
		    
		    JSONObject obj=new JSONObject();
		     obj.put("id", 19);
		    obj.put("username", "sneha1") ;
		    obj.put("firstName", "Snehaa");
		    obj.put("lastName", "Parushetty");
		    obj.put("email","sneha@gmail.com");
		    obj.put("password", "ss@123");
		    obj.put("phone", "9876543245");
		    obj.put("userStatus", 10);
		    
		    Response res = given().body(obj).contentType(ContentType.JSON)
		    .when().post("/user");
		    
		   int uname = res.jsonPath().get("code");
		   when().get("/user/sneha1")
		   .then().assertThat().statusCode(uname).log().all();
	}
	
	
}
