package com.example.progweb.mybrowser;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Timer;
import java.util.TimerTask;

public class Start extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 6000;
    Timer t = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ActionBar actionBar = getSupportActionBar();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        t.cancel();
                        Display display = getWindowManager().getDefaultDisplay();
                        int width = display.getWidth();
                        if (width > 799) {
                            Intent intent = new Intent(Start.this,Slaider_menu.class);
                            intent.putExtra("journal_number", "79");
                            //ListDownload
                            //Solad
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(Start.this,Slaider_menu.class);
                            intent.putExtra("journal_number", "79");
                            startActivity(intent);
                        }
                        finish();
                    }
                });
            }
        }, SPLASH_TIME_OUT, SPLASH_TIME_OUT);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}