package com.myapp.lio.randomizer;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Begin extends AppCompatActivity {

    Button N,C,I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);

        N=(Button)findViewById(R.id.num);
        C=(Button)findViewById(R.id.col);
        I=(Button)findViewById(R.id.info);

        N.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent num=new Intent(Begin.this,Num_Changer.class);
                startActivity(num);
            }
        });

        C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent col=new Intent(Begin.this,Col_Changer.class);
                startActivity(col);
            }
        });

        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inf=new Intent(Begin.this,Info.class);
                startActivity(inf);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder back=new AlertDialog.Builder(this);
        back.setIcon(R.drawable.logo);
        back.setTitle("Are You Sure To Exit?");
        back.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        back.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        back.show();
    }
}
