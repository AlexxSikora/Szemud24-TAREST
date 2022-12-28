package finals.RequestsBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

public class Posts {

    public static String slug = String.valueOf((int) Math.floor(Math.random() * 490 + 1));

    public static final JSONArray array = new JSONArray()
            .put(1);


    public static Map<String, String> body() {
        return Map.of("data","{\"title\":" +
                "\"string\",\"shortDescription\":\"string\",\"author\":" +
                "\"string\",\"visitorsCount\":\"123456789\",\"likes\":" +
                "\"fullDescription\":\"string\",\"slug\":\"stringg\"," +
                "\"category\":\"1\"}");
    }


    public static final JSONObject REQUESTBODY_ = new JSONObject()
            .put("title", "tytuł")
            .put("shortDescription", "testowy opis")
            .put("author", "test testowy")
            .put("visitorsCount", "")
            .put("liked", "")
            .put("image", array)
            .put("isImportant", true)
            .put("fullDescription", "testowy opis")
            .put("slug", slug)
            .put("category", "1");


    public static final String REQUESTBODY = new JSONObject()
            .put("data", REQUESTBODY_)
            .toString();
}