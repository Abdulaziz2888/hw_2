package com.example.hw_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw_2.databinding.FragmentFirstBinding;

public class SecondFragment extends Fragment {

    private TextView textViewResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textViewResult = view.findViewById(R.id.tv_result);

        if (getArguments() != null) {
            int result = getArguments().getInt("count", 0); // Default to 0 if not found
            textViewResult.setText("Received Count: " + result);
        }

        return view;
    }
}