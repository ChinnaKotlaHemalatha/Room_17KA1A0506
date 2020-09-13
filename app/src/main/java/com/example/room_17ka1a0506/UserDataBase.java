package com.example.room_17ka1a0506;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database( entities = UserEntity.class,version =1,exportSchema = false)
public abstract class UserDataBase extends RoomDatabase {
    public static UserDataBase dataBase;
    public  abstract UserDao userDao();
    public static synchronized UserDataBase getDataBase(Context ctx){
        if (dataBase==null){
            dataBase = Room.databaseBuilder(ctx,UserDataBase.class, "name")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
    }
        return dataBase;

}

}


