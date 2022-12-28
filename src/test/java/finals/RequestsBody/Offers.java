package finals.RequestsBody;
import org.json.JSONArray;
import org.json.JSONObject;

public class Offers {

    public static final JSONArray posts = new JSONArray()
            .put(1);


    public static final JSONObject REQUESTBODY_ = new JSONObject()
            .put("title", "testowa oferta")
            .put("description", "testowy opis oferty")
            .put("phoneNumber", 123123123)
            .put("price", 10)
            .put("negotiate", true)
            .put("image", posts)
            .put("username", "test testowy");

    public static final JSONObject EDITREQUESTBODY_ = new JSONObject()
            .put("title", "edytowana testowa oferta")
            .put("description", "testowy opis oferty")
            .put("phoneNumber", 321321321)
            .put("price", 5)
            .put("negotiate", false)
            .put("image", posts)
            .put("username", "test testowy");



    public static final String REQUESTBODY = new JSONObject()
            .put("data", REQUESTBODY_)
            .toString();

    public static final String EDITREQUESTBODY = new JSONObject()
            .put("data", EDITREQUESTBODY_)
            .toString();
}