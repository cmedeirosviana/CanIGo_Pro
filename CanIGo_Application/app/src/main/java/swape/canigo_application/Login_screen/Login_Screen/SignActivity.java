package swape.canigo_application.Login_screen.Login_Screen;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import swape.canigo_application.Login_screen.Cadastro_Screen.CadastroActivity;
import swape.canigo_application.R;

// Biblioteca que permite criar as informações do layout fora dos métodos.

import butterknife.ButterKnife;
import butterknife.InjectView;


public class SignActivity extends AppCompatActivity {
    private static final String TAG = "SignActivity";
    private final int senhaMinCaracteres =4;
    private final int senhaMaxCaracteres= 10;
    private final int nameMinCaracteres=4;
    private final int delayRunnable=3000;


    //Buttons da tela. Informações adicionais estão no .xml

    @InjectView(R.id.input_name) EditText _nameText;
    @InjectView(R.id.input_email) EditText _emailText;
    @InjectView(R.id.input_password) EditText _passwordText;
    @InjectView(R.id.btn_signup) Button _signupButton;
    @InjectView(R.id.link_login) TextView _loginLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_activity);
        //A biblioteca exige o contexto como dado de entrada.
        ButterKnife.inject(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Dispara o método responsavel pelo cadastro do usuario.
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Finalizando o registro e retornando a activity do Login
                finish();
            }
        });
    }

    public void signup() {

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Criando a conta...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        // TODO: Banco de dados.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        //Caso de sucesso o método onSignupSucess é chamado, caso contrário
                        //onSignupFailed é chamado.
                        onSignupSuccess();

                        progressDialog.dismiss();
                    }
                }, delayRunnable);
    }

    //Caso o cadastro seja realizado com sucesso finaliza a activity
    public void onSignupSuccess() {

        _signupButton.setEnabled(true);

        setResult(RESULT_OK, null);

        Intent intent=new Intent(getApplicationContext(), CadastroActivity.class);
        startActivity(intent);
    }

    //Apresenta mensagem ao usuario caso não seja realizado o cadastro e retorna o controle ao usuario.
    public void onSignupFailed() {

        Toast.makeText(getBaseContext(), "Login Falhou", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    //Método rsponsável por checar se nenhum campo está vazio ou apresenta quantidade minima de caracteres.
    //Checa também se o email é válido

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < nameMinCaracteres) {
            _nameText.setError("Pelo menos" +nameMinCaracteres+ "caracteres");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Insira um e-mail válido");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < senhaMinCaracteres || password.length() > senhaMaxCaracteres) {
            _passwordText.setError("Entre"+senhaMinCaracteres +"e" +senhaMaxCaracteres +"caracteres");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        // TODO: Criar a confirmação do e-mail e comparar com o e-mail inserido anteriormente

        return valid;
    }
}