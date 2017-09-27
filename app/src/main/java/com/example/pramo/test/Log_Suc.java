package com.example.pramo.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

public class Log_Suc extends AppCompatActivity {
    Button btn;
    TextView tv1, tv2, tv3, t1, t2, t3;
    String cname, cnum, rname;
    String date_time;
    String order_details;
    String username, res;

    DatabaseReference database;

    String gok="Gokul Indian Restaurant";
    String anis="Anis Hyderabad House";
    String chex="Chinese Express";
    String mex="Mission Taco Joint";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_suc);

        Bundle b = getIntent().getExtras();

        if(b!=null)
        {
            username= b.getString("un");

        }

        if (username.equals("gokul"))
        {
            res=gok;
        }
        else if (username.equals("anis"))
        {
            res=anis;
        }
        else if (username.equals("chiex"))
        {
            res=chex;
        }
        else if (username.equals("mission"))
        {
            res=mex;
        }

        //Toast.makeText(getApplicationContext(), username,Toast.LENGTH_SHORT).show();
        tv1=(TextView)findViewById(R.id.tv_cnc);
        tv2=(TextView)findViewById(R.id.tv_dt);
        tv3=(TextView)findViewById(R.id.tv_od);

        t1=(TextView)findViewById(R.id.tv_1);
        t2=(TextView)findViewById(R.id.tv_2);
        t3=(TextView)findViewById(R.id.tv_3);

        //------------------

        database = FirebaseDatabase.getInstance().getReference();

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()){
                    Details db= postSnapshot.getValue(Details.class);
                    cname=db.getCname();
                    rname=db.getRname();
                    date_time=db.getTime_date();
                    order_details=db.getOrder();
                    cnum=db.getCnum();

                    //Toast.makeText(getApplicationContext(), cname+date_time, Toast.LENGTH_SHORT).show();
                    if (res.equals(rname))
                    {
                        tv1.setText(cname+"\n"+cnum);
                        tv2.setText(date_time);
                        tv3.setText(order_details);
                    }
                    else {
                        tv1.setText("You have no orders.!");
                        tv2.setVisibility(View.GONE);
                        tv3.setVisibility(View.GONE);
                        t1.setVisibility(View.GONE);
                        t2.setVisibility(View.GONE);
                        t3.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(), "Database error..", Toast.LENGTH_SHORT).show();

            }
        });

        //-------------------

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
