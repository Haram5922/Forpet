package com.example.martinelly.forpet11;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.martinelly.forpet11.fragment.PeopleFragment;

public class messenger extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        getFragmentManager().beginTransaction().replace(R.id.messenger_framelayout, new PeopleFragment()).commit();
    }
}
