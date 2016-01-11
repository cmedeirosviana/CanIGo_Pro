package swape.canigo_application.Login_screen.Perfil_Screen;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import swape.canigo_application.R;


public class SolventViewHolders extends RecyclerView.ViewHolder{

    public TextView PainelId;
    public ImageView PhotoId;
    public TextView PainelHeadertext;
    public ImageView PaineHeaderphoto;



    //Método responsável por coletar as informações de texto e Imagem de um expecifico XML
    public SolventViewHolders(View itemView) {
        super(itemView);
        PainelId = (TextView) itemView.findViewById(R.id.Painel_nome);
        PhotoId = (ImageView) itemView.findViewById(R.id.Painel_image);
        PainelHeadertext = (TextView) itemView.findViewById(R.id.textView_painel_header);
        PaineHeaderphoto = (ImageView) itemView.findViewById(R.id.imageView_painel_header);


    }
}