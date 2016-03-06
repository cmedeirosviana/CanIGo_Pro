package paprica_company.canigo_pro.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import paprica_company.canigo_pro.Dao.DBAdapter;
import paprica_company.canigo_pro.Model.Pin;
import paprica_company.canigo_pro.Model.User;
import paprica_company.canigo_pro.R;

public class Pin_Activity extends Activity
{
    private DBAdapter database_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_pin);

        DBAdapter.getinstance(this.getApplicationContext());

        List<String> list_test = new ArrayList<String>();

        //--------------------------------------ImageView convertion in data Type Byte--------------------------------------------------------------------

        Drawable drawable = getDrawable(R.drawable.canigo);
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();

        Pin ppin = new Pin("Painel Legal",byteArray);

        //--------------------------------------Get back to Bitmap format--------------------------------------------------------------------

        try
        {
            database_sql= DBAdapter.getinstance(this.getApplicationContext());

        }
        catch (SQLException exception)
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Connection not Performed!"+exception.getMessage());
            dlg.setNegativeButton("OK", null);
            dlg.show();
        }

        Bitmap compressedBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        list_test.add("B");
        list_test.add("C");
        list_test.add("B");
        list_test.add("C");
        list_test.add("B");

        ListView pinList = (ListView)findViewById(R.id.pinList);

        Pin_Adapter pin_adapter = new Pin_Adapter(Pin_Activity.this, R.id.panelImg,list_test);

        pinList.setAdapter(pin_adapter);

        pinList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                addPainel();
            }
        });

    }
    //-------------------------------------- AlertDialog responsable for add new panel --------------------------------------------

    public void addPainel()
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(Pin_Activity.this);
        final EditText input = new EditText(Pin_Activity.this);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString().trim();
                Toast.makeText(Pin_Activity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }


}
