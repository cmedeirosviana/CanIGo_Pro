package swape.canigo_application.Login_screen.Main_Screen;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import swape.canigo_application.R;

public class AnimationClass {

    Context content;
    Timer timer = new Timer();
    ViewHolder viewHolder=new ViewHolder();
    TimerTask timerTask;

    public AnimationClass(Context context)
    {
        content=context;
    }

    private static class ViewHolder
    {
        ImageView imageView_tomato;

        ViewHolder(View rootView)
        {
            imageView_tomato = (ImageView) rootView.findViewById(R.id.image_animation);
        }
    }

    public void Animation()
    {
        viewHolder.imageView_tomato.setBackgroundResource(R.drawable.animation_layout);
        AnimationDrawable frameAnimation = (AnimationDrawable) viewHolder.imageView_tomato.getBackground();

        frameAnimation.start();

        int duration = 0;
        for(int i = 0; i < frameAnimation.getNumberOfFrames(); i++)
        {
            duration += frameAnimation.getDuration(i);
        }

        timer.schedule(timerTask, duration);
    }


}
