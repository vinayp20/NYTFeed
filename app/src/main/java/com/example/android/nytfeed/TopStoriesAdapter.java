package com.example.android.nytfeed;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;



public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.TopViewHolder> {

    private List<TopStories> topStories;
    private int rowLayout;
    private Context context;
    private ImageView imageView;

    public static class TopViewHolder extends RecyclerView.ViewHolder {
        LinearLayout topStoriesLayout;
        ImageView topImageView;
        TextView title;


        public TopViewHolder(View v) {
            super(v);
            topStoriesLayout = (LinearLayout) v.findViewById(R.id.top_layout);
            topImageView = (ImageView) v.findViewById(R.id.image_top);
            title = (TextView) v.findViewById(R.id.text_top);
        }
    }

    public TopStoriesAdapter(List<TopStories> topStories, int rowLayout, Context context) {
        this.topStories = topStories;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public TopStoriesAdapter.TopViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new TopViewHolder(view);
    }


    //@Override
    //public void onViewRecycled(TopViewHolder holder) {
    //    super.onViewRecycled(holder);
    //    holder.topImageView.setImageBitmap(null);
    //}

    @Override
    public void onBindViewHolder(TopViewHolder holder, int position) {
      //  if(topStories==null || topStories.size() <=0 )return;
        TopStories topStory = topStories.get(position);
        Uri uri = Uri.parse(topStory.getMultimedia().get(position).getUrl());
        Picasso.with(holder.topImageView.getContext())
                .load(uri)
               // .load(Uri.parse(topStories.get(position).multimedia.get(0).getUrl()))
       // .load("https://static01.nyt.com/images/2017/11/14/briefing/14Eveningbriefing-promo/14Eveningbriefing-promo-thumbStandard.jpg")
                .into(holder.topImageView);

        //        URL url;
//        try {
//            url = new URL(topStories.get(position).multimedia.get(0).getUrl());
//            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//            //imageView.setImageBitmap(bmp);
//            holder.topImageView.setImageBitmap(bmp);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////


        //Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        //imageView.setImageBitmap(bmp);
       // holder.topImageView.setImageBitmap(bmp);

        holder.title.setText(topStories.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }
}