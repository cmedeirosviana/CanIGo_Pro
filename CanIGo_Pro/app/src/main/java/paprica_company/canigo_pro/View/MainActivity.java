package paprica_company.canigo_pro.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import paprica_company.canigo_pro.R;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------- Layout creation --------------------------------------------

        ImageView mainImg = (ImageView)findViewById(R.id.mainImg);
        ImageButton likeBtn= (ImageButton)findViewById(R.id.likeBtn);
        ImageButton dislikeBtn = (ImageButton) findViewById(R.id.dislikeBtn);
        ImageButton PinBtn = (ImageButton) findViewById(R.id.PinBtn);
        ImageButton BattleBtn = (ImageButton) findViewById(R.id.BattleBtn);
        ImageButton VersusBtn = (ImageButton) findViewById(R.id.VersusBtn);

        //-------------------------------------- Buttons Implementation --------------------------------------------

        likeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

               //TODO : falta criar a conexão com os outros modulos
            }
        });

        dislikeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        PinBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //TODO : falta criar a conexão com os outros modulos
            }
        });

        BattleBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        VersusBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //TODO : falta criar a conexão com os outros modulos
            }
        });
    }

    //-------------------------------------- Menu Implementation --------------------------------------------

    public void popupSpam(View v)
    {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this);
        inflater.inflate(R.menu.spam_activity, popup.getMenu());
        popup.show();
    }

    //-------------------------------------- Menu Options Implementation --------------------------------------------

    @Override
    public boolean onMenuItemClick(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.conteudo_improprio:
                //TODO:Criar metodo que gerencia os conteudos Improprios
                return true;
            case R.id.spam:
                //TODO:Criar metodo que gerencia os SPAMS
                return true;
            default:
                return false;
        }
    }
    //-------------------------------------- StatusBar Implementation --------------------------------------------



}