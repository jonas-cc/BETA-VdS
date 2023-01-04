package com.example.villadelsol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Salon2 extends AppCompatActivity {

    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon2);

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
    }
}

