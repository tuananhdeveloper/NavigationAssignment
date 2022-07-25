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

public class CongratFragment extends Fragment {
    private NavController navController;

    public CongratFragment() {
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
        View view = inflater.inflate(R.layout.fragment_congrat, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button buttonRetest = view.findViewById(R.id.button_retest);
        Button buttonScore = view.findViewById(R.id.button_score);

        buttonRetest.setOnClickListener(v -> {
            navController.navigate(CongratFragmentDirections.actionCongratFragmentToQuizzFragment());
        });

        int score = CongratFragmentArgs.fromBundle(getArguments()).getScore();
        buttonScore.setText("Score: " + score);
        return view;
    }
}