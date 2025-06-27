package com.example.userlistapp.data;

import java.util.List;
import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
public interface ApiService {
    @GET("/users")
    Single<List<User>> getUsers();
}