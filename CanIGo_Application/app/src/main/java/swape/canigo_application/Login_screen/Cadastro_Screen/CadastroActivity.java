package swape.canigo_application.Login_screen.Cadastro_Screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import swape.canigo_application.Login_screen.Login_Screen.SignActivity;
import swape.canigo_application.Login_screen.Main_Screen.MainActivity;
import swape.canigo_application.R;

public class CadastroActivity extends AppCompatActivity{

    CadastroController cadastroController=new CadastroController();

    @InjectView(R.id.ContinuarButton) Button continuarButton;
    @InjectView(R.id.radioSexo) RadioGroup radioSexo;
    @InjectView(R.id.radioButton) RadioButton radioSexo1;
    @InjectView(R.id.radioButton2) RadioButton radioSexo2;
    @InjectView(R.id.radioButton3) RadioButton radioSexo3;
    @InjectView(R.id.CheckBox1) CheckBox CheckBox1;
    @InjectView(R.id.CheckBox2) CheckBox CheckBox2;
    @InjectView(R.id.CheckBox3) CheckBox CheckBox3;
    @InjectView(R.id.CheckBox4) CheckBox CheckBox4;
    @InjectView(R.id.CheckBox5) CheckBox CheckBox5;
    @InjectView(R.id.CheckBox6) CheckBox CheckBox6;
    @InjectView(R.id.CheckBox7) CheckBox CheckBox7;
    @InjectView(R.id.CheckBox8) CheckBox CheckBox8;
    @InjectView(R.id.CheckBox9) CheckBox CheckBox9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_activity);
        ButterKnife.inject(this);

        continuarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                cadastroController.CheckArray(CheckBox1.getText().toString(),CheckBox1.isChecked());
                cadastroController.CheckArray(CheckBox2.getText().toString(),CheckBox2.isChecked());
                cadastroController.CheckArray(CheckBox3.getText().toString(),CheckBox3.isChecked());
                cadastroController.CheckArray(CheckBox4.getText().toString(),CheckBox4.isChecked());
                cadastroController.CheckArray(CheckBox5.getText().toString(),CheckBox5.isChecked());
                cadastroController.CheckArray(CheckBox6.getText().toString(),CheckBox6.isChecked());
                cadastroController.CheckArray(CheckBox7.getText().toString(),CheckBox7.isChecked());
                cadastroController.CheckArray(CheckBox8.getText().toString(),CheckBox8.isChecked());
                cadastroController.CheckArray(CheckBox9.getText().toString(),CheckBox9.isChecked());


                Intent intent = new Intent(CadastroActivity.this, MainActivity.class);
                Bundle bundle=new Bundle();

                bundle.putSerializable("array", (Serializable) cadastroController.map);

                intent.putExtras(bundle);


                if ( radioSexo1.isChecked()||radioSexo2.isChecked()||radioSexo3.isChecked())
                {
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getBaseContext(), "Escolha o gênero", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}


