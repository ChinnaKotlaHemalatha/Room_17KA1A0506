package com.example.room_17ka1a0506;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    public void insert(UserEntity entity);
    @Update
    public void update(UserEntity entity);
    @Delete
    public void delete(UserEntity entity);
    @Query( "SELECT * FROM userdetails" )
    public LiveData<List<UserEntity>> retrive();

}
