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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    private Button b1;
    EditText nf,nl,em,pass;
    TextView t1;
    FirebaseAuth fauthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        b1=findViewById(R.id.button);
        nf=findViewById(R.id.namef);
        nl=findViewById(R.id.namel);
        em=findViewById(R.id.tEmailid);
        pass=findViewById(R.id.password);
        fauthor= FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=em.getText().toString().trim();
                String pw=pass.getText().toString().trim();
                if (TextUtils.isEmpty(email)){
                    em.setError("Enter Email");
                    return;
                }
                if (TextUtils.isEmpty(pw)){
                    pass.setError("Enter the password");
                    return;
                }
                if(pass.length()<6){
                    pass.setError("Password Must contain 6 charactors");
                    return;
                }
                fauthor.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Register Succesfully",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), signin.class));
                        }else {
                            Toast.makeText(getApplicationContext(),"Register Failur",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
