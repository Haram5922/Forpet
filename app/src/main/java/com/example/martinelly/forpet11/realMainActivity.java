package com.example.martinelly.forpet11;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class realMainActivity extends AppCompatActivity {

    private ImageButton meseenger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_main);

        meseenger = (ImageButton)findViewById(R.id.message);

        meseenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), messenger.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
