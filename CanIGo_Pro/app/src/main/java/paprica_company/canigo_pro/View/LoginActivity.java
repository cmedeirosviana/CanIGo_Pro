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
    private DBAdapter database_sql;
    private final int senhaMinCaracteres = 4;
    private final int senhaMaxCaracteres = 10;

        @InjectView(R.id.input_email_login) EditText _emailText;
        @InjectView(R.id.input_password_login) EditText _passwordText;
        @InjectView(R.id.btn_login) Button _loginButton;
        @InjectView(R.id.link_signup) TextView _signupLink;

        @Override
        public void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            ButterKnife.inject(this);
            DBAdapter.getinstance(this.getApplicationContext());
            CUser.createUser("luana", "lu@yahoo.com.br", "1989");
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
                   // Intent intent = new Intent(getApplicationContext(), SignActivity.class);
                   // startActivityForResult(intent, REQUEST_SIGNUP);
                }
            });
        try
        {
            database_sql=DBAdapter.getinstance(this.getApplicationContext());
            
        }
        catch (SQLException exception)
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Connection not Performed!"+exception.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();
        }
        }

        public void login() {
            Log.d(TAG, "Login");

            if (!validate()) {
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
            CUser.checkUser(email,password);

            // TODO: Banco de dados.

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

                    // TODO: Implement successful signup logic here
                    // By default we just finish the Activity and log them in automatically
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

        }

        public void onLoginFailed() {
            Toast.makeText(getBaseContext(), "Login falhou", Toast.LENGTH_LONG).show();

            _loginButton.setEnabled(true);
        }

        public boolean validate() {
            boolean valid = true;

//            String email = _emailText.getText().toString();
//            String password = _passwordText.getText().toString();
//
//            if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                _emailText.setError("Insira um e-mail válido");
//                valid = false;
//            } else {
//                _emailText.setError(null);
//            }
//
//            if (password.isEmpty() || password.length() < senhaMinCaracteres || password.length() > senhaMaxCaracteres) {
//                _passwordText.setError("Entre " + senhaMinCaracteres + " e " + senhaMaxCaracteres + " caracteres");
//                valid = false;
//            } else {
//                _passwordText.setError(null);
//            }

            return valid;
        }
}

