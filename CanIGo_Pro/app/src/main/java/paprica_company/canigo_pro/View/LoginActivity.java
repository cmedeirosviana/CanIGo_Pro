package paprica_company.canigo_pro.View;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import paprica_company.canigo_pro.Controller.CUser;
import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.R;

public class LoginActivity extends AppCompatActivity
{
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

        @InjectView(R.id.input_email_login) EditText _emailText;
        @InjectView(R.id.input_password_login) EditText _passwordText;
        @InjectView(R.id.btn_login) Button _loginButton;
        @InjectView(R.id.link_signup) TextView _signupLink;
        @InjectView(R.id.link_fgtPwd) TextView _fgtPwdLink;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.inject(this);
            DBAdapter.getinstance(this.getApplicationContext());

            _loginButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    login();
                }
            });

            _signupLink.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                    startActivityForResult(intent, REQUEST_SIGNUP);
                }
            });

            _fgtPwdLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start the Signup activity
                    // Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                    // startActivityForResult(intent, REQUEST_SIGNUP);
                }
            });
        };

        public void login() {
            Log.d(TAG, "Login");

            if (!CUser.validate()) {
                onLoginFailed();
                return;
            }

            _loginButton.setEnabled(false);

            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Autenticando...");
            progressDialog.show();

            String email = _emailText.getText().toString();
            String password = _passwordText.getText().toString();

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            // On complete call either onLoginSuccess or onLoginFailed
                            onLoginSuccess();
                            // onLoginFailed();
                            progressDialog.dismiss();
                        }
                    }, 3000);
        }


        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            if (requestCode == REQUEST_SIGNUP) {
                if (resultCode == RESULT_OK) {

                    this.finish();
                }
            }
        }

        @Override
        public void onBackPressed() {
            // disable going back to the MainActivity
            moveTaskToBack(true);
        }

        public void onLoginSuccess() {
            _loginButton.setEnabled(true);
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }

        public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Login falhou", Toast.LENGTH_LONG).show();

            _loginButton.setEnabled(true);
        }

}

