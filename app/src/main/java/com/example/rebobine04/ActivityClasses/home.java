package com.example.rebobine04.ActivityClasses;

import android.os.Bundle;
import com.example.rebobine04.R;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;



public class home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


    }
}