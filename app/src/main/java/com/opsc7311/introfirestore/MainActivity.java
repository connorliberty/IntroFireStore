package com.opsc7311.introfirestore;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText enterCity;
    private EditText enterDay1;
    private EditText enterDay2;
    private EditText enterDay3;
    private EditText enterDay4;
    private EditText enterDay5;

    //Keys
    public static final String KEY_CITY = "city";
    public static final String KEY_DAY1 = "Day 1";
    public static final String KEY_DAY2 = "Day 2";
    public static final String KEY_DAY3 = "Day 3";
    public static final String KEY_DAY4 = "Day 4";
    public static final String KEY_DAY5 = "Day 5";


    //Connection to Firestore
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterCity = findViewById(R.id.edit_text_title);
        enterDay1 = findViewById(R.id.Day1);
        enterDay2 = findViewById(R.id.Day2);
        enterDay3 = findViewById(R.id.Day3);
        enterDay4 = findViewById(R.id.Day4);
        enterDay5 = findViewById(R.id.Day5);

        Button saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(view -> {
            String city = enterCity.getText().toString().trim();
            String day1 = enterDay1.getText().toString().trim();
            String day2 = enterDay2.getText().toString().trim();
            String day3 = enterDay3.getText().toString().trim();
            String day4 = enterDay4.getText().toString().trim();
            String day5 = enterDay5.getText().toString().trim();

            Map<String, Object> data = new HashMap<>();
            data.put(KEY_CITY, city);
            data.put(KEY_DAY1,day1);
            data.put(KEY_DAY2,day2);
            data.put(KEY_DAY3,day3);
            data.put(KEY_DAY4,day4);
            data.put(KEY_DAY5,day5);

            db.collection("Journal")
                    .add(data)
                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentReference> task) {
                            Toast.makeText(MainActivity.this,
                                    "Success", Toast.LENGTH_LONG).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d(TAG, "onFailure: " + e);
                        }
                    });

        });
    }
}