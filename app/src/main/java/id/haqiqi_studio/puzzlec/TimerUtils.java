package id.haqiqi_studio.puzzlec;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TimerUtils extends AppCompatActivity {
    private int i, val = 60;

    public void setTimer(int delay, final TextView txt) {
        i = delay;
        final Thread thread = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    try {
                        Thread.sleep(990);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                i--;
                                if (i >= 0) {
                                    txt.setText(String.valueOf(i));
                                }
                                isOver(i);
                            }
                        });
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }

    public boolean isOver(int minTick) {
        if (minTick == 0) {
            return true;
        }
        else {
            return false;
        }
    }
}
