package com.example.room_17ka1a0506;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class UserRepo {
    UserDataBase userDb;
    LiveData<List<UserEntity>> listLiveData;

    public UserRepo(Application app) {
        userDb = UserDataBase.getDataBase(app);
        listLiveData = userDb.userDao().retrive();
    }

    //insert
    public class MyAsyncTaskForInsert extends AsyncTask<UserEntity, Void, Void> {
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDb.userDao().insert(userEntities[0]);
            return null;
        }
    }

    public class MyAsyncTaskForUpdate extends AsyncTask<UserEntity, Void, Void> {
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDb.userDao().update(userEntities[0]);
            return null;
        }
    }

    public class MyAsyncTaskForDelete extends AsyncTask<UserEntity, Void, Void> {
        @Override
        protected Void doInBackground(UserEntity... userEntities) {
            userDb.userDao().delete(userEntities[0]);
            return null;
        }
    }

    public void insert(UserEntity entity) {
        new MyAsyncTaskForInsert().execute(entity);
    }

    public void update(UserEntity entity) {
        new MyAsyncTaskForUpdate().execute(entity);
    }

    public void delete(UserEntity entity) {
        new MyAsyncTaskForDelete().execute(entity);
    }

    public LiveData<List<UserEntity>> liveData() {
        return listLiveData;
    }
}



