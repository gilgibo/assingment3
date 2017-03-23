package com.example.gibo.assignment3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tabHost = (TabHost)findViewById(R.id.tabhost1);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("A").setIndicator("BMI 계산기").setContent(new TabHost.TabContentFactory(){
            @Override
            public View createTabContent(String tag) {
                return getTabView();
            }
        }));
    }


    View getTabView(){
        View view =
                View.inflate(Main2Activity.this,R.layout.bmicalculator, null);

        Button bt1 = (Button)view.findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et1 = (EditText)v.findViewById(R.id.et1);
                EditText et2 = (EditText)v.findViewById(R.id.et2);
                TextView tv1 = (TextView)v.findViewById(R.id.tv1);

                String hegiht = et1.getText().toString();
                String weight = et2.getText().toString();
                int bmi = Integer.parseInt(hegiht)/(Integer.parseInt(weight)^2);

                if(bmi < 18.5){
                    tv1.setText("체중부족");
                }else if(18.5 <= bmi && bmi <= 22.9){
                    tv1.setText("정상");
                }else if(23 <= bmi && bmi <= 24.9){
                    tv1.setText("과체중");
                }else if(bmi > 25){
                    tv1.setText("비만");
                }
            }
        });
        return view;
    }
}
