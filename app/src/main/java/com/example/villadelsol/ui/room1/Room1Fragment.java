package com.example.villadelsol.ui.room1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.villadelsol.R;

import java.util.ArrayList;

public class Room1Fragment extends Fragment {
    ImageSlider imageSlider;

    private FragmentRoom1Binding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_room1,container,false);
        imageSlider=view.findViewById(R.id.SliderS1);
        //setContentView(R.layout.activity_salon1);
        //imageSlider=findViewById(R.id.SliderS1);
        ArrayList<SlideModel> imagelist=new ArrayList<>();

        imagelist.add(new SlideModel(R.drawable.salonuno,null));
        imagelist.add(new SlideModel(R.drawable.s10,null));
        imagelist.add(new SlideModel(R.drawable.s11,null));
        imagelist.add(new SlideModel(R.drawable.s112,null));
        imagelist.add(new SlideModel(R.drawable.s14,null));
        imagelist.add(new SlideModel(R.drawable.s17,null));
        imagelist.add(new SlideModel(R.drawable.s18,null));
        imagelist.add(new SlideModel(R.drawable.s19,null));
        imagelist.add(new SlideModel(R.drawable.s10,null));

        imageSlider.setImageList(imagelist);

        /*Room1ViewModel room1ViewModel =
                new ViewModelProvider(this).get(Room1ViewModel.class);

        binding = FragmentRoom1Binding.inflate(inflater, container, false);
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