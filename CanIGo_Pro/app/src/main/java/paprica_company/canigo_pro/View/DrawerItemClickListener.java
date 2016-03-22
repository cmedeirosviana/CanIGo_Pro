package paprica_company.canigo_pro.View;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

 class DrawerItemClickListener implements ListView.OnItemClickListener
{
    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id)
    {
        selectItem(position);
    }

    /** Swaps fragments in the main content view */
    private void selectItem(int position)
    {
        // Create a new fragment and specify the planet to show based on position

    }
}



