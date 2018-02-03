package com.myapp.lio.randomizer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Num_Changer extends AppCompatActivity {

    EditText N1,N2;
    Button B;
    TextView T;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numchanger);

        N1=(EditText)findViewById(R.id.num1);
        N2=(EditText)findViewById(R.id.num2);
        B=(Button)findViewById(R.id.button);
        T=(TextView) findViewById(R.id.result);

        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                long n1=Integer.parseInt(N1.getText().toString().trim());
                long n2=Integer.parseInt(N2.getText().toString().trim());
                if(n2<n1 || n2==n1)
                    Toast.makeText(Num_Changer.this, "Upper Limit must be greater", Toast.LENGTH_SHORT).show();
                else if(n2-n1<10)
                    Toast.makeText(Num_Changer.this, "Range should atleast be 10", Toast.LENGTH_SHORT).show();
                else {
                    long r = (long) (Math.random() * n2);
                    while (r < n1)
                        r = (long) (Math.random() * n2);
                    T.setText(r + "");
                }}catch (Exception e){
                    Toast.makeText(Num_Changer.this, "Provide The Numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
