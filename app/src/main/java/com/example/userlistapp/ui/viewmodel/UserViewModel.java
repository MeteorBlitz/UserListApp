package com.example.userlistapp.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.userlistapp.data.User;
import com.example.userlistapp.data.UserRepository;
import com.example.userlistapp.utils.Result;

import java.util.List;

public class UserViewModel extends ViewModel {

    private final UserRepository repository;
    private final LiveData<Result<List<User>>> usersLiveData;

    public UserViewModel() {
        repository = new UserRepository();
        usersLiveData = repository.getUsers();
    }

    public LiveData<Result<List<User>>> getUsersLiveData() {
        return usersLiveData;
    }
}