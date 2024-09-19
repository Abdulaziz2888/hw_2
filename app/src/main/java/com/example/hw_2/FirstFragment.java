package com.example.hw_2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private int count = 0;
    private TextView textViewCount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        textViewCount = view.findViewById(R.id.tv_counter);
        Button buttonIncrement = view.findViewById(R.id.btn_plus);
        Button buttonDecrement = view.findViewById(R.id.btn_minus);
        Button buttonSendResult = view.findViewById(R.id.btn_result);

        buttonIncrement.setOnClickListener(v -> {
            count++;
            updateCountDisplay();
        });

        buttonDecrement.setOnClickListener(v -> {
            count--;
            updateCountDisplay();
        });

        buttonSendResult.setOnClickListener(v -> {
            sendResultToSecondFragment();
        });

        return view;
    }

    private void updateCountDisplay() {
        textViewCount.setText(String.valueOf(count));
    }

    private void sendResultToSecondFragment() {
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);

        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, secondFragment)
                .addToBackStack(null)
                .commit();
    }
}