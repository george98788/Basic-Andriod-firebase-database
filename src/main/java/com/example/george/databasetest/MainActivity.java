package com.example.george.databasetest;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText userName;
    EditText userPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSignUp = (Button)findViewById(R.id.button_add);
        userName = (EditText) findViewById(R.id.editTextUser);
        userPass = (EditText) findViewById(R.id.editTextPassword);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Takes the strings and stores them into string Var
                String name1 = userName.getText().toString();
                String namePass2 = userPass.getText().toString();
                //creates instance of user


                FirebaseDatabase database = FirebaseDatabase.getInstance();
                //creates node user
                DatabaseReference myRef = database.getReference("User");

               String id = myRef.push().getKey();
                User thisUser = new User(id,name1,namePass2);
                //stores user instance into database

                myRef.child(id).setValue(thisUser);



                //the 'myref' holds the reference eg message, which points to correct child in the database
                DatabaseReference myRef2 = database.getReference("message");

                //Reading from the database
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        Log.d("User","value is 55555555555:");
                       Log.d("\"Value is: ", value);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("\"didnt load: ","didnt load");
                    }
                });


            }
        });


    }

}
