package org.smv.smvguide.rest.models;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by root on 2/10/17.
 */
public class RequestObject {

    public RequestObject (Context context){

    }

/*
    private void getPosts(){
        Call<ArrayList<Results>> call = mService.getPosts();
        call.enqueue(new Callback<ArrayList<Results>>() {
            @Override
            public void onResponse(Response<ArrayList<Results>> response, Retrofit retrofit) {
                mList = response.body();
                viewRecycler();
                //ArrayList<Results> posts = response.body.getPosts();
                Log.d("mom get the camera", "  :D");
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("don't even", t.toString() + "  " + t.getLocalizedMessage());
            }
        });
    }
*/

    public interface OnPostsRetrievedListener{
        void onPostRetrieved();
    }
}
