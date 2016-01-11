package swape.canigo_application.Login_screen.Resultados_Screen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import swape.canigo_application.Login_screen.GeneralApplication;
import swape.canigo_application.Login_screen.Main_Screen.PainelAdapter;
import swape.canigo_application.R;

public class ResultsActvity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_actvity);

        ResultsController resultsController= new ResultsController();

        resultsController.startList(4,R.drawable.people);
        resultsController.startList(5,R.drawable.people);
        resultsController.startList(4,R.drawable.people);
        resultsController.startList(2, R.drawable.people);
        resultsController.startList(3, R.drawable.people);
        resultsController.startList(4,R.drawable.people);
        resultsController.startList(5,R.drawable.people);
        resultsController.startList(4,R.drawable.people);
        resultsController.startList(2, R.drawable.people);
        resultsController.startList(3, R.drawable.people);

        final ListView listView = (ListView)findViewById(R.id.list_painel_results);

        ResultsAdapter adapter = new ResultsAdapter(ResultsActvity.this, R.id.results_imageview,resultsController.listStarController);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                GeneralApplication painelData = (GeneralApplication) getApplication();

                int itemPosition = position;

                Toast.makeText(ResultsActvity.this, "Item: " + position, Toast.LENGTH_SHORT).show();

            }
        });

    }

    void showToastMessage(String message) {
        Toast.makeText(ResultsActvity.this, message, Toast.LENGTH_SHORT)
                .show();
    }

}
