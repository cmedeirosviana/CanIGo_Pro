package paprica_company.canigo_pro.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import paprica_company.canigo_pro.R;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------- Layout creation --------------------------------------------

        ImageView mainImage = (ImageView)findViewById(R.id.mainImg);
        ImageButton likeButton= (ImageButton)findViewById(R.id.likeBtn);
        ImageButton dislikeButton = (ImageButton) findViewById(R.id.dislikeBtn);
        ImageButton spamButton = (ImageButton) findViewById(R.id.spamBtn);

        //-------------------------------------- Buttons Implementation --------------------------------------------

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

               //TODO : falta criar a conexão com os outros modulos
            }
        });

        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        spamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

    }
}