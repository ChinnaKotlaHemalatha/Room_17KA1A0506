package com.example.room_17ka1a0506;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    UserRepo userRepo;
    LiveData<List<UserEntity>> listLivedata_model;
    public UserViewModel(@NonNull Application application){
        super(application);
        userRepo=new UserRepo(application);
        listLivedata_model=userRepo.liveData();
    }
    public void insert(UserEntity entity){
        userRepo.insert(entity);
    }
    public void update(UserEntity entity){
        userRepo.update(entity);
    }
    public void delete(UserEntity entity){
        userRepo.delete(entity);
    }

    public LiveData<List<UserEntity>> liveData() {
        return listLivedata_model;
    }
}
