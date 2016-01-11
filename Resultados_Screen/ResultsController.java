package swape.canigo_application.Login_screen.Resultados_Screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultsController
{
    public List<ResultsModel> listStarController = new ArrayList<ResultsModel>();

    public List<ResultsModel> startList(int star,int photoid)
    {

        listStarController.add(new ResultsModel(star,photoid));

        Collections.sort(listStarController,ResultsModel.resultsComparator);

        return listStarController;

    }

}
