package swape.canigo_application.Login_screen.Main_Screen;

import java.io.Serializable;

public class PanelModel implements Serializable
{

    public String getMpanel() {
        return mpanel;
    }

    public int getMphotoId() {
        return mphotoId;
    }

    private String mpanel;
    private int mphotoId;

    public PanelModel(String panel, int photoId)
    {
       mpanel=panel;
        mphotoId=photoId;

    }
}

