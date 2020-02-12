package com.example.martinelly.forpet11;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Password_find extends AppCompatActivity{
    private  static final String TAG = "Password_find";
    private EditText em;
    private Button send;
    private TextView com1;
    private TextView com2;
    private ImageButton back;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    View.OnClickListener cl;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_find);

        back = (ImageButton)findViewById(R.id.back);
        em = (EditText)findViewById(R.id.send_email);
        send = (Button)findViewById(R.id.send);
        com1 = (TextView)findViewById(R.id.complete1);
        com2 = (TextView)findViewById(R.id.complete2);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (v == send){
                progressDialog.setMessage("처리중입니다. 잠시 기다려 주세요");
                progressDialog.show();
                String emailAddress = em.getText().toString().trim();
                firebaseAuth.sendPasswordResetEmail(emailAddress)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                com1.setText("●");
                                com2.setText("메일이 전송 되었습니다.");

                            }else {
                                Toast.makeText(Password_find.this, "메일 주소를 확인해주세요", Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();;
                            }
                        });



            }
            }

        };
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Password_find.this,LoginActivity.class));
            }
        });
        send.setOnClickListener(cl);

    }
}
