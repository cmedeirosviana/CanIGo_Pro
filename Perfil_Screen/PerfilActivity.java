package swape.canigo_application.Login_screen.Perfil_Screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import swape.canigo_application.Login_screen.GeneralApplication;
import swape.canigo_application.Login_screen.Perfil_Individual_Screen.PerfilIndividualActivity;
import swape.canigo_application.Login_screen.Perfil_Screen.Header.MarginDecoration;
import swape.canigo_application.R;


public class PerfilActivity extends AppCompatActivity {
    GeneralApplication painelData = (GeneralApplication)getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.perfil_activity);

        GeneralApplication painelData = (GeneralApplication)getApplication();

        //Carrega as informações da biblioteca RecyclerView a partir do XML inserido.
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        recyclerView.addItemDecoration(new MarginDecoration(this));

       //Reposavel por determinar alterações no layout especificado acima quando o adapter
       //realiza alguma alteração no layout
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager manager = new GridLayoutManager(this, 3);

        recyclerView.setLayoutManager(manager);


        View header = LayoutInflater.from(this).inflate(R.layout.card_perfil_lauyout, recyclerView, false);

        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste", R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste", R.drawable.picture1);
        painelData.getPainelPass("teste",R.drawable.picture1);
        painelData.getPainelPass("teste", R.drawable.picture1);


        final SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(PerfilActivity.this,painelData.painelPass);
        recyclerView.setAdapter(rcAdapter);

        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return rcAdapter.isHeader(position) ? manager.getSpanCount() : 1;
            }
        });

        recyclerView.addOnItemTouchListener
                (
                        new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(PerfilActivity.this, PerfilIndividualActivity.class);
                                intent.putExtra("photo_position", position);
                                startActivity(intent);
                            }
                        }
                        )
                );

    }

}