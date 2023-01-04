package com.example.villadelsol;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class banquetes extends AppCompatActivity {
    ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_menu_banquetes);

        imageSlider=findViewById(R.id.SliderS1);
        ArrayList<SlideModel> imagelist=new ArrayList<>();
        imagelist.add(new SlideModel(R.drawable.menuslider,null));
        imagelist.add(new SlideModel(R.drawable.menuslider1,null));
        imagelist.add(new SlideModel(R.drawable.menuslider3,null));
        imagelist.add(new SlideModel(R.drawable.menuslider2,null));
        imagelist.add(new SlideModel(R.drawable.menuslider4,null));
        imagelist.add(new SlideModel(R.drawable.menuslider9,null));
        imagelist.add(new SlideModel(R.drawable.menuslider5,null));
        imagelist.add(new SlideModel(R.drawable.menuslider6,null));
        imagelist.add(new SlideModel(R.drawable.menuslider7,null));
        imagelist.add(new SlideModel(R.drawable.menuslider8,null));
        imagelist.add(new SlideModel(R.drawable.menuslider10,null));

        imageSlider.setImageList(imagelist);
    }
}

