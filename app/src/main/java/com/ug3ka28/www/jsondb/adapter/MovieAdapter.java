package com.ug3ka28.www.jsondb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ug3ka28.www.jsondb.R;
import com.ug3ka28.www.jsondb.model.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private Context context;
    private List<Movie> movies;

    public MovieAdapter(Context context, List<Movie> movies){
        this.context = context;
        this.movies = movies;
    }





    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder viewHolder, int i) {
        final Movie movie = movies.get(i);

        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path())
                .into(viewHolder.img);

        viewHolder.tvTitle.setText(movie.getTitle());
        viewHolder.tvOrgTitle.setText((movie.getOriginal_title()));
        viewHolder.tvOverview.setText(movie.getOverview());
        viewHolder.tvRelease_date.setText(movie.getRelease_date());
        viewHolder.tvAvgrate.setText(movie.getVote_average());


        Log.i("Data" , "overview : " + movie.getOverview());


    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView tvTitle;
        public TextView tvOrgTitle;
        public TextView tvOverview;
        public TextView tvRelease_date;
        public TextView tvAvgrate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOrgTitle = itemView.findViewById(R.id.tvOrgTitle);
            tvOverview = itemView.findViewById(R.id.tvOverview);
            tvRelease_date = itemView.findViewById(R.id.tvRdate);
            tvAvgrate = itemView.findViewById(R.id.tvAvgrate);
        }
    }
}
