package com.bartechspaceship.eShowStarWarsDemo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bartechspaceship.eShowStarWarsDemo.Adapters.ExampleAdapter;
import com.bartechspaceship.eShowStarWarsDemo.Objects.ExampleItem;
import com.bartechspaceship.eShowStarWarsDemo.R;

import java.util.ArrayList;

public class FragmentFilmSelection extends Fragment {


    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.fragment_film_selection, container, false);

        //Navigation recycler view is being called here
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final FragmentActivity c = getActivity();

        ArrayList<ExampleItem> exampleList = new ArrayList<>();

        //This is where the names of the fragments are being called
        exampleList.add(new ExampleItem("A New Hope", "1977-05-25"));//Movie4
        exampleList.add(new ExampleItem("The Empire Strkies Back", "1980-05-17"));//Movie5
        exampleList.add(new ExampleItem("Return of the Jedi", "1983-05-25"));//Movie6
        exampleList.add(new ExampleItem("The Phantom Menace", "1999-05-19"));//Movie1
        exampleList.add(new ExampleItem("Attack of the Clones", "2002-05-16"));//Movie2
        exampleList.add(new ExampleItem("Revenge of the Sith", "2005-05-19"));//Movie3
        exampleList.add(new ExampleItem("The Force Awakens", "2015-12-11"));//Movie3

        //Will not populate infinite number of navigatoin Card ViewS
        recyclerView.setHasFixedSize(true);

        mAdapter = new ExampleAdapter(getActivity(), exampleList);
        mLayoutManager = new LinearLayoutManager(c);





        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);







        return view;
    }

}
