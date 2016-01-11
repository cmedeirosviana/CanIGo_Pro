package swape.canigo_application.Login_screen.Main_Screen;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import swape.canigo_application.Login_screen.Cadastro_Screen.CadastroActivity;
import swape.canigo_application.Login_screen.GeneralApplication;
import swape.canigo_application.Login_screen.Perfil_Screen.PerfilActivity;
import swape.canigo_application.R;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    final static int PICK_PAINEL=0;
    AnimationClass animationClass=new AnimationClass(this);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        Bundle bundle=getIntent().getExtras();

            if (bundle != null)

            {
                Map<String, Boolean> array_checkbox = (Map<String, Boolean>) bundle.getSerializable("array");
                //TODO: Ultilizar o parametro para filtrar os estilos dos paneis
            }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        scaleImage(imageView, 700);

        Swape_view swape_view=new Swape_view();
        imageView.setOnTouchListener(swape_view);


        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(R.layout.spinner_layout);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);

        ImageButton perfil_button = (ImageButton)findViewById(R.id.Perfil_image);
        ImageButton preference_button= (ImageButton)findViewById(R.id.Preference_image);
        ImageButton pin_button = (ImageButton) findViewById(R.id.imageButtonPin);
        ImageButton like_button = (ImageButton) findViewById(R.id.imageButton_like);
        ImageButton deslike_button = (ImageButton) findViewById(R.id.imageButton_dislike);


        deslike_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animationClass.Animation();

            }
        });

        like_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, PainelActivity.class);
                startActivityForResult(intent, PICK_PAINEL);
            }
        });

        preference_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });

        perfil_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                startActivity(intent);
            }
        });

    }

  public void showPopup_spam(View v)
  {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        popup.setOnMenuItemClickListener(this);
        inflater.inflate(R.menu.spam_activity, popup.getMenu());
      popup.show();
  }

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
    private static void scaleImage(ImageView view, int boundBoxInDp)
    {
        Drawable drawing = view.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawing).getBitmap();

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

         float xScale = ((float) boundBoxInDp) / width;
        float yScale = ((float) boundBoxInDp) / height;
        float scale = (xScale <= yScale) ? xScale : yScale;

        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        BitmapDrawable result = new BitmapDrawable(scaledBitmap);
        width = scaledBitmap.getWidth();
        height = scaledBitmap.getHeight();

        view.setImageDrawable(result);

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

}

