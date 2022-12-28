package finals.Acrticles;

import org.apache.http.HttpHeaders;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Posts {

    public static String slug = String.valueOf((int) Math.floor(Math.random() * 490 + 1));


    public static Map<String, String> body() {
        return Map.of("data","{\"title\":" +
                "\"string\",\"shortDescription\":\"string\",\"author\":" +
                "\"string\",\"visitorsCount\":\"123456789\",\"likes\":" +
                "\"123456789\",\"image\":[],\"isImportant\":true," +
                "\"fullDescription\":\"string\",\"slug\":\"stringg\"," +
                "\"category\":\"1\"}");
    }


    public static final String REQUESTBODY_ = new JSONObject()
            .put("title", "tytuł")
            .put("shortDescription", "testowy opis")
            .put("author", "test testowy")
            .put("visitorsCount", "")
            .put("liked", "")
            .put("image", "[]")
            .put("isImportant", true)
            .put("fullDescription", "testowy opis")
            .put("slug", slug)
            .put("category", "1")
            .toString();

    public static final String REQUESTBODY = new JSONObject()
            .put(" data", REQUESTBODY_)
            .toString();


}