package paprica_company.canigo_pro.Controller;

import paprica_company.canigo_pro.Model.User;

/**
 * Created by Luana on 15/02/2016.
 */
public class CUser {

    public static void createUser(String pName, String pEmail, String pYear) {
        User pUser = new User(pName, pEmail, pYear);
    }
}
