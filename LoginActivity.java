package fitness.fitnesstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username_entry = (EditText) findViewById(R.id.username_entry);
        final EditText password_entry = (EditText) findViewById(R.id.password_entry);
        final Button sign_in =(Button) findViewById(R.id.sign_in);
        final TextView reset_password = (TextView) findViewById(R.id.reset_password);
        final TextView user_register = (TextView) findViewById(R.id.user_register);

        reset_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reset_intent = new Intent(LoginActivity.this, ResetActivity.class );
                LoginActivity.this.startActivity(reset_intent);
            }
        });

        user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(LoginActivity.this, RegisterActivity.class );
                LoginActivity.this.startActivity(register_intent);

            }
        });

    }
}
