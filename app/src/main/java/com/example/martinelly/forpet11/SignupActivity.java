package com.example.martinelly.forpet11;



import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.martinelly.forpet11.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public class SignupActivity extends AppCompatActivity {

    private EditText email;
    private EditText name;
    private EditText add2;
    private EditText birth;
    private EditText pnum;
    private EditText password;
    private Button signup;
    private Button set;
    private EditText word1;
    private ImageView setImage;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        String splash_background = mFirebaseRemoteConfig.getString(getString(R.string.rc_color));
        getWindow().setStatusBarColor(Color.parseColor(splash_background));


        word1 = (EditText)findViewById(R.id.signupActivity_edittext_password2);
        email = (EditText)findViewById(R.id.signupActivity_edittext_email);
        name = (EditText)findViewById(R.id.signupActivity_edittext_name);
        password = (EditText)findViewById(R.id.signupActivity_edittext_password);
        signup = (Button)findViewById(R.id.signupActivity_button_signup);
        set = (Button)findViewById(R.id.signupActivity_button_setup);
        add2 = (EditText)findViewById(R.id.signupActivity_edittext_address2);
        birth = (EditText)findViewById(R.id.signupActivity_edittext_birth);
        pnum = (EditText)findViewById(R.id.signupActivity_edittext_phonenum);
        setImage = (ImageView)findViewById(R.id.setimage);


        word1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(password.getText().toString().equals(word1.getText().toString())){
                    setImage.setImageResource(R.drawable.right);
                }else{
                    setImage.setImageResource(R.drawable.no);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(email.getText().toString()==null  || name.getText().toString() ==null){
                    return;
                }

                FirebaseAuth.getInstance()
                        .createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>()

                        {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                UserModel userModel = new UserModel();
                                userModel.userName = name.getText().toString();
                                userModel.birth= birth.getText().toString();
                                userModel.phonenum= pnum.getText().toString();
                                userModel.address2= add2.getText().toString();
                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);


                                Toast.makeText(SignupActivity.this,"완료 버튼을 눌러주세요",Toast.LENGTH_SHORT).show();
                            }


                        });




            }





        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        LoginActivity.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);

            }
        });


    }

}
