package paprica_company.canigo_pro.Controller;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.io.ByteArrayOutputStream;

import paprica_company.canigo_pro.Model.Pin;
import paprica_company.canigo_pro.Model.User;
import paprica_company.canigo_pro.R;


public class CPin
{


    public static void createPin(String pfolder, byte[] pimage)
    {
        Pin pPin = new Pin(pfolder, pimage);
    }

}


