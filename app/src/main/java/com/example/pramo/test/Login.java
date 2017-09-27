package com.example.pramo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText e1, e2;
    String un, psw;
    Button btn;
    String u1="gokul";
    String p1="gokul";

    String u2="anis";
    String p2="anis";

    String u3="chiex";
    String p3="chiex";

    String u4="mission";
    String p4="mission";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1=(EditText)findViewById(R.id.et_n);
        e2=(EditText)findViewById(R.id.et_pas);
        btn=(Button)findViewById(R.id.btn_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                un=e1.getText().toString();
                psw=e2.getText().toString();

                if ((un.equals(u1) && psw.equals(p1)) | (un.equals(u2) && psw.equals(p2))
                        | (un.equals(u3) && psw.equals(p3))|(un.equals(u4) && psw.equals(p4)))
                {

                    Intent in1 = new Intent(getApplicationContext(), Log_suc.class);
                    Bundle b = new Bundle();
                    b.putString("un", un);
                    in1.putExtras(b);
                    startActivity(in1);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Please check username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
