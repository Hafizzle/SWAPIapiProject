package com.bartechspaceship.eShowStarWarsDemo.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bartechspaceship.eShowStarWarsDemo.Objects.Character;
import com.bartechspaceship.eShowStarWarsDemo.Objects.CharacterURL;
import com.bartechspaceship.eShowStarWarsDemo.R;
import com.bartechspaceship.eShowStarWarsDemo.Adapters.RecyclerViewAdapter;
import com.bartechspaceship.eShowStarWarsDemo.Objects.StarWarsDataModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.VolleyLog.TAG;

public class FragmentEpisode4 extends Fragment {
    private TextView mTitle;
    private TextView mOpeningCrawl;
    private TextView mDirectorTitle;
    private TextView mProducer;
    private TextView mReleaseDate;
    public RequestQueue mQueue;
    public RequestQueue mQueue2;
    private ArrayList<StarWarsDataModel> mStarWarsDataModels;
    private int episodeNum;
    public RecyclerViewAdapter mAdapter;
    private RecyclerView recyclerView;
    private ArrayList<CharacterURL> characterURLs;
    private StarWarsDataModel mStarWarsDataModel;
    private View rootView;
    private ArrayList<String> mTestArray;

    private Character mCharacter;
    private ArrayList<Character> mCharacters;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode4, container, false);

        final FragmentActivity c = getActivity();

        //Initializing views.
        mTitle = view.findViewById(R.id.title);
        mOpeningCrawl = view.findViewById(R.id.opening_crawl);
        mDirectorTitle = view.findViewById(R.id.director);
        mProducer = view.findViewById(R.id.producer);
        mReleaseDate = view.findViewById(R.id.release_date);
        mCharacters = new ArrayList<>();

        mStarWarsDataModels = new ArrayList<>();

        //The ID to match to the episode
        episodeNum = 4;

        mQueue = Volley.newRequestQueue(getActivity());
        mQueue2 = Volley.newRequestQueue(getActivity());

        jsonParse();

        mCharacters.add(new Character("Luke Skywalker"));
        mCharacters.add(new Character("Darth Vader"));
        mCharacters.add(new Character("C-3PO"));



        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerViewAdapter(getActivity(), mCharacters);
        recyclerView.setAdapter(mAdapter);

        return view;

    }

    //Using Volley to make a REST call.
    public void jsonParse() {


        String url = "https://swapi.co/api/films";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject result = jsonArray.getJSONObject(i);

                                characterURLs = new ArrayList();

                                String title = result.getString("title");
                                String openingCrawl = result.getString("opening_crawl");
                                String director = result.getString("director");
                                String producer = result.getString("producer");
                                String release_date = result.getString("release_date");
                                int episode_id = result.getInt("episode_id");

                                JSONArray characters = result.getJSONArray("characters");
                                /*for (int j = 0; j < characters.length(); j++) {

                                    CharacterURL characterURL = new CharacterURL(characters.getString(j));
                                    characterURLs.add(characterURL);
                                    Log.d(TAG, "onResponse5:" + characterURLs);

                                }*/
                                mStarWarsDataModel = new StarWarsDataModel(title, openingCrawl, director, producer, release_date, episode_id);
                                //mStarWarsDataModel.setCharacterURLS(characterURLs);
                                //getCharactersFromJson(mStarWarsDataModel);
                                mStarWarsDataModels.add(mStarWarsDataModel);
                                setTextViews(mStarWarsDataModels);
                                mAdapter.notifyDataSetChanged();
                                Log.d(TAG, "onResponseCHECKARRAY: " + mCharacters.size());

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();


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

    public void setTextViews(ArrayList<StarWarsDataModel> starWarsDataModels) {
        for (StarWarsDataModel starWarsDataModel : starWarsDataModels) {
            if (starWarsDataModel.getEpisode_id() == episodeNum) {
                mTitle.setText(starWarsDataModel.getTitle());
                mOpeningCrawl.setText(starWarsDataModel.getOpening_crawl());
                mDirectorTitle.setText(starWarsDataModel.getDirector());
                mProducer.setText(starWarsDataModel.getProducer());
                mReleaseDate.setText(starWarsDataModel.getRelease_date());


            }
        }
    }

    public void getCharactersFromJson(StarWarsDataModel starWarsDataModel) {
        for (String url : starWarsDataModel.getCharacterURLStoString()) {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {

                                String name = response.get("name").toString();

                                mCharacters.add(new Character(name));

                                Log.d(TAG, "onResponsetestarray: " + mCharacters.size());
                                Log.d(TAG, "onResponseTest: " + name);

                            } catch (JSONException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });

            mQueue2.add(request);

        }
        }
        }


