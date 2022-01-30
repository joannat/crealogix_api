import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Pets extends TestBase {

    final String BASE_PATH = "/pet";

    @BeforeTest
    public void testSetUp() {
        RestAssured.basePath = BASE_PATH;
    }


    @Test(dataProvider = "availablePets", dataProviderClass = TestData.class)
    public void getAvailablePets(String statusValue) {

        // Given
        RestAssured.given()
                .param("status", statusValue)
        // When
                .when()
                .get("/findByStatus")
        // Then
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .body()
                .asPrettyString();

    }

    @Test(dataProvider = "addNewPet", dataProviderClass = TestData.class)
    public void addNewPet(String body) {

        // Given
        RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
        // When
                .when()
                .post()
        // Then
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(dataProvider = "changeStatusToSold", dataProviderClass = TestData.class)
    public void changeStatusToSold(String body) {

        // Given
        RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
        // When
                .when()
                .post()
        // Then
                .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(dataProvider = "deletePet", dataProviderClass = TestData.class)
    public void deletePet(String id){

        //Given
        RestAssured.given()
        //When
                .when()
                .delete("/" + id)
        //Then
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}