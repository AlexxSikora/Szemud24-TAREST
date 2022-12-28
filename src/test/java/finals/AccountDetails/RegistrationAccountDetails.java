package finals.AccountDetails;
import org.json.JSONObject;

public class RegistrationAccountDetails {
    public static int random = (int) Math.floor(Math.random() * 490 + 1);

    public static final String correctLoginDetails = new JSONObject()
            .put("username", "alex.sikora" + random)
            .put("email", "alex.sikora" + random + "@test.pl")
            .put("password", "test1234")
            .toString();
}
