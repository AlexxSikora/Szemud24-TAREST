package finals.RequestsBody;
import org.json.JSONArray;
import org.json.JSONObject;

public class Catalogues {

    public static String adNumber = String.valueOf((int) Math.floor(Math.random() * 490 + 1));
    public static String phoneNumber = String.valueOf((int) Math.floor(Math.random() * 999999999 + 1));

    public static final JSONArray image = new JSONArray()
            .put(1);
    public static final JSONArray logo = new JSONArray()
            .put(1);


    public static final JSONObject REQUESTBODY_ = new JSONObject()
            .put("comapnyName", "testowy tytuł")
            .put("description", "testowy opis")
            .put("phoneNumber", "123123123")
            .put("email", "test@test.pl")
            .put("image", image)
            .put("logo", logo)
            .put("town", "Szemud")
            .put("serviceType", "testowa branża")
            .put("adNumber", adNumber);

    public static final JSONObject EDITREQUESTBODY_ = new JSONObject()
            .put("comapnyName", "edytowany tytuł")
            .put("description", "edytowany opis")
            .put("phoneNumber", phoneNumber)
            .put("email", "test@test.eu")
            .put("image", image)
            .put("logo", logo)
            .put("town", "Szemud")
            .put("serviceType", "edytowana branża")
            .put("adNumber", adNumber);


    public static final String REQUESTBODY = new JSONObject()
            .put("data", REQUESTBODY_)
            .toString();

    public static final String EDITREQUESTBODY = new JSONObject()
            .put("data", EDITREQUESTBODY_)
            .toString();
}