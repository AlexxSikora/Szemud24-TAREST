package finals.AccountDetails;
import org.json.JSONObject;

public class LoginAccountDetails {
    public static int random = (int) Math.floor(Math.random() * 490 + 1);

    public static final String correctCredentials = new JSONObject()
            .put("identifier", "alex.sikora")
            .put("password", "test1234")
            .toString();

    public static final String EmptyEmailAcc = new JSONObject()
            .put("identifier", "")
            .put("password", "test1234")
            .toString();


    public static final String EmptyPasswordAcc = new JSONObject()
            .put("identifier", "alex.sikora" + random)
            .put("password", "")
            .toString();

    public static final String allBlankFieldsAcc = new JSONObject()
            .put("identifier", "")
            .put("password", "")
            .toString();

}
