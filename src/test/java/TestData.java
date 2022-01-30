import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "availablePets")
    public Object[][] availablePets() {
        return new Object[][]{{"available"}};
    }

    @DataProvider(name = "addNewPet")
    public Object[][] addNewPet() {
        String id = "123";

        JSONObject category = new JSONObject();
        category.put("id", "1");
        category.put("name", "Dogs");

        JSONObject tagObject = new JSONObject();
        tagObject.put("id", "10");
        tagObject.put("name", "string");
        JSONArray tags = new JSONArray();
        tags.put(tagObject);

        JSONArray photoUrls = new JSONArray();
        photoUrls.put("string");

        JSONObject pet = new JSONObject();
        pet.put("id", id);
        pet.put("name", "doggie");
        pet.put("status", "available");
        pet.put("category", category);
        pet.put("photoUrls", photoUrls);
        pet.put("tags", tags);

        return new Object[][]{{pet.toString()}};
    }

    @DataProvider(name = "changeStatusToSold")
    public Object[][] changeStatusToSold() {
        String id = "123";

        JSONObject pet = new JSONObject();
        pet.put("id", id);
        pet.put("status", "available");

        return new Object[][]{{pet.toString()}};
    }

    @DataProvider(name = "deletePet")
    public Object[][] deletePet() {
        return new Object[][] {{"123"}};
    }
}
