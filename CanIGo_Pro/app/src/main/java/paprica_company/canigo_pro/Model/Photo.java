package paprica_company.canigo_pro.Model;

import android.graphics.drawable.Drawable;

public class Photo
{

    Drawable image;
    Style style;
    User user;
    int votes_pos;
    int votes_neg;

    public User getUser() {
        return user;
    }

    public Drawable getImage() {
        return image;
    }

    public Style getStyle() {
        return style;
    }

    public int getVotes_pos() {
        return votes_pos;
    }

    public int getVotes_neg() {
        return votes_neg;
    }



}
