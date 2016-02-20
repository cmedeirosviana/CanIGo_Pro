package paprica_company.canigo_pro.View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

import paprica_company.canigo_pro.R;

public class Pin_Activity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list_pin);

        List<String> list_test = new ArrayList<String>();

        list_test.add("B");
        list_test.add("C");

        ListView pinList = (ListView)findViewById(R.id.pinList);

        Pin_Adapter pin_adapter = new Pin_Adapter(Pin_Activity.this, R.id.panelImg,list_test);

        pinList.setAdapter(pin_adapter);


        pinList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

            }
        });

    }


}
