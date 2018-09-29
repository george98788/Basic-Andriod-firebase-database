package com.example.george.databasetest;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {



        public String username;
        public String password;
    public String userId;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String userId, String username, String password) {
            this.userId = userId;
            this.username = username;
            this.password = password;
        }


    }

