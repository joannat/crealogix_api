import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    final String BASE_URI = "https://petstore3.swagger.io/api/v3";

    @BeforeSuite
    public void SetUp() {
        RestAssured.baseURI = BASE_URI;
    }

}
