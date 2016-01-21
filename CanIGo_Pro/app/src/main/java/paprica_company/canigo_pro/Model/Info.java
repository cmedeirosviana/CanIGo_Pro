package paprica_company.canigo_pro.Model;

import android.graphics.drawable.Drawable;
import android.util.Property;

public class Info {
    Drawable photo;
    String name;
    String birthDate;
    Boolean sex;
    User user;
    Style style;

    public User getUser() {return user; }

    public Drawable getPhoto() {
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
