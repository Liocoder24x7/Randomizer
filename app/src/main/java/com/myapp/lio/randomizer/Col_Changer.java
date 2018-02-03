package com.myapp.lio.randomizer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Col_Changer extends AppCompatActivity {

    char col[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    RelativeLayout RL;
    EditText E;
    Button B;
    TextView T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colchanger);

        RL = (RelativeLayout) findViewById(R.id.Rel);
        E = (EditText) findViewById(R.id.editText);
        B = (Button) findViewById(R.id.button);
        T=(TextView)findViewById(R.id.description);

        changer(RL,E);

        RL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changer(RL,E);
            }
        });

        T.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changer(RL,E);
            }
        });

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = E.getText().toString().trim();
                int count = 0;
                char c;
                if (name.length() == 6) {
                    for (int i = 0; i < 6; i++) {
                        c = name.charAt(i);
                        if ((c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F') || (c >= '0' && c <= '9'))
                            count++;
                    }
                }
                if (count == 6 && name.length() == 6) {
                    name="#"+name;
                    RL.setBackgroundColor(Color.parseColor(name));
                }
                else{
                    Toast.makeText(Col_Changer.this, "Wrong code input", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void changer(RelativeLayout Layout,EditText Text){

        String name = "#";
        for (int i = 0; i < 6; i++) {
            name += col[(int) (Math.random() * 100 % 16)];
        }
        Layout.setBackgroundColor(Color.parseColor(name));
        Text.setText(name.substring(1));

    }
}
