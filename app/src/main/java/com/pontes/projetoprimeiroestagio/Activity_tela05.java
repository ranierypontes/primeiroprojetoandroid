package com.pontes.projetoprimeiroestagio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_tela05 extends AppCompatActivity {

    protected Button btSalvarConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela05);
    }

    public void salvarConfiguracoes(View view){
        btSalvarConfig = (Button) findViewById(R.id.btSalvarConfiguracoes);
        startActivity(new Intent(Activity_tela05.this, Activity_tela02.class));
        finish();
    }
}
