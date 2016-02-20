package swape.canigo_application.Login_screen.Perfil_Individual_Screen;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import swape.canigo_application.Login_screen.GeneralApplication;
import swape.canigo_application.R;


public class PerfilIndividualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_individual_activity);

        GeneralApplication painelData = (GeneralApplication)getApplication();


        Bundle extras = getIntent().getExtras();
        int value = extras.getInt("photo_position");

        ImageView New_image= (ImageView)findViewById(R.id.imageView_individual);
        New_image.setImageResource(painelData.painelPass.get(value).getMphotoId());
    }
}
