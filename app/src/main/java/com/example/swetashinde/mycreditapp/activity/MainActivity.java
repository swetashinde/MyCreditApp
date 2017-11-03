package com.example.swetashinde.mycreditapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.swetashinde.mycreditapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.creditButton)
    Button creditButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        creditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent creditIntent = new Intent(MainActivity.this,CreditApplicationActivity.class);
                startActivity(creditIntent);


            }
        });
    }
}
