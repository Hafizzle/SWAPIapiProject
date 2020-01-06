package com.bartechspaceship.eShowStarWarsDemo.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bartechspaceship.eShowStarWarsDemo.Objects.Character;
import com.bartechspaceship.eShowStarWarsDemo.R;

import java.util.ArrayList;


//Second Recycler view, this one used for characters
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "Recycle View Adapter Testing In progress";
    private ArrayList<Character> mCharacterList;
    private Context mContext;//Create new constructor for all 3 of these

    public RecyclerViewAdapter(Context context, ArrayList<Character> characterList ) {
        this.mCharacterList = characterList;
        this.mContext = context;
    }

    @NonNull
    @Override//Connecting to XML
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.resource_test,parent,false);
        return new ViewHolder(view);
    }

    @Override//View holder for the chracter names
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {



        holder.mTextView.setText(mCharacterList.get(position).getName());



    }

    @Override//Returns the number of items that will be in the list
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.characterName);
        }
    }

}
