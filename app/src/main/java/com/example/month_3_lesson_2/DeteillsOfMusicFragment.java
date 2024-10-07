package com.example.month_3_lesson_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.month_3_lesson_2.databinding.FragmentDeteillsOfMusicBinding;

import java.util.ArrayList;

public class DeteillsOfMusicFragment extends Fragment {
    private FragmentDeteillsOfMusicBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDeteillsOfMusicBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            ArrayList<MusicItem> cameArraylist = bundle.getParcelableArrayList("forDetails");
            int index = bundle.getInt("Index");

            if (cameArraylist != null) {
                binding.authorName.setText("Исполнитель : "+cameArraylist.get(index).getMusicAuthor());
                binding.musicName.setText("Название: "+cameArraylist.get(index).getMusicName());
            }
        }
    }
}