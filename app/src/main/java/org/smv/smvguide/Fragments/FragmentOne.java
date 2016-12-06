package org.smv.smvguide.Fragments;

/**
 * Created by rhey on 9/26/16.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.smv.smvguide.Adapters.RecyclerAdapter;
import org.smv.smvguide.R;
import org.smv.smvguide.rest.PostService;
import org.smv.smvguide.rest.RestClient;
import org.smv.smvguide.rest.models.Results;

import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class FragmentOne extends Fragment implements RecyclerAdapter.OnFavoriteListener{

    private RecyclerView recyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private View mView;
    private RecyclerAdapter mAdapter;
    private List<String> exampleList;
    private ArrayList<Results> mList;
    private PostService mService;

    public FragmentOne() {
        // Required empty public constructor
    }
    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_one, container, false);
        mService = RestClient.getRetrofit().create(PostService.class);
        getPosts();
        //setList();


        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshItems();
            }
        });



        Toast.makeText(getActivity(), "Fragment One",
                Toast.LENGTH_LONG).show();

        return mView;
    }

    public void refreshItems() {
        setList();
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete(){
        viewRecycler();
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void viewRecycler(){
        recyclerView = (RecyclerView) mView.findViewById(R.id.recyclerList);
        mAdapter = new RecyclerAdapter(mList, getActivity(), this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemViewCacheSize(300);
    }

    public void setList(){
        exampleList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            exampleList.add("Example " + i);
        }
    }

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onFavorited(int position) {
        //if needed
    }
}