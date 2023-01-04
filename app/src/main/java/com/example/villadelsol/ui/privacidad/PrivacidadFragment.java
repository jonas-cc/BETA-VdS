package com.example.villadelsol.ui.privacidad;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.villadelsol.R;
import com.example.villadelsol.databinding.FragmentHomeBinding;
import com.example.villadelsol.databinding.FragmentPrivacidadBinding;


public class PrivacidadFragment extends Fragment {
    private FragmentPrivacidadBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_privacidad, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}