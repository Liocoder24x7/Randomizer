package com.myapp.lio.randomizer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Info extends AppCompatActivity {

    Button F,M,I;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        F=(Button)findViewById(R.id.fb);
        M=(Button)findViewById(R.id.mail);
        I=(Button)findViewById(R.id.insta);

        F.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://www.facebook.com/LioTheLeader";
                Intent fb=new Intent(Intent.ACTION_VIEW);
                fb.setData(Uri.parse(url));
                try {
                    startActivity(Intent.createChooser(fb,"Facebook ID"));
                }
                catch (Exception e){
                    Toast.makeText(Info.this,"Error Opening Browser",Toast.LENGTH_SHORT).show();
                }
            }
        });
        I.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="http://www.instagram.com/liotheleader";
                Intent inst=new Intent(Intent.ACTION_VIEW);
                inst.setData(Uri.parse(url));
                try {
                    startActivity(Intent.createChooser(inst,"Instagram ID"));
                }
                catch (Exception e){
                    Toast.makeText(Info.this,"Error Opening Browser",Toast.LENGTH_SHORT).show();
                }
            }
        });
        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail=new Intent(Intent.ACTION_SEND);
                mail.setType("text/html");
                mail.putExtra(Intent.EXTRA_EMAIL,"sahasayantan6@gmail.com");
                mail.putExtra(Intent.EXTRA_SUBJECT,"Discussion on Randomizer");
                mail.putExtra(Intent.EXTRA_TEXT,"Here I state my review...");
                try {
                    startActivity(Intent.createChooser(mail, "Send Email..."));
                }
                catch (Exception e){
                    Toast.makeText(Info.this,"No Mail App Found",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
