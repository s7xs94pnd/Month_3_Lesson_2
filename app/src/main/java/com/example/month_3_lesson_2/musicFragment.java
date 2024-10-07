package com.example.month_3_lesson_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.month_3_lesson_2.databinding.FragmentMusicBinding;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class musicFragment extends Fragment {


    private FragmentMusicBinding binding;



    private AtomicInteger i = new AtomicInteger();


    private ArrayList<MusicItem> musicList = new ArrayList<MusicItem>(){{
        add(new MusicItem("Goshs", R.drawable.m1000x1000, "$not"));
        add(new MusicItem("punani", R.drawable.firstpic, "6ix9ine"));
        add(new MusicItem("Hot", R.drawable.secondpic, "Inna"));
        add(new MusicItem("Big", R.drawable.thirdpic, "big"));
        add(new MusicItem("long Money", R.drawable.fourthpic, "Kizaru"));
        add(new MusicItem("cry", R.drawable.fivethpic, "Sigarets after 6"));

    }};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentMusicBinding.inflate(getLayoutInflater());
        // Inflate the layout for this fragment
        return binding.getRoot();

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        binding.imageMusic.setImageResource(musicList.get(0).getMusicImage());
        binding.musicName.setText (musicList.get(0).getMusicName());


        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i.get() > 0) {
                    i.getAndDecrement();
                    // i--
                    binding.musicName.setText(musicList.get(i.get()).getMusicName());
                    binding.imageMusic.setImageResource(musicList.get(i.get()).getMusicImage());
                } else {
                    Toast.makeText(getContext(), "Это первая песня", Toast.LENGTH_SHORT).show();
                }
            }
        });



        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i.get() < musicList.size() - 1) {
                    i.getAndIncrement();// i++
                    binding.musicName.setText(musicList.get(i.get()).getMusicName());
                    binding.imageMusic.setImageResource(musicList.get(i.get()).getMusicImage());
                } else {
                    Toast.makeText(getContext(), "Это последняя песня", Toast.LENGTH_SHORT).show();
                }
            }
        });



        binding.imageMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();

                bundle.putInt("Index", i.get());

                bundle.putParcelableArrayList("forDetails", musicList);

                DeteillsOfMusicFragment detailsFragment = new DeteillsOfMusicFragment();

                detailsFragment.setArguments(bundle);

                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.music_fragment, detailsFragment).addToBackStack(null).commit();
            }
        });



    }

    }