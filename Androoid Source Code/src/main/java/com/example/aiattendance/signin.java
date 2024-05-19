package com.example.aiattendance;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
    EditText uemail,upassw;
    TextView t1;
    FirebaseAuth fauthor;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_page);
        fauthor=FirebaseAuth.getInstance();
        uemail=findViewById(R.id.textEmail2);
        upassw=findViewById(R.id.password);
        b1=findViewById(R.id.button);
        t1=findViewById(R.id.signup);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sign In Page",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emai=uemail.getText().toString().trim();
                String pw=upassw.getText().toString().trim();
                if (TextUtils.isEmpty(emai)){
                    uemail.setError("Enter Email");
                    return;
                }
                if (TextUtils.isEmpty(pw)){
                    upassw.setError("Enter the password");
                    return;
                }
                if(upassw.length()<6){
                    upassw.setError("Password Must contain 6 charactors");
                    return;
                }
                fauthor.signInWithEmailAndPassword(emai,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Succesfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"Login Failur",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}
