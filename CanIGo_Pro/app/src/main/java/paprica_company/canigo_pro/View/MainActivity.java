package paprica_company.canigo_pro.View;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import paprica_company.canigo_pro.R;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,MenuItem.OnMenuItemClickListener
{

    private DrawerLayout drawerLayout ;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------- Layout creation --------------------------------------------

        ImageView mainImg = (ImageView)findViewById(R.id.mainImg);
        ImageView likeBtn= (ImageView)findViewById(R.id.likeBtn);
        ImageView dislikeBtn = (ImageView) findViewById(R.id.dislikeBtn);
        ImageView pinBtn = (ImageView) findViewById(R.id.PinBtn);
        ImageView versusBtn = (ImageView) findViewById(R.id.versusBtn);
        ImageView perfilBtn = (ImageView) findViewById(R.id.perfilBtn);
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

        pinBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent =new Intent(MainActivity.this,Pin_Activity.class);
                startActivity(intent);
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        versusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        perfilBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : falta criar a conexão com os outros modulos
            }
        });

        //-------------------------------------- Navigation Implementation --------------------------------------------

        NavigationView mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        mNavigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
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


}