package com.photoof;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AuthActivity extends AppCompatActivity {
    private EditText psw ;
    private Button ok_btnn ;
    boolean clicked ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        psw = findViewById(R.id.psw);
        ok_btnn = findViewById(R.id.ok_btnn);


        clicked = false ;
        ok_btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked = true ;
                proceed();
            }
        });


    }

    private void proceed() {

        if(clicked ){
            Intent intent = new Intent(AuthActivity.this,DisplayActivity.class);
            intent.putExtra("password",psw.getText().toString().trim());
            startActivity(intent);
        }
        else{
        }

    }
}
