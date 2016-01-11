package swape.canigo_application.Login_screen.Perfil_Screen;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import swape.canigo_application.Login_screen.Main_Screen.PanelModel;
import swape.canigo_application.R;

public class SolventRecyclerViewAdapter  extends RecyclerView.Adapter<SolventViewHolders> {

    private static final int ITEM_VIEW_TYPE_HEADER = 0;
    private static final int ITEM_VIEW_TYPE_ITEM = 1;

    private List<PanelModel> itemList;
    private Context context;

    //Seta a lista de imagens e o texto da class.
    public SolventRecyclerViewAdapter(Context context, List<PanelModel> itemList)
    {
        this.itemList = itemList;
        this.context = context;
    }

    public boolean isHeader(int position)
    {
        return position == 0;
    }

    @Override
    // Método responsável por inflar a view com as informações da lista de imagens e nomes além
    //de retornar essa view genérica.
    public SolventViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        //Infla a view a partir da XML com o ImageView e TextView.
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_perfil_lauyout, null);
        //Passa o resultado do Layout inflado para o SoventViewHolders coletar as informações exclusivas
        //das imagens e texto além de permitir o click da view.
        SolventViewHolders rcv = new SolventViewHolders(layoutView);
        return rcv;
    }

    @Override
    // Método responsável por colocar na tela as informações individiais de cada item da lista.
    public void onBindViewHolder(SolventViewHolders holder, int position) {

        if (isHeader(position))
        {
            holder.PaineHeaderphoto.setImageResource(R.drawable.people);
            holder.PainelHeadertext.setText("Caio de Medeiros Viana");


        }else
        {
            holder.PhotoId.setImageResource(itemList.get(position).getMphotoId());
            holder.PainelId.setText(itemList.get(position).getMpanel());
        }
    }

    //Método get utilizado para informar o tamanho da lista de imagens e nomes.
    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        return isHeader(position) ? ITEM_VIEW_TYPE_HEADER : ITEM_VIEW_TYPE_ITEM;
    }
}
