package swape.canigo_application.Login_screen.Main_Screen;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Swape_view implements View.OnTouchListener
{
    private int min_distance = 100;
    private float downX, downY, upX, upY;
    View v;

    @Override
    public boolean onTouch(View v, MotionEvent event)
    {
        this.v = v;
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                downX = event.getX();
                downY = event.getY();
                return true;
            }
            case MotionEvent.ACTION_UP:
            {
                upX = event.getX();
                upY = event.getY();

                float deltaX = downX - upX;
                float deltaY = downY - upY;

                if (Math.abs(deltaX) > Math.abs(deltaY))
                {
                    if (Math.abs(deltaX) > min_distance)
                    {

                        if (deltaX < 0) {
                            this.onLeftToRightSwipe();
                            return true;
                        }
                        if (deltaX > 0) {
                            this.onRightToLeftSwipe();
                            return true;
                        }
                    } else {

                        return false;
                    }
                }

                else {
                    if (Math.abs(deltaY) > min_distance) {
                        // top or down
                        if (deltaY < 0) {
                            this.onTopToBottomSwipe();
                            return true;
                        }
                        if (deltaY > 0) {
                            this.onBottomToTopSwipe();
                            return true;
                        }
                    } else {

                        return false;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public void onLeftToRightSwipe(){
        Toast.makeText(v.getContext(),"left to right",
                Toast.LENGTH_SHORT).show();
    }

    public void onRightToLeftSwipe() {
        Toast.makeText(v.getContext(),"right to left",
                Toast.LENGTH_SHORT).show();
    }

    public void onTopToBottomSwipe() {
        Toast.makeText(v.getContext(),"top to bottom",
                Toast.LENGTH_SHORT).show();
    }

    public void onBottomToTopSwipe() {
        Toast.makeText(v.getContext(),"bottom to top",
                Toast.LENGTH_SHORT).show();
    }
}