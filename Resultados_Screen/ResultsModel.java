package swape.canigo_application.Login_screen.Resultados_Screen;

import java.util.Comparator;

public class ResultsModel {

    public int getMstars() {
        return mstars;
    }

    public int getMphotoId() {
        return mphotoId;
    }

    private int mstars;
    private int mphotoId;

    public ResultsModel(int stars, int photoId) {
        mstars = stars;
        mphotoId = photoId;

    }


    public static Comparator<ResultsModel> resultsComparator
            = new Comparator<ResultsModel>() {

        public int compare(ResultsModel star1, ResultsModel star2) {

          int starOrder1 = star1.getMstars();
            int starOrder2 = star2.getMstars();

            return  starOrder2-starOrder1;
        }

    };
}
