package com.example.room_17ka1a0506;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserViewHolder> {
    Context ctx;
    List<UserEntity> list;

    public MyAdapter(Context ctx , List<UserEntity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        return new UserViewHolder( (LayoutInflater.from( ctx )
                .inflate( R.layout.every_row , parent , false )) );
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder , int position) {
      holder.name.setText( list.get( position ).getName() );
      holder.email.setText( list.get( position ).getEmail() );
      holder.phone.setText( list.get( position ).getPhone() );
      holder.delete.setOnClickListener( new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              MainActivity.viewModel.delete( list.get( position ) );
              Toast.makeText( ctx,holder.name.getText().toString()+"deleted",Toast.LENGTH_SHORT ).show();
          }
      } );
    }

    public int getItemCount()
    {
        return list.size();
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
       TextView edit,name,email,phone,delete;
        public UserViewHolder(@NonNull View itemView) {
            super( itemView );
            edit=itemView.findViewById( R.id.text_edit );
            name=itemView.findViewById( R.id.text_username );
            email=itemView.findViewById( R.id.edittext_email );
            delete=itemView.findViewById( R.id.text_delete );
            edit.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String nn=name.getText().toString();
                    String em=email.getText().toString();
                    String ph=phone.getText().toString();
                    Intent i=new Intent( ctx,UpdateActivity.class );
                    i.putExtra( "key1",nn );
                    i.putExtra( "key2",em );
                    i.putExtra( "key3",ph );
                    ctx.startActivity( i );
                }
            } );
        }
    }
}
