package paprica_company.canigo_pro.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import paprica_company.canigo_pro.R;

public class Pin_Adapter extends ArrayAdapter<PanelModel>
{

    ViewHolder viewHolder;

    public Pin_Adapter(Context context, int Layout_id, List<PanelModel> items)
    {
        super(context,Layout_id,items);
    }

    private static class ViewHolder
    {
        TextView textView;
        ImageView imageView;

        ViewHolder(View rootView)
        {
            textView = (TextView) rootView.findViewById(R.id.painel_default);
            imageView = (ImageView) rootView.findViewById(R.id.imageView_painel);
        }
    }
        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            PanelModel item = getItem(position);

            if (convertView == null)
            {
                convertView = LayoutInflater.from(this.getContext())
                        .inflate(R.layout.painel_text_layout, parent, false);

                viewHolder = new ViewHolder(convertView);

                convertView.setTag(viewHolder);

            } else

            {
                viewHolder = (ViewHolder) convertView.getTag();
            }


            if (item!= null)
            {
                viewHolder.textView.setText(item.getMpanel());
                viewHolder.imageView.setImageResource(item.getMphotoId());
            }

            return convertView;
        }

}


