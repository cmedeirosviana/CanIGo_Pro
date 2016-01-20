package paprica_company.canigo_pro.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Caio on 20/01/2016.
 */
public class CommentVote
{
    Drawable image;
    boolean voto;
    int n_comment;

    public Drawable getImage()
    {
        return image;
    }

    public int getN_comment()
    {
        return n_comment;
    }

    public boolean isVoto()
    {
        return voto;
    }


}
