package com.myapp.lio.randomizer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Loader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);

        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    super.run();
                    sleep(1500);
                } catch (Exception e) {

                } finally {

                    Intent i = new Intent(Loader.this,
                            Begin.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        splash.start();

    }
}
