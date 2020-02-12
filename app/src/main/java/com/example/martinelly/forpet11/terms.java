package com.example.martinelly.forpet11;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class terms extends Activity {

    ImageView iv;
    TextView te1,te2,te3;
    CheckBox cb1,cb2,cb3,cb4;
    Button ag,di;
    View.OnClickListener cl;
//    CompoundButton.OnCheckedChangeListener ccl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        iv = (ImageView) findViewById(R.id.imageView);

        te1 = (TextView) findViewById(R.id.text1);
        te2 = (TextView) findViewById(R.id.text2);
        te3 = (TextView) findViewById(R.id.text3);

        cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        cb4 = (CheckBox) findViewById(R.id.checkBox4);

        ag = (Button) findViewById(R.id.agree);
        di = (Button) findViewById(R.id.disagree);

        te1.setMovementMethod(new ScrollingMovementMethod());
        te2.setMovementMethod(new ScrollingMovementMethod());
        te3.setMovementMethod(new ScrollingMovementMethod());

        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId() ) {
                    case R.id.disagree :
                        Intent i2 = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.agree :
                        if (cb1.isChecked() && cb2.isChecked() ) {
                            Intent i = new Intent(getApplicationContext(), SignupActivity.class);
                            startActivity(i);
                        }else {
                            Toast.makeText(getApplicationContext(), "필수 항목에 대한 동의 여부를 확인해 주세요!", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }


            }
        };

        ag.setOnClickListener(cl);
        di.setOnClickListener(cl);




    }
}
