package com.example.healthcaresystem;

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

        private String[][] doctor_details1={
                {"Doctor Name : Ajit Saste","Hospital Address : Pimpri","Exp : 5yrs","Mobile NO:9898989898","600"},
                {"Doctor Name : prasad pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile NO:7898989888","900"},
                {"Doctor Name : Swapnil kale","Hospital Address : Pune","Exp : 8yrs","Mobile NO:9898989898","300"},
                {"Doctor Name : Deepak Deshumukh","Hospital Address : chinchwad","Exp : 6yrs","Mobile NO:9898000000","500"},
                {"Doctor Name : Ashok Panda","Hospital Address : Katraj","Exp : 7yrs","Mobile NO:7778989888","800"}
        };
        private String[][] doctor_details2={
                {"Doctor Name : Neelam Patil","Hospital Address : Pimpri","Exp : 5yrs","Mobile NO:9898989898","600"},
                {"Doctor Name : Swati Pawar","Hospital Address : Nigdi","Exp : 15yrs","Mobile NO:7898989888","900"},
                {"Doctor Name : Neeraj kale","Hospital Address : Pune","Exp : 8yrs","Mobile NO:9898989898","300"},
                {"Doctor Name : mayuri","Hospital Address : chinchwad","Exp : 6yrs","Mobile NO:9898000000","500"},
                {"Doctor Name : meenakshi","Hospital Address : Katraj","Exp : 7yrs","Mobile NO:7778989888","800"}
        };
        private String[][] doctor_details3={
                {"Doctor Name : Seema patil","Hospital Address : Pimpri","Exp : 5yrs","Mobile NO:9898989898","600"},
                {"Doctor Name : pnkaj parab","Hospital Address : Nigdi","Exp : 15yrs","Mobile NO:7898989888","900"},
                {"Doctor Name : manoj jain","Hospital Address : Pune","Exp : 8yrs","Mobile NO:9898989898","300"},
                {"Doctor Name : vishal Deshumukh","Hospital Address : chinchwad","Exp : 6yrs","Mobile NO:9898000000","500"},
                {"Doctor Name : manish Panda","Hospital Address : Katraj","Exp : 7yrs","Mobile NO:7778989888","800"}
        };
        private String[][] doctor_details4={
                {"Doctor Name : Amol Gowda","Hospital Address : Pimpri","Exp : 5yrs","Mobile NO:9898989898","600"},
                {"Doctor Name : Prasd patil","Hospital Address : Nigdi","Exp : 15yrs","Mobile NO:7898989888","900"},
                {"Doctor Name : Nilesh kale","Hospital Address : Pune","Exp : 8yrs","Mobile NO:9898989898","300"},
                {"Doctor Name : Deepa Deshumukh","Hospital Address : chinchwad","Exp : 6yrs","Mobile NO:9898000000","500"},
                {"Doctor Name : Anusha Desai","Hospital Address : Katraj","Exp : 7yrs","Mobile NO:7778989888","800"}
        };
        private String[][] doctor_details5={
                {"Doctor Name : Ankura Gowda","Hospital Address : Pimpri","Exp : 5yrs","Mobile NO:9898989898","600"},
                {"Doctor Name : vidya patil","Hospital Address : Nigdi","Exp : 15yrs","Mobile NO:7898989888","900"},
                {"Doctor Name : yoga kale","Hospital Address : Pune","Exp : 8yrs","Mobile NO:9898989898","300"},
                {"Doctor Name : kruthika Deshumukh","Hospital Address : chinchwad","Exp : 6yrs","Mobile NO:9898000000","500"},
                {"Doctor Name : vaishnavi Desai","Hospital Address : Katraj","Exp : 7yrs","Mobile NO:7778989888","800"}
        };


        TextView tv;
        Button btn;
        HashMap<String,String>item;
        String[][] doctor_details={};
        ArrayList list;
        SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonDDBack);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( DoctorDetailsActivity.this,FindDoctorActivity.class));

            }
        });
        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst=findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                for(int i=0;i<doctor_details.length;i++) {
                    it.putExtra("text1", title);
                    it.putExtra("text2", doctor_details[i][0]);
                    it.putExtra("text3", doctor_details[i][1]);
                    it.putExtra("text4", doctor_details[i][3]);
                    it.putExtra("text5", doctor_details[i][4]);
                    startActivity(it);
                }

            }
        });



    }
}