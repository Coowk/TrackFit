package fitness.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText user_name = (EditText) findViewById(R.id.user_name);
        final EditText username_entry = (EditText) findViewById(R.id.username_entry);
        final EditText password_first = (EditText) findViewById(R.id.password_first);
        final EditText password_confirm = (EditText) findViewById(R.id.password_confirm);
        final EditText user_weight = (EditText) findViewById(R.id.user_weight);
        final EditText user_height = (EditText) findViewById(R.id.user_height);
        final EditText user_email = (EditText) findViewById(R.id.user_email);
        final EditText user_DoB = (EditText) findViewById(R.id.user_DoB);
        final Button registerButton =(Button) findViewById(R.id.registerButton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final String u_name = user_name.getText().toString();
                final String u_name_entry = username_entry.getText().toString();
                final String password = password_first.getText().toString();
                final int u_weight = Integer.parseInt(user_weight.getText().toString());
                final int u_height = Integer.parseInt(user_height.getText().toString());
                final String u_email = user_email.getText().toString();
                final String u_DoB = user_DoB.getText().toString();

                Response.Listener<String> respList = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String resp) {

                        try {
                            JSONObject jsonResp = new JSONObject(resp);

                                    boolean succ = jsonResp.getBoolean("success");

                                    if (succ){
                                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                        RegisterActivity.this.startActivity(intent);

                                    }

                                    else{
                                        AlertDialog.Builder build = new AlertDialog.Builder(RegisterActivity.this);
                                        build.setMessage("Registration has failed")
                                                .setNegativeButton("Please Retry", null)
                                                .create()
                                                .show();

                                    }

                        }


                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest rRequest = new RegisterRequest(u_name, u_name_entry, password, u_weight, u_height, u_email, u_DoB, respList);
                RequestQueue newQueue = Volley.newRequestQueue(RegisterActivity.this);
                newQueue.add(rRequest);

            }
        });
    }

    }








