package com.example.forgetpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText getText;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getText = findViewById(R.id.email_or_mobile);
        textView =  findViewById(R.id.textView);

        findViewById(R.id.change_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = getText.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (text.isEmpty()){
                    Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
                }
                if (text.matches(emailPattern)&& text.length()>0) {
                    textView.setText("valid address");
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid email", Toast.LENGTH_SHORT).show();
                }

                if(Patterns.PHONE.matcher(text).matches() &&  text.length()==10) {
                    textView.setText(" phone number");
                    Toast.makeText(MainActivity.this, "successfule login with mobile number", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid mobile pattern", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}
