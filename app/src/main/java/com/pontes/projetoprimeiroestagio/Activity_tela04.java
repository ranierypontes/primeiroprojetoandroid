package com.pontes.projetoprimeiroestagio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_tela04 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela04);
    }

    public void salvarContato(View view){

        startActivity(new Intent(Activity_tela04.this, Activity_tela02.class));
    }
}
