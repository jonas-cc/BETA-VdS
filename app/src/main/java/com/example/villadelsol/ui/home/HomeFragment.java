package com.example.villadelsol.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.villadelsol.Menu;
import com.example.villadelsol.R;
import com.example.villadelsol.Salon1;
import com.example.villadelsol.databinding.FragmentHomeBinding;
import com.example.villadelsol.ui.room1.Room1Fragment;
import com.example.villadelsol.ui.room2.Room2Fragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ViewFlipper v_Flipper;
    ImageSlider imageSlider;
    Button salon1, salon2;

    private FragmentHomeBinding binding;

    public HomeFragment(){

    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       // int images[]={R.drawable.flip1,R.drawable.flip2};
        //v_Flipper= getView().findViewById(R.id.v_flipper);
        //for (int image:images){
         //   flipperimages(image);
        //}
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        imageSlider=view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> imagelist=new ArrayList<>();
        imagelist.add(new SlideModel(R.drawable.flip2,null));
        imagelist.add(new SlideModel(R.drawable.flip6,null));
        imagelist.add(new SlideModel(R.drawable.flip1,null));
        imagelist.add(new SlideModel(R.drawable.flip5,null));

        imageSlider.setImageList(imagelist);

        salon1=view.findViewById(R.id.salon1);
        salon2=view.findViewById(R.id.salon2);

        salon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment salon1 = new Room1Fragment();
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_menu, salon1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        salon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment salon2 = new Room2Fragment();
                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_menu, salon2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });



       /* HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/


        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void irS1(View view) {

    }

    public void showRoom1Fragment(View view) {
    }

   /* public void flipperimages(int image){
        ImageView imageView=new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        v_Flipper.addView(imageView);
        v_Flipper.setFlipInterval(3000);
        v_Flipper.setAutoStart(true);

        v_Flipper.setInAnimation(getActivity(),android.R.anim.slide_out_right);
        v_Flipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
    }*/

}