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

public class IntroFragment extends Fragment implements View.OnClickListener {

    private Button startButton;
    private NavController navController;

    public IntroFragment() {
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
        View view = inflater.inflate(R.layout.fragment_intro, container, false);
        startButton = view.findViewById(R.id.button_start);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        startButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        navController.navigate(R.id.action_introFragment_to_quizzFragment);
    }
}