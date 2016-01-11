package swape.canigo_application.Login_screen.Main_Screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

import static com.google.android.gms.internal.zzip.runOnUiThread;


public class TimeTask extends TimerTask {
    Timer timer;
    Context content;

public TimeTask(Context context)
    {
        content=context;

    }

    @Override
    public void run() {

        timer.cancel();
        runOnUiThread(new Runnable(){
            @Override
            public void run() {
                Toast.makeText(content.getApplicationContext(),
                        "Animation Stopped",
                        Toast.LENGTH_SHORT).show();
            }});
    }
}
