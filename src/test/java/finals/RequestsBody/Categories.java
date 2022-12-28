package finals.RequestsBody;
import org.json.JSONArray;
import org.json.JSONObject;

public class Categories {

    public static final JSONArray posts = new JSONArray()
            .put(1);


    public static final JSONObject REQUESTBODY_ = new JSONObject()
            .put("name", "testowa kategoria")
            .put("displayName", "testowa kategoria")
            .put("locale", "en")
            .put("image", posts);

    public static final JSONObject EDITREQUESTBODY_ = new JSONObject()
            .put("name", "edytowana testowa kategoria")
            .put("displayName", "edytowana testowa kategoria")
            .put("locale", "pl")
            .put("image", posts);



    public static final String REQUESTBODY = new JSONObject()
            .put("data", REQUESTBODY_)
            .toString();

    public static final String EDITREQUESTBODY = new JSONObject()
            .put("data", EDITREQUESTBODY_)
            .toString();
}