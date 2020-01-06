package com.bartechspaceship.eShowStarWarsDemo.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bartechspaceship.eShowStarWarsDemo.Objects.ExampleItem;
import com.bartechspaceship.eShowStarWarsDemo.Activities.MainActivity;
import com.bartechspaceship.eShowStarWarsDemo.R;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    //API link
    String FILM_URL = "https://swapi.co/api/films/";
    private ArrayList<ExampleItem> mExampleList;
    //private String mTitle;

    private Context mContext;


    //Adapter for Navigation fragment
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView1;
        public TextView mTextView2;
        CardView mCardView;


        public ExampleViewHolder(View itemView){
            super(itemView);
            //if i want image ill add it here find view by id
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mCardView = itemView.findViewById(R.id.cardViewItem);
        }
    }

    public ExampleAdapter(Context mContext, ArrayList<ExampleItem> exampleList){
        this.mExampleList = exampleList;
        this.mContext = mContext;
    }

    //Connecting to XML code
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }


    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        final ExampleItem exampleItem = mExampleList.get(position);

        //Updating the Text from example item
        holder.mTextView1.setText(exampleItem.getText1());//Was previously currentItem
        holder.mTextView2.setText(exampleItem.getText2());//Was previously currentItem

        //RequestParams params = new RequestParams();
        //params.put(test);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //A switch for Navigation fragment to choose film
                switch(holder.getAdapterPosition()){
                    case 0:
                        ((MainActivity)mContext).setViewPager(1);
                        //FragmentEpisode4 fragmentEpisode4 = new FragmentEpisode4();
                        //fragmentEpisode4.mQueue= Volley.newRequestQueue(mContext.getApplicationContext());
                        //fragmentEpisode4.jsonParse();

                        //fragmentEpisode4.mTitle.append();


                        break;
                    case 1:
                        ((MainActivity)mContext).setViewPager(2);
                        break;
                    case 2:
                        ((MainActivity)mContext).setViewPager(3);
                        break;
                    case 3:
                        ((MainActivity)mContext).setViewPager(4);
                        break;
                    case 4:
                        ((MainActivity)mContext).setViewPager(5);
                        break;
                    case 5:
                        ((MainActivity)mContext).setViewPager(6);
                        break;
                    case 6:
                        ((MainActivity)mContext).setViewPager(7);
                        break;
                    default:
                        ((MainActivity)mContext).setViewPager(0);
                        break;
                }


            }
        });

    }
     //Havle to define howmany items are going to be in the ist
    @Override
    public int getItemCount() {
        return mExampleList.size();
    }





}
