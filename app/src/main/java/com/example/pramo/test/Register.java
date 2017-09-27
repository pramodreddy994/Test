package com.example.pramo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Register extends AppCompatActivity {

    String name, cnum, type;

    EditText e1, e2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Spinner spinner = (Spinner)findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adptr = ArrayAdapter.createFromResource(this, R.array.countries_list, android.R.layout.simple_spinner_item);
        adptr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adptr);

        e1=(EditText)findViewById(R.id.et_n);
        e2=(EditText)findViewById(R.id.et_cn);
        btn=(Button)findViewById(R.id.btn_nxt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=e1.getText().toString();
                cnum=e2.getText().toString();
                type=spinner.getSelectedItem().toString();

                Intent in1 = new Intent(getApplicationContext(), Reg_suc.class);
                startActivity(in1);
            }
        });
    }
}
