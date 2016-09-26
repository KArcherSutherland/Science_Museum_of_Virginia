package org.smv.smvguide.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import net.steamcrafted.materialiconlib.MaterialIconView;


import org.smv.smvguide.R;

import java.util.ArrayList;
import java.util.List;

import tyrantgit.explosionfield.ExplosionField;


/**
 * Created by Rhey Igou on 12/15/2015.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    public static Context mContext;
    private static List<String> mStrings;
    private static List<Boolean> mFavorites;
    private static OnFavoriteListener sOnFavoriteCallback;

    public RecyclerAdapter(List<String> mStrings, Context context, OnFavoriteListener callback) {
        mContext = context;
        this.mStrings = (mStrings != null) ? mStrings : new ArrayList<String>();
        this.mFavorites = new ArrayList<>();
        for (int i = 0; i < mStrings.size(); i++){
            mFavorites.add(i % 2 == 0 ? true : false);
        }
        this.sOnFavoriteCallback = callback;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView StringName;
        private TextView StringDescription;
        private MaterialIconView star;
        private ExplosionField mExplosionField;


        public ViewHolder(final View itemView) {
            super(itemView);
            StringName = (TextView) itemView.findViewById(R.id.itemName);
            StringDescription = (TextView) itemView.findViewById(R.id.itemDescription);
            star = (MaterialIconView) itemView.findViewById(R.id.starDark);
            mExplosionField = ExplosionField.attach2Window((Activity) mContext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //final Intent intent;
                    //intent = new Intent(mContext, SomeActivity.class);

                    //intent.putExtra("String", mStrings.get(getAdapterPosition()));
                    //or
                    //Bundle bundle = new Bundle();
                    //intent.putExtras(bundle);

                    //mContext.startActivity(intent);
                }
            });
        }
    }

    public static void reset(View v, int position){
        MaterialIconView star = (MaterialIconView) v;
        if(mFavorites.get(position)){
            star.setColor(Color.GRAY);
            mFavorites.set(position, false);
        } else {
            star.setColor(Color.parseColor("#009688"));
            mFavorites.set(position, true);
        }
        v.setScaleX(1);
        v.setScaleY(1);
        v.setAlpha(1);
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View menuView = inflater.inflate(R.layout.item_recycler_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(menuView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder viewHolder, int position) {
        final String currentString = mStrings.get(position);

        TextView name = viewHolder.StringName;
        TextView description = viewHolder.StringDescription;

        if (mFavorites.get(position)) {
            viewHolder.star.setColor(Color.parseColor("#009688"));
        } else {
            viewHolder.star.setColor(Color.GRAY);
        }

        final ViewHolder vH = viewHolder;

        final int index = position;
        viewHolder.star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final View view = v;
                vH.mExplosionField.explode(v);

                new CountDownTimer(1100, 1000) {
                    public void onFinish() {
                        reset(view, index);
                        sOnFavoriteCallback.onFavorited(index);
                    }
                    public void onTick(long millisUntilFinished) {
                        // millisUntilFinished
                    }
                }.start();
            }
        });

        name.setText(currentString);
        //description.setText();
    }

    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    public interface OnFavoriteListener {
        void onFavorited(int position);
    }

}