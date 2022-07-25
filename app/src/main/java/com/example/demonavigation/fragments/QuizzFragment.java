package com.example.demonavigation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demonavigation.R;

public class QuizzFragment extends Fragment {

    private NavController navController;
    private Button btnTrue, btnFalse;
    private static final int mScore = 100;

    public QuizzFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quizz, container, false);
        Toolbar toolbar = view.findViewById(R.id.my_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

        btnTrue = view.findViewById(R.id.button_true);
        btnFalse = view.findViewById(R.id.button_false);

        btnTrue.setOnClickListener(v -> {
            QuizzFragmentDirections
                    .ActionQuizzFragmentToCongratFragment action = QuizzFragmentDirections
                    .actionQuizzFragmentToCongratFragment();
            action.setScore(mScore);
            navController.navigate(action);
        });

        btnFalse.setOnClickListener(v -> {
            navController.navigate(QuizzFragmentDirections.actionQuizzFragmentToFailFragment());
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_quizz, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_quizz_logout:
                logout();
                break;
        }
        return true;
    }

    private void logout() {
        navController.navigate(R.id.action_quizzFragment_to_onBoardingFragment);
    }
}