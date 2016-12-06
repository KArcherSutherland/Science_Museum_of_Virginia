package org.smv.smvguide.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import org.smv.smvguide.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollingPostActivity extends AppCompatActivity {

    @Bind(R.id.webView)
    public WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_post);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String content = intent.getStringExtra("Content");
        String title = intent.getStringExtra("Title");

        getSupportActionBar().setTitle(title);

        final String mimeType = "text/html";
        final String encoding = "UTF-8";

        mWeb.loadDataWithBaseURL("", content, mimeType, encoding, "");

        //mtext.setText(Html.fromHtml(content));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
