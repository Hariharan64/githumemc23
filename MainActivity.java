package com.example.qradmin;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {

    private EditText editTextUserId, editTextUserName, editTextUserDesignation;
    private Button buttonAddUser;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        editTextUserId = findViewById(R.id.editTextUserId);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextUserDesignation = findViewById(R.id.editTextUserDesignation);
        buttonAddUser = findViewById(R.id.buttonAddUser);

        buttonAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUserToDatabase();
            }
        });
    }

    private void addUserToDatabase() {
        String userId = editTextUserId.getText().toString().trim();
        String userName = editTextUserName.getText().toString().trim();
        String userDesignation = editTextUserDesignation.getText().toString().trim();

        if (userId.isEmpty() || userName.isEmpty() || userDesignation.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        @SuppressLint("RestrictedApi")
        User user = new User(userId);
        databaseReference.child(userId).setValue(user)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "User added successfully", Toast.LENGTH_SHORT).show();
                        clearFields();
                    } else {
                        Toast.makeText(MainActivity.this, "Failed to add user", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearFields() {
        editTextUserId.setText("");
        editTextUserName.setText("");
        editTextUserDesignation.setText("");
    }
}
