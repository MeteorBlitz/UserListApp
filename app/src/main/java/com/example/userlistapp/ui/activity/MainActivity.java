package com.example.userlistapp.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.userlistapp.data.User;
import com.example.userlistapp.databinding.ActivityMainBinding;
import com.example.userlistapp.ui.adapter.UserAdapter;
import com.example.userlistapp.ui.viewmodel.UserViewModel;
import com.example.userlistapp.utils.Result;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private UserAdapter adapter;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ✅ ViewBinding setup
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ✅ Setup RecyclerView
        adapter = new UserAdapter(new ArrayList<>(), user -> {
            Toast.makeText(this, "Clicked: " + user.getName(), Toast.LENGTH_SHORT).show();
            // TODO: Navigate to detail screen (optional)
        });

        binding.recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewUsers.setAdapter(adapter);

        // ✅ Get ViewModel
        viewModel = new ViewModelProvider(this).get(UserViewModel.class);

        // ✅ Observe LiveData
        viewModel.getUsersLiveData().observe(this, result -> {
            if (result instanceof Result.Loading) {
                binding.progressBar.setVisibility(View.VISIBLE);
                binding.textError.setVisibility(View.GONE);
            } else if (result instanceof Result.Success) {
                binding.progressBar.setVisibility(View.GONE);
                binding.textError.setVisibility(View.GONE);
                List<User> userList = ((Result.Success<List<User>>) result).getData();
                adapter.updateList(userList);
            } else if (result instanceof Result.Error) {
                binding.progressBar.setVisibility(View.GONE);
                binding.textError.setVisibility(View.VISIBLE);
                binding.textError.setText(((Result.Error<List<User>>) result).getErrorMessage());
            }
        });
    }
}