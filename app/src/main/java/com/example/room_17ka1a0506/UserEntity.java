package com.example.room_17ka1a0506;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userdetails")

public class UserEntity {
    @ColumnInfo(name = "name")
    String name;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "email")
    String email;
    @ColumnInfo(name = "phone")
    String phone;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    @NonNull
    public String getEmail() {

        return email;
    }

    public void setEmail(@NonNull String email) {

        this.email =email;
    }
    public String getPhone() {

        return phone;
    }

    public void setPhone(@NonNull String phone) {

        this.phone = phone;
    }
}

