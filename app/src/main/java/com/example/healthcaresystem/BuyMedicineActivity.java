package com.example.healthcaresystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String[][] packages={
        {
            "uprise-03 1000IU capsule",""," "," ","50"
        },
        {
            "HealthVit Chromium Picolinate 200mg Capsule"," "," "," ","305"
        },
        {
            "Vitamin B complex capsules"," "," "," ","448"
        },
        {
            "Inlife Vitamin E Wheat Germ Oil capsulles"," "," "," ","539"
        },
        {
            "DOLO 650 Tablet"," "," "," ","30"
        },
        {
            "Crocin 650 Advance TABLET"," "," "," ","50"
        },
        {"Strepsils"," "," "," ","40"},
            {"Tata 1mg Calcium"," "," "," ","30"},
            {"Feronia-Xt Tblet"," "," "," ","130"}

    };

      HashMap<String ,String> item;
      ArrayList list;
      SimpleAdapter sa;
      ListView lst;
   Button btnBack,btnGoToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);
btnGoToCart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));
    }
});
btnBack.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
    }
});
list=new ArrayList();
for(int i=0;i<packages.length;i++){
    item=new HashMap<String ,String>();
    item.put("line1",packages[i][0]);
    item.put("line2",packages[i][1]);
    item.put("line3",packages[i][2]);
    item.put("line4",packages[i][3]);
    item.put("line5","TOTAl COSt:" +packages[i][4]+"/-");
    list.add(item);
}
sa=new SimpleAdapter(this, list,
        R.layout.multi_lines,
        new String[]{
        "line1","line2","line3","line4","line5"},
        new int[]{
                R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e
});
lst.setAdapter(sa);

lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
      {
            it.putExtra("text1", packages[i][0]);

            it.putExtra("text3", packages[i][4]);
            startActivity(it);
        }

    }
});
    }
}