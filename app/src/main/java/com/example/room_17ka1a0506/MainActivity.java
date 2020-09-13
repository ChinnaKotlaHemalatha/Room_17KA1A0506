package com.example.room_17ka1a0506;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    static UserDataBase dataBase;
    List<UserEntity> entityList;
    UserEntity entity;
    static UserViewModel viewModel;
    EditText username, email,phone;
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        username = findViewById( R.id.edittext_username );
        email= findViewById( R.id.edittext_email );
        phone= findViewById( R.id.edittext_phone );
        recycler = findViewById( R.id.recycler_view );
       /* dataBase = Room.databaseBuilder(this, StudentDataBase.class, "name")
                .allowMainThreadQueries().build();*/
        viewModel = new ViewModelProvider( this ).get( UserViewModel.class );
        viewModel.liveData().observe( this , new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> userEntities) {
                adapter = new MyAdapter( MainActivity.this , userEntities );
                recycler.setLayoutManager( new LinearLayoutManager( MainActivity.this ) );
                recycler.setAdapter( adapter );
            }
        } );
    }

    public void saveData(View view) {
        String uname = username.getText().toString();
        String uema = email.getText().toString();
        String uph=phone.getText().toString();
        entity = new UserEntity();
        entity.setName( uname );
        entity.setEmail( uema );
        entity.setPhone( uph );
        viewModel.insert( entity );
        //  dataBase.studentDao().insert(entity);
        Toast.makeText( this , "insert sucess" + uname , Toast.LENGTH_SHORT ).show();
    }
}