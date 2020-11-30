package com.example.gym;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import ui.Step1Fragment;
import ui.Step2Fragment;

public class StepsActivity extends AppCompatActivity {


    Step1Fragment step1Fragment = new Step1Fragment();
    Step2Fragment step2Fragment = new Step2Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        //менеджер фрагментов
        getSupportFragmentManager().beginTransaction().replace(R.id.container, step1Fragment).commit();

    }

    public void pressButton(View v){
        SharedPreferences sharedPreferences = getSharedPreferences("Steps", MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit();
        ed.putString("purpose", v.getTag().toString());
        ed.apply();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, step2Fragment).commit();
    }
}