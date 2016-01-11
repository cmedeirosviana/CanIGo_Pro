package swape.canigo_application.Login_screen.Main_Screen;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import java.io.Serializable;

import swape.canigo_application.Login_screen.GeneralApplication;
import swape.canigo_application.Login_screen.Perfil_Screen.PerfilActivity;
import swape.canigo_application.R;

public class PainelActivity extends AppCompatActivity
{

    final static int create_painel=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.painel_activity);

        GeneralApplication painelData = (GeneralApplication)getApplication();

        final ListView listView = (ListView)findViewById(R.id.list_painel);

        PainelAdapter adapter = new PainelAdapter(PainelActivity.this, R.id.imageView_painel,painelData.painelList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                GeneralApplication painelData = (GeneralApplication)getApplication();

                int itemPosition = position;

                Toast.makeText(PainelActivity.this, "Item: " + position, Toast.LENGTH_SHORT).show();

                if (position == create_painel)
                {
                    addPainel();

                } else

                {
                    painelData.getPainelPass(painelData.painelList.get(0).getMpanel(), R.drawable.picture1);
                    finish();
                }

            }
        });

    }

    void showToastMessage(String message) {
        Toast.makeText(PainelActivity.this, message, Toast.LENGTH_SHORT)
                .show();
    }

    public void addPainel() {
        final GeneralApplication painelData=(GeneralApplication)getApplication();
        final AlertDialog.Builder alert = new AlertDialog.Builder(PainelActivity.this);
        final EditText input = new EditText(PainelActivity.this);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString().trim();
                Toast.makeText(PainelActivity.this, value, Toast.LENGTH_SHORT).show();
                painelData.getPainelList(value, R.drawable.picture1);
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
