package com.example.pramo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Reg_suc extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_suc);

        btn=(Button)findViewById(R.id.btn_nxt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(in1);
            }
        });
    }
}
