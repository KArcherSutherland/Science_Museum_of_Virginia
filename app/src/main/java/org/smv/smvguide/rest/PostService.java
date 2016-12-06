package org.smv.smvguide.rest;

import org.smv.smvguide.rest.models.Results;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by root on 12/5/16.
 */
public interface PostService {

    @GET("posts")
    Call<ArrayList<Results>> getPosts();

/*    @GET("User")
    Call<Results> getUser(@Query(value = "where",encoded = false) JSONObject stuff);

    @GET("_User/{id}")
    Call<Results> getREALUser(@Path("id") String id);*/

}