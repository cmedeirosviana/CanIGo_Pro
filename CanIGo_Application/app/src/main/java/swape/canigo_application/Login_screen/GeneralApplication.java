package swape.canigo_application.Login_screen;

import android.app.Application;
import java.util.ArrayList;
import java.util.List;

import swape.canigo_application.Login_screen.Main_Screen.PanelModel;
import swape.canigo_application.R;

public class GeneralApplication extends Application
{

    public List<PanelModel> painelPass =new ArrayList<PanelModel>();

    public List<PanelModel>painelList =new ArrayList<PanelModel>();


    public List<PanelModel> getPainelList(String painelNome,int image)
            {
        painelList.add(new PanelModel(painelNome,image));

        return painelList;

    }

    public List<PanelModel> getPainelPass(String painelNome,int image)

    {
        painelPass.add(new PanelModel(painelNome, image));

        return painelPass;
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        painelList.add(new PanelModel("Adicionar Painel", R.drawable.people));


      //  initSingletons();
    }

    protected void initSingletons()
    {
        // Initialize the instance of MySingleton
        Singleton.initInstance();
    }

    public void customAppMethod()
    {
        painelList.add(new PanelModel("Adicionar Painel", R.drawable.people));
    }

}
