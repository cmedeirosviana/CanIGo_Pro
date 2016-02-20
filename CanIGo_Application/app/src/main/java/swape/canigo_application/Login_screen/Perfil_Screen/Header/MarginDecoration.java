package swape.canigo_application.Login_screen.Perfil_Screen.Header;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import swape.canigo_application.R;

public class MarginDecoration extends RecyclerView.ItemDecoration
{
    private int margin;

    public MarginDecoration(Context context)
    {
        margin = context.getResources().getDimensionPixelSize(R.dimen.item_margin);
    }

    @Override
    public void getItemOffsets(
            Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        outRect.set(margin, margin, margin, margin);
    }
}