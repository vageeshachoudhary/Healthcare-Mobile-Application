package com.example.healthcareapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    private String[][] physicians =
            {
                    {"Doctor Name : Stephen","Hospital : xyz","Exp : 4 yrs","Contact No. : 2874838293","Fees : 100$"},
                    {"Doctor Name : Jeffrey","Hospital : abc","Exp : 3 yrs","Contact No. : 2848599499","Fees : 100$"},
                    {"Doctor Name : Charles","Hospital : wej","Exp : 1 yrs","Contact No. : 7789337388","Fees : 100$"},
                    {"Doctor Name : Daniel","Hospital : wek","Exp : 8 yrs","Contact No. : 9383839494","Fees : 100$"},
                    {"Doctor Name : Elizabeth","Hospital : cfh","Exp : 7 yrs","Contact No. : 7273848992","Fees : 100$"}
            };
    private String[][] dentists =
            {
                    {"Doctor Name : Stephen","Hospital : xyz","Exp : 4 yrs","Contact No. : 2874838293","Fees : 100$"},
                    {"Doctor Name : Jeffrey","Hospital : abc","Exp : 3 yrs","Contact No. : 2848599499","Fees : 100$"},
                    {"Doctor Name : Charles","Hospital : wej","Exp : 1 yrs","Contact No. : 7789337388","Fees : 100$"},
                    {"Doctor Name : Daniel","Hospital : wek","Exp : 8 yrs","Contact No. : 9383839494","Fees : 100$"},
                    {"Doctor Name : Elizabeth","Hospital : cfh","Exp : 7 yrs","Contact No. : 7273848992","Fees : 100$"}
            };
    private String[][] surgeons =
            {
                    {"Doctor Name : Stephen","Hospital : xyz","Exp : 4 yrs","Contact No. : 2874838293","Fees : 100$"},
                    {"Doctor Name : Jeffrey","Hospital : abc","Exp : 3 yrs","Contact No. : 2848599499","Fees : 100$"},
                    {"Doctor Name : Charles","Hospital : wej","Exp : 1 yrs","Contact No. : 7789337388","Fees : 100$"},
                    {"Doctor Name : Daniel","Hospital : wek","Exp : 8 yrs","Contact No. : 9383839494","Fees : 100$"},
                    {"Doctor Name : Elizabeth","Hospital : cfh","Exp : 7 yrs","Contact No. : 7273848992","Fees : 100$"}
            };
    private String[][] ent =
            {
                    {"Doctor Name : Stephen","Hospital : xyz","Exp : 4 yrs","Contact No. : 2874838293","Fees : 100$"},
                    {"Doctor Name : Jeffrey","Hospital : abc","Exp : 3 yrs","Contact No. : 2848599499","Fees : 100$"},
                    {"Doctor Name : Charles","Hospital : wej","Exp : 1 yrs","Contact No. : 7789337388","Fees : 100$"},
                    {"Doctor Name : Daniel","Hospital : wek","Exp : 8 yrs","Contact No. : 9383839494","Fees : 100$"},
                    {"Doctor Name : Elizabeth","Hospital : cfh","Exp : 7 yrs","Contact No. : 7273848992","Fees : 100$"}
            };
    TextView h;
    Button btnBacktoHome;
    String[][] doc_detail = {};
    ArrayList list;
    HashMap<String,String> map;
    SimpleAdapter s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        h = findViewById(R.id.txtWelcomeHeading);
        btnBacktoHome = findViewById(R.id.buttonBack);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        h.setText(title);

        if(title.compareTo("Physicians")==0)
            doc_detail = physicians;
        else
        if(title.compareTo("Dentists")==0)
            doc_detail = dentists;
        else
        if(title.compareTo("ENT")==0)
            doc_detail = ent;
        else
        if(title.compareTo("Surgeons")==0)
            doc_detail = surgeons;

        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doc_detail.length;i++)
        {
            map = new HashMap<String,String>();
            map.put("line1",doc_detail[i][0]);
            map.put("line2",doc_detail[i][1]);
            map.put("line3",doc_detail[i][2]);
            map.put("line4",doc_detail[i][3]);
            map.put("line5",doc_detail[i][4]+"/-");
            list.add(map);
        }
        s = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView l = findViewById(R.id.listViewDetails);
        l.setAdapter(s);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                intent1.putExtra("txt1",title);
                intent1.putExtra("txt2",doc_detail[position][0]);
                intent1.putExtra("txt3",doc_detail[position][1]);
                intent1.putExtra("txt4",doc_detail[position][3]);
                intent1.putExtra("txt5",doc_detail[position][4]);
                startActivity(intent1);

            }
        });

    }
}