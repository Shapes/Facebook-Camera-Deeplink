package com.example.markobalazic.facebookshare;

import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "";
    CallbackManager callbackManager;
    ShareDialog shareDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {

        /*
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, "nek input text");
        startActivity(intent);
        */

        /*
        ShareLinkContent content = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("https://developers.facebook.com"))
                .build();
        */

        /*
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");

        share.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("http://nexto.io/wp-content/themes/nexto_new/images/StoriesMap.jpg"));

        startActivity(Intent.createChooser(share, "Share Image"));
        */

        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    .setContentUrl(Uri.parse("www.facebook.com/fbcameraeffects/tryit/139292940110980/"))
                    .build();
            shareDialog.show(linkContent);
        }
    }

    /** Called when the user taps the Send button */
    public void shareEverywhere(View view) {

        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/jpeg");

        share.putExtra(Intent.EXTRA_STREAM,
                Uri.parse("www.facebook.com/fbcameraeffects/tryit/139292940110980/"));

        startActivity(Intent.createChooser(share, "Share Image"));

    }

    public void openFacebookCamera(View view){
        Intent facebookAppIntent;
        try {
            //facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://camera"));
            facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://inspirationscamera/?effectID=171697676764248"));
            startActivity(facebookAppIntent);
        } catch (ActivityNotFoundException e) {
            facebookAppIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.facebook.com/fbcameraeffects/tryit/139292940110980/"));
            startActivity(facebookAppIntent);
        }
    }


}
