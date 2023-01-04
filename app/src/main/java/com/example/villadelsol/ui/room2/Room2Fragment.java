package com.example.villadelsol.ui.room2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.villadelsol.R;
import com.example.villadelsol.databinding.FragmentRoom1Binding;

import java.util.ArrayList;
import com.example.villadelsol.databinding.FragmentRoom2Binding;

import java.util.ArrayList;

public class Room2Fragment extends Fragment {
    ImageSlider imageSlider;

    private FragmentRoom1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_room2,container,false);
        imageSlider=view.findViewById(R.id.SliderS2);
        //setContentView(R.layout.activity_salon2);
        //imageSlider=findViewById(R.id.SliderS2);
        ArrayList<SlideModel> imagelist=new ArrayList<>();

        imagelist.add(new SlideModel(R.drawable.salon2,null));
        imagelist.add(new SlideModel(R.drawable.s2_1,null));
        imagelist.add(new SlideModel(R.drawable.s2_2,null));
        imagelist.add(new SlideModel(R.drawable.s2_3,null));
        imagelist.add(new SlideModel(R.drawable.s2_4,null));
        imagelist.add(new SlideModel(R.drawable.s2_5,null));
        imagelist.add(new SlideModel(R.drawable.s2_6,null));
        imagelist.add(new SlideModel(R.drawable.s2_8,null));

        imageSlider.setImageList(imagelist);

        /*Room2ViewModel room2ViewModel =
                new ViewModelProvider(this).get(Room2ViewModel.class);

        binding = FragmentRoom2Binding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView19;
        room1ViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}