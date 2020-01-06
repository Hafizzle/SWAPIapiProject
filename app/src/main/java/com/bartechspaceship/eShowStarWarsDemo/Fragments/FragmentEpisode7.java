package com.bartechspaceship.eShowStarWarsDemo.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bartechspaceship.eShowStarWarsDemo.Adapters.RecyclerViewAdapter;
import com.bartechspaceship.eShowStarWarsDemo.Objects.Character;
import com.bartechspaceship.eShowStarWarsDemo.R;
import com.bartechspaceship.eShowStarWarsDemo.Objects.StarWarsDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentEpisode7 extends Fragment {


    private TextView mTitle;
    private TextView mOpeningCrawl;
    private TextView mDirectorTitle;
    private TextView mProducer;
    private TextView mReleaseDate;
    public RequestQueue mQueue;
    private ArrayList<StarWarsDataModel> mStarWarsDataModels;
    private int episodeNum;
    public RecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;


    private Character mCharacter;
    private ArrayList<Character> mCharacters;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode7, container, false);

        //Initializing views.
        mTitle = view.findViewById(R.id.title);
        mOpeningCrawl = view.findViewById(R.id.opening_crawl);
        mDirectorTitle = view.findViewById(R.id.director);
        mProducer = view.findViewById(R.id.producer);
        mReleaseDate = view.findViewById(R.id.release_date);

        mCharacters = new ArrayList<>();

        mQueue = Volley.newRequestQueue(getActivity());
        mStarWarsDataModels = new ArrayList<>();//Change mStarWarsDataModel to something like mStarWarsArray

        //The ID to match to the episode
        episodeNum = 7;

        mCharacters.add(new Character("Poe Dameron"));
        mCharacters.add(new Character("Chewbacca"));
        mCharacters.add(new Character("Hansolo"));
        mCharacters.add(new Character("Ackbar"));

        jsonParse();


        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerViewAdapter(getActivity(), mCharacters);
        recyclerView.setAdapter(mAdapter);


        return view;
    }
    //Using Volley to make a REST call.
    public void jsonParse() {

        //final TextView mTitle;
        //mTitle = (TextView) v.findViewById(R.id.title);
        String url = "https://swapi.co/api/films";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            //Comment what result is
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                String title = result.getString("title");
                                String openingCrawl = result.getString("opening_crawl");
                                String director = result.getString("director");
                                String producer = result.getString("producer");
                                String release_date = result.getString("release_date");
                                int episode_id = result.getInt("episode_id");

                                StarWarsDataModel starWarsDataModel = new StarWarsDataModel(title, openingCrawl, director, producer, release_date, episode_id, mCharacters);
                                mStarWarsDataModels.add(starWarsDataModel);

                                JSONArray characters = result.getJSONArray("characters");
                                mCharacter = new Character(characters.getString(0));
                                mCharacters.add(mCharacter);

                                //int age = result.getInt("age");
                                //String mail = result.getString("mail");

                                //mTitle.setText(title);//Was previously append
                                setTextViews(mStarWarsDataModels);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast toast = new Toast(getActivity());
                            //toast.makeText(getActivity(), "Call Failed", Toast.LENGTH_SHORT).show();

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);


    }

    public void setTextViews(ArrayList<StarWarsDataModel> starWarsDataModels){
        for (StarWarsDataModel starWarsDataModel : starWarsDataModels){
            if(starWarsDataModel.getEpisode_id() == episodeNum){
                mTitle.setText(starWarsDataModel.getTitle());
                mOpeningCrawl.setText(starWarsDataModel.getOpening_crawl());
                mDirectorTitle.setText(starWarsDataModel.getDirector());
                mProducer.setText(starWarsDataModel.getProducer());
                mReleaseDate.setText(starWarsDataModel.getRelease_date());
            }

        }
    }
}
