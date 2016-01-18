package paprica_company.canigo_pro.Model;

import android.util.Property;

/**
 * Created by Luana on 18/01/2016.
 */
public class Info {
    int photo;
    String name;
    String birthDate;
    Boolean sex;
    User user;

    public User getUser() {
        return user;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Boolean getSex() {
        return sex;
    }
}
