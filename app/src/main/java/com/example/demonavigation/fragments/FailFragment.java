package com.example.demonavigation.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demonavigation.R;

public class FailFragment extends Fragment {

    private NavController navController;

    public FailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fail, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button retestButton = view.findViewById(R.id.button_retest);

        retestButton.setOnClickListener(v -> {
            navController.navigate(R.id.action_failFragment_to_quizzFragment);
        });

        return view;
    }
}