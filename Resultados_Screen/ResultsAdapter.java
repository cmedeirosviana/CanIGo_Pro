package swape.canigo_application.Login_screen.Resultados_Screen;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.util.List;

import swape.canigo_application.R;


public class ResultsAdapter extends ArrayAdapter<ResultsModel>
{
    ViewHolder viewHolder;

    private static class ViewHolder
    {
        RatingBar ratingBar;
        ImageView imageView;

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        ViewHolder(View rootView)
        {
            ratingBar = (RatingBar) rootView.findViewById(R.id.ratingBar);
            imageView = (ImageView) rootView.findViewById(R.id.results_imageview);

        }
    }

    public ResultsAdapter(Context context, int Layout_id, List<ResultsModel> items)
    {
        super(context,Layout_id,items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        ResultsModel item = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.list_results, parent, false);

            viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);

        } else

        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if (item!= null)
        {
            viewHolder.ratingBar.setRating(item.getMstars());
            viewHolder.imageView.setImageResource(item.getMphotoId());
        }

        return convertView;
    }


}