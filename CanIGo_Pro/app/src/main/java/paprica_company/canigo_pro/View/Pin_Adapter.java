package paprica_company.canigo_pro.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import paprica_company.canigo_pro.R;

public class Pin_Adapter extends ArrayAdapter<String>
{

    ViewHolder viewHolder;

    public Pin_Adapter(Context context, int Layout_id, List<String> items)
    {
        super(context,Layout_id,items);
    }

    private static class ViewHolder
    {
        TextView panelTxt;
        ImageView panelImg;

        ViewHolder(View rootView)
        {
            panelTxt = (TextView) rootView.findViewById(R.id.panelTxt);
            panelImg = (ImageView) rootView.findViewById(R.id.panelImg);
        }
    }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {

            if (convertView == null)
            {
                convertView = LayoutInflater.from(this.getContext()).inflate(R.layout.activity_pin, parent, false);

                viewHolder = new ViewHolder(convertView);

                convertView.setTag(viewHolder);

            } else

            {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            return convertView;
        }

}


