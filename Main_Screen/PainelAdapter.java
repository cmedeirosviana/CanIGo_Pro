package swape.canigo_application.Login_screen.Main_Screen;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import swape.canigo_application.R;

public class PainelAdapter extends ArrayAdapter<PanelModel>
{

    ViewHolder viewHolder;

    public PainelAdapter(Context context, int Layout_id, List<PanelModel> items)
    {
        super(context,Layout_id,items);
    }

    private static class ViewHolder
    {
        TextView textView;
        ImageView imageView;

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        ViewHolder(View rootView)
        {
            textView = (TextView) rootView.findViewById(R.id.painel_default);
            imageView = (ImageView) rootView.findViewById(R.id.imageView_painel);
            scaleImage(imageView,300);
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

    private static void scaleImage(ImageView view, int boundBoxInDp)
    {
        Drawable drawing = view.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawing).getBitmap();

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        // Determine how much to scale: the dimension requiring less scaling is
        // closer to the its side. This way the image always stays inside your
        // bounding box AND either x/y axis touches it.
        float xScale = ((float) boundBoxInDp) / width;
        float yScale = ((float) boundBoxInDp) / height;
        float scale = (xScale <= yScale) ? xScale : yScale;

        // Create a matrix for the scaling and add the scaling data
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);

        // Create a new bitmap and convert it to a format understood by the ImageView
        Bitmap scaledBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        BitmapDrawable result = new BitmapDrawable(scaledBitmap);
        width = scaledBitmap.getWidth();
        height = scaledBitmap.getHeight();

        // Apply the scaled bitmap
        view.setImageDrawable(result);

        // Now change ImageView's dimensions to match the scaled image
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) view.getLayoutParams();
        params.width = width;
        params.height = height;
        view.setLayoutParams(params);
    }

    private int dpToPx(int dp)
    {
        float density = getContext().getResources().getDisplayMetrics().density;
        return Math.round((float)dp * density);
    }

}