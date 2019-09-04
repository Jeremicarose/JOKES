package com.arose.myrestaurants.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.arose.myrestaurants.R;
import com.arose.myrestaurants.models.Contents;
import com.arose.myrestaurants.models.Joke;
import com.arose.myrestaurants.models.Joke_;
import com.arose.myrestaurants.models.Joke__;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokesListAdapter extends RecyclerView.Adapter<JokesListAdapter.JokeViewHolder> {
    private ArrayList<Joke> mJokes = new ArrayList<>();
    private Context mContext;

    public JokesListAdapter(Context context, ArrayList<Joke> jokes) {
        mContext = context;
        mJokes = jokes;
    }

    @Override
    public JokesListAdapter.JokeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.joke_list_item, parent, false);
        JokeViewHolder viewHolder = new JokeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(JokesListAdapter.JokeViewHolder holder, int position) {
        holder.bindJoke(mJokes.get(position));
    }

    @Override
    public int getItemCount() {
        return mJokes.size();
    }

    public class JokeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.nameTextView) TextView mNameTextView;
        @BindView(R.id.jokeTextView) TextView mJokeTextView;
        @BindView(R.id.categoryTextView) TextView mCategoryTextView;
        @BindView(R.id.ratingTextView) TextView mRatingTextView;
        private Context mContext;

        public JokeViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindJoke(Joke joke) {
            mNameTextView.setText(joke.getName());
            mCategoryTextView.setText(joke.getCategories().get(0));
            mRatingTextView.setText("Rating: " + joke.getRating() + "/5");
        }
    }
}