package com.example.healthcaresystem;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username,password,email,conform;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username=findViewById(R.id.editTextAppFullName);
        password=findViewById(R.id.edittextAppContact);
        email = findViewById(R.id.regemail);
        conform=findViewById(R.id.editTextAppFees);
        Database db =new Database(getApplicationContext(),"healthcare",null,1);
        btn=findViewById(R.id.buttonBookAppointment);
        tv=findViewById(R.id.regtextview);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, loginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Username = username.getText().toString();
                String Password = password.getText().toString();
                String Email = email.getText().toString();
                String Conform = conform.getText().toString();
                if(username.length()==0 || password.length()==0 || email.length()==0 || conform.length()==0)
                {
                    Toast.makeText(getApplicationContext(),"please fill all details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                if(Password.compareTo(Conform)==0){
                       if(isValid(Password))
                       {
                           db.register(Username,Email,Password);
                           Toast.makeText(getApplicationContext(),"record inserted",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this, loginActivity.class));
                       }
                       else {
                           Toast.makeText(getApplicationContext(),"password must contain 8 characters",Toast.LENGTH_SHORT).show();
                       }

                   }
                   else
                   {
                       Toast.makeText(getApplicationContext(),"password and conform password not correct",Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }
    public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length() < 8){
            return false;
        }
        else
        {
            for(int p=0;p < passwordhere.length();p++)
            {
                if (Character.isLetter(passwordhere.charAt(p)))
                {
                    f1=1;
                }
            }
            for(int r=0;r < passwordhere.length();r++)
            {
                if(Character.isDigit(passwordhere.charAt(r)))
                {
                    f2=1;
                }
            }
            for (int s=0; s< passwordhere.length();s++)
            {
                char c = passwordhere.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1 && f2==1 && f3==1)
                return true;
            return false;
        }
    }
}