package org.smv.smvguide.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;
import org.smv.smvguide.R;
import org.smv.smvguide.rest.models.Acf;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ScrollingPostActivity extends AppCompatActivity {

    //@Bind(R.id.webView)
    //public WebView mWeb;

    @Bind(R.id.backdrop)
    public ImageView mBackdrop;
    
    @Bind(R.id.header1)
    public TextView mHeader1;
    
    @Bind(R.id.body1)
    public TextView mBody1;
    
    @Bind(R.id.image1)
    public ImageView mImage1;

    @Bind(R.id.header2)
    public TextView mHeader2;

    @Bind(R.id.body2)
    public TextView mBody2;

    @Bind(R.id.image2)
    public ImageView mImage2;

    @Bind(R.id.header3)
    public TextView mHeader3;

    @Bind(R.id.body3)
    public TextView mBody3;

    @Bind(R.id.image3)
    public ImageView mImage3;

    @Bind(R.id.header4)
    public TextView mHeader4;

    @Bind(R.id.body4)
    public TextView mBody4;

    @Bind(R.id.image4)
    public ImageView mImage4;

    @Bind(R.id.header5)
    public TextView mHeader5;

    @Bind(R.id.body5)
    public TextView mBody5;

    @Bind(R.id.image5)
    public ImageView mImage5;
    
    public Acf mainPost;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_post);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String title = intent.getStringExtra("Title");

        if (null != intent.getExtras().getParcelable("post")) {
            mainPost = Parcels.unwrap(intent.getExtras()
                    .getParcelable("post"));
            Log.d("It worked?", mainPost.getEstimote().toString());
            stopDropOpenUpShop();
        }

        getSupportActionBar().setTitle(title);



        /*final String mimeType = "text/html";
        final String encoding = "UTF-8";

        mWeb.getSettings().setLoadWithOverviewMode(true);
        mWeb.getSettings().setUseWideViewPort(true);

        mWeb.loadDataWithBaseURL("", content, mimeType, encoding, "");*/

        //mtext.setText(Html.fromHtml(content));

/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                  //      .setAction("Action", null).show();
            }
        });*/
    }
    
    public void stopDropOpenUpShop(){
        if (mainPost.getParagraph1head() != null && !mainPost.getParagraph1head().equals("") && !mainPost.getParagraph1head().equals("false")){
            mHeader1.setText(mainPost.getParagraph1head());
        } else {
            mHeader1.setVisibility(View.GONE);
        }

        if (mainPost.getParagraph2head() != null && !mainPost.getParagraph2head().equals("") && !mainPost.getParagraph2head().equals("false")){
            mHeader2.setText(mainPost.getParagraph2head());
        } else {
            mHeader2.setVisibility(View.GONE);
        }

        if (mainPost.getParagraph3head() != null && !mainPost.getParagraph3head().equals("") && !mainPost.getParagraph3head().equals("false")){
            mHeader3.setText(mainPost.getParagraph3head());
        } else {
            mHeader3.setVisibility(View.GONE);
        }

        if (mainPost.getParagraph4head() != null && !mainPost.getParagraph4head().equals("") && !mainPost.getParagraph4head().equals("false")){
            mHeader4.setText(mainPost.getParagraph4head());
        } else {
            mHeader4.setVisibility(View.GONE);
        }

        if (mainPost.getParagraph5head() != null && !mainPost.getParagraph5head().equals("") && !mainPost.getParagraph5head().equals("false")){
            mHeader5.setText(mainPost.getParagraph5head());
        } else {
            mHeader5.setVisibility(View.GONE);
        }

        if (mainPost.getTextbody1() != null && !mainPost.getTextbody1().equals("") && !mainPost.getTextbody1().equals("false")){
            mBody1.setText(mainPost.getTextbody1());
        } else {
            mBody1.setVisibility(View.GONE);
        }

        if (mainPost.getTextbody2() != null && !mainPost.getTextbody2().equals("") && !mainPost.getTextbody2().equals("false")){
            mBody2.setText(mainPost.getTextbody2());
        } else {
            mBody2.setVisibility(View.GONE);
        }

        if (mainPost.getTextbody3() != null && !mainPost.getTextbody3().equals("") && !mainPost.getTextbody3().equals("false")){
            mBody3.setText(mainPost.getTextbody3());
        } else {
            mBody3.setVisibility(View.GONE);
        }

        if (mainPost.getTextbody4() != null && !mainPost.getTextbody4().equals("") && !mainPost.getTextbody4().equals("false")){
            mBody4.setText(mainPost.getTextbody4());
        } else {
            mBody4.setVisibility(View.GONE);
        }

        if (mainPost.getTextbody5() != null && !mainPost.getTextbody5().equals("") && !mainPost.getTextbody5().equals("false")){
            mBody5.setText(mainPost.getTextbody5());
        } else {
            mBody5.setVisibility(View.GONE);
        }

        if (mainPost.getPhoto1() != null && !mainPost.getPhoto1().equals("") && !mainPost.getPhoto1().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getPhoto1())
                    .into(mImage1);
        } else {
            mImage1.setVisibility(View.GONE);
        }

        if (mainPost.getPhoto2() != null && !mainPost.getPhoto2().equals("") && !mainPost.getPhoto2().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getPhoto2())
                    .into(mImage2);
        } else {
            mImage2.setVisibility(View.GONE);
        }

        if (mainPost.getPhoto3() != null && !mainPost.getPhoto3().equals("") && !mainPost.getPhoto3().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getPhoto3())
                    .into(mImage3);
        } else {
            mImage3.setVisibility(View.GONE);
        }

        if (mainPost.getPhoto4() != null && !mainPost.getPhoto4().equals("") && !mainPost.getPhoto4().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getPhoto4())
                    .into(mImage4);
        } else {
            mImage4.setVisibility(View.GONE);
        }

        if (mainPost.getPhoto5() != null && !mainPost.getPhoto5().equals("") && !mainPost.getPhoto5().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getPhoto5())
                    .into(mImage5);
        } else {
            mImage5.setVisibility(View.GONE);
        }

        if (mainPost.getFeaturedappimage() != null && !mainPost.getFeaturedappimage().equals("") && !mainPost.getFeaturedappimage().equals("false")){
            Picasso.with(this)
                    .load(mainPost.getFeaturedappimage())
                    .into(mBackdrop);
        }

        
    }
}
