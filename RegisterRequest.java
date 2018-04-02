package fitness.fitnesstracker;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL = "https://localhost/register.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String username, String password, int user_weight, int user_height, String user_email, String user_DoB, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null  );
        params = new HashMap<>();
        params.put("name", name);
        params.put("username", username);
        params.put("password", password);
        params.put("user_weight", user_weight + "");
        params.put("user_height", user_height + "");
        params.put("user_DoB", user_DoB);

    }


    public Map<String, String> returnParameters() {
        return params;

    }

}
