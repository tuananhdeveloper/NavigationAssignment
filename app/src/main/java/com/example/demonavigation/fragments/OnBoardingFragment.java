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

public class OnBoardingFragment extends Fragment implements View.OnClickListener {

    private Button nextButton;
    private NavController navigationController;

    public OnBoardingFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boarding, container, false);
        nextButton = view.findViewById(R.id.button_next);
        nextButton.setOnClickListener(this);
        navigationController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        return view;
    }

    @Override
    public void onClick(View v) {
        navigationController.navigate(R.id.action_onBoardingFragment_to_introFragment);
    }

}