package com.example.firedatabaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private EditText fullnameET,usernameET,emailET,phoneET,passwordET;
    private Button uploadBT;
    private FirebaseDatabase rootnode;
    private DatabaseReference Ref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fullnameET=(EditText)findViewById(R.id.fullnameET);
        usernameET=(EditText)findViewById(R.id.usernameET);
        emailET=(EditText)findViewById(R.id.emailET);
        phoneET=(EditText)findViewById(R.id.phoneET);
        passwordET=(EditText)findViewById(R.id.password);

        uploadBT =(Button)findViewById(R.id.updateBT);

        uploadBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootnode=FirebaseDatabase.getInstance();
                Ref = rootnode.getReference("users");

                String fullname=fullnameET.getText().toString().trim();
                String username=usernameET.getText().toString().trim();
                String email=emailET.getText().toString().trim();
                String phone=phoneET.getText().toString().trim();
                String password=passwordET.getText().toString().trim();


                UserHelperClass userHelperClass= new UserHelperClass(fullname,username,email,phone,password);


                Ref.child(phone).setValue(userHelperClass);
            }
        });





    }
}