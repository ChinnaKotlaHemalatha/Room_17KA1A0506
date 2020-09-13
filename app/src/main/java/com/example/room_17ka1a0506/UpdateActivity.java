package com.example.room_17ka1a0506;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    EditText name,email,phone;
    UserEntity entity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_activity);
        name = findViewById(R.id.update_username);
        email = findViewById(R.id.update_email);
        phone=findViewById( R.id.update_phone );
        Intent i=getIntent();
        String nam=i.getStringExtra("key1");
        String em=i.getStringExtra("key2");
        String pho=i.getStringExtra( "key3" );
        name.setText(nam);
        email.setText(em);
        email.setKeyListener(null);//edit disable
        phone.setText( pho );
    }

    public void updateData(View view) {
        String myName = name.getText().toString();
        String myEmail = email.getText().toString();
        String myPhone =phone.getText().toString();
        entity = new UserEntity();
        entity.setName(myName);
        entity.setEmail(myEmail);
        entity.setPhone( myPhone );
        MainActivity.viewModel.update(entity);
        //MainActivity.dataBase.studentDao().update(entity);
        Toast.makeText(this, myName + "is Updated", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }

}
