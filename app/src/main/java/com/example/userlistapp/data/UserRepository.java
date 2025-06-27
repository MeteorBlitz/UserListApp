package com.example.userlistapp.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.userlistapp.utils.Result;
import com.example.userlistapp.utils.RetrofitClient;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class UserRepository {

    private final ApiService apiService;

    public UserRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public LiveData<Result<List<User>>> getUsers() {
        MutableLiveData<Result<List<User>>> liveData = new MutableLiveData<>();
        liveData.setValue(new Result.Loading<>());

        apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // Optional: Keep Disposable reference if needed
                    }

                    @Override
                    public void onSuccess(List<User> users) {
                        liveData.setValue(new Result.Success<>(users));
                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData.setValue(new Result.Error<>(e.getMessage()));
                    }
                });

        return liveData;
    }
}
