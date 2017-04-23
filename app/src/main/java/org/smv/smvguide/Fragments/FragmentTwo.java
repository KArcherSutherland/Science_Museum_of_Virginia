package org.smv.smvguide.Fragments;

/**
 * Created by rhey on 9/26/16.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import org.smv.smvguide.R;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FragmentTwo extends Fragment {

    @Bind(R.id.webView)
    public WebView mWeb;
    private View mView;

    public FragmentTwo() {
        // Required empty public constructor
    }
    public static FragmentTwo newInstance() {
        FragmentTwo fragment = new FragmentTwo();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        class MyJavaScriptInterface
        {
            @JavascriptInterface
            @SuppressWarnings("unused")
            public void processHTML(String html)
            {
                // process the html as needed by the app
            }
        }


        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_two, container, false);
        mWeb = (WebView) mView.findViewById(R.id.webView);
        mWeb.setWebViewClient(new WebViewClient());
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT" );


        
        if (mWeb != null){
            mWeb.loadUrl("http://www.smvhistory.org/timeline");
        }
      //  mWeb.loadUrl( "javascript: document.getElementById('masthead').remove();");

        return mView;

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}