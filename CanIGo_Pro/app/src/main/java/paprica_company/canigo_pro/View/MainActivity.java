package paprica_company.canigo_pro.View;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import paprica_company.canigo_pro.R;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener,MenuItem.OnMenuItemClickListener,NavigationView.OnNavigationItemSelectedListener
{
    private Toolbar toolbar;
    private NavigationView mDrawer;
    private DrawerLayout mDrawerLayout;
    private  ActionBarDrawerToggle drawerToggle;
    private int mSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //-------------------------------------- Toolbar creation --------------------------------------------
        setToolbar();
        initView();

        drawerToggle=new ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.fotos,R.string.Resultados);
        mDrawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //-------------------------------------- Layout creation --------------------------------------------

        ImageView mainImg = (ImageView)findViewById(R.id.mainImg);
        ImageView likeBtn= (ImageView)findViewById(R.id.likeBtn);
        ImageView dislikeBtn = (ImageView) findViewById(R.id.dislikeBtn);

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

    }
    //-------------------------------------- Navigation Implementation --------------------------------------------

    private void initView()
    {
        mDrawer = (NavigationView) findViewById(R.id.nav_view);
        mDrawer.setNavigationItemSelectedListener(this);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }
    //-------------------------------------- Toolbar creation--------------------------------------------

    private void setToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
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

    private void itemSelection(int mSelectedId) {

        switch(mSelectedId){

            //TODO:Criar metodo dos menus

            case R.id.nav_fotos:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_pins:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_results:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_interests:

                Intent intent =new Intent(MainActivity.this,Interests_Activity.class);
                startActivity(intent);
                mDrawerLayout.closeDrawer(GravityCompat.START);

                break;
        }

    }

    @Override

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        mSelectedId =menuItem.getItemId();
        itemSelection(mSelectedId);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_buttons, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_versus:
                return true;

            case R.id.action_pin:

                Intent intent =new Intent(MainActivity.this,Pin_Activity.class);
                startActivity(intent);
                return true;

            case R.id.action_photo:
                return true;

            default:
                return false;

        }
    }

}