package paprica_company.canigo_pro.Controller;

import paprica_company.canigo_pro.Model.User;

/**
 * Created by Luana on 15/02/2016.
 */
public class CUser {

    public static void createUser(String pName, String pEmail, String pYear) {
        User pUser = new User(pName, pEmail, pYear);
    }

    public static Boolean checkUser(String pEmail, String pPsw){
        User pUser = User.getUser(pEmail);
        if(pUser.getSenha()==pPsw)
            return true;
        return false;
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
